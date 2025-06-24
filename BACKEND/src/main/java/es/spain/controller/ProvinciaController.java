package es.spain.controller;

import es.spain.dto.LocalidadDTO;
import es.spain.dto.LocalidadNombreDTO;
import es.spain.dto.ProvinciaDTO;
import es.spain.dto.ProvinciaLocalidadDto;
import es.spain.model.Provincia;
import es.spain.repository.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public ProvinciaDTO getProvinciaByName(@RequestParam(value = "name") String name){
        return provinciaRepository.findAll().stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(name))
                .findFirst()
                .map(this::mapToDto)
                .orElseThrow();
    }


    @GetMapping("localidades")
    public List<ProvinciaLocalidadDto> getProvinciaLocalidad() {
        return provinciaRepository.findAll().stream()
                .map(provincia -> {
                    List<LocalidadNombreDTO> localidadDtos = provincia.getLocalidades().stream()
                            .map(loc -> new LocalidadNombreDTO(loc.getNombre()))
                            .toList();
                    return new ProvinciaLocalidadDto(provincia.getNombre(), localidadDtos);
                })
                .toList();
    }


}
