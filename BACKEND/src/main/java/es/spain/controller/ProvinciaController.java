package es.spain.controller;

import es.spain.dto.LocalidadNombreDTO;
import es.spain.dto.ProvinciaCcaaDTO;
import es.spain.dto.ProvinciaDTO;
import es.spain.dto.ProvinciaLocalidadDTO;
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

    @GetMapping
    public List<ProvinciaDTO> getAllProvincias() {
        return provinciaRepository.findAll().stream()
                .map(p -> new ProvinciaDTO(p.getNombre()))
                .toList();
    }

    @GetMapping("byName")
    public ProvinciaCcaaDTO getProvinciaByName(@RequestParam String name) {
        return provinciaRepository.findByNombreIgnoreCaseWithCcaa(name)
                .map(p -> new ProvinciaCcaaDTO(p.getNombre(), p.getCcaa().getNombre()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("localidades")
    public List<ProvinciaLocalidadDTO> getProvinciaLocalidad() {
        return provinciaRepository.findAllWithLocalidades().stream()
                .map(provincia -> {
                    List<LocalidadNombreDTO> localidadDtos = provincia.getLocalidades().stream()
                            .map(loc -> new LocalidadNombreDTO(loc.getNombre()))
                            .toList();
                    return new ProvinciaLocalidadDTO(provincia.getNombre(), localidadDtos);
                })
                .toList();
    }
}
