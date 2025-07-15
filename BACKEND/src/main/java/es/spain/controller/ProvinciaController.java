package es.spain.controller;

import es.spain.dto.LocalidadNombreDTO;
import es.spain.dto.ProvinciaCcaaDTO;
import es.spain.dto.ProvinciaDTO;
import es.spain.dto.ProvinciaLocalidadDTO;
import es.spain.model.Provincia;
import es.spain.repository.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/provincias")
public class ProvinciaController {

    @Autowired
    private ProvinciaRepository provinciaRepository;

    private ProvinciaDTO mapToDto(Provincia provincia){
        return new ProvinciaDTO(provincia.getNombre());
    }

    @GetMapping
    public List<ProvinciaDTO> getAllProvincias(){
        return provinciaRepository.findAll().stream().map(this::mapToDto).toList();
    }


    @GetMapping("byName")
    public ProvinciaCcaaDTO getProvinciaByName(@RequestParam(value = "name") String name) {
        return provinciaRepository.findAll().stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(name))
                .findFirst()
                .map(provincia -> {
                    String ccaaNombre = provincia.getCcaa().getNombre(); // <-- obtener nombre de la CCAA
                    return new ProvinciaCcaaDTO(provincia.getNombre(), ccaaNombre);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


    @GetMapping("localidades")
    public List<ProvinciaLocalidadDTO> getProvinciaLocalidad() {
        return provinciaRepository.findAll().stream()
                .map(provincia -> {
                    List<LocalidadNombreDTO> localidadDtos = provincia.getLocalidades().stream()
                            .map(loc -> new LocalidadNombreDTO(loc.getNombre()))
                            .toList();
                    return new ProvinciaLocalidadDTO(provincia.getNombre(), localidadDtos);
                })
                .toList();
    }


}
