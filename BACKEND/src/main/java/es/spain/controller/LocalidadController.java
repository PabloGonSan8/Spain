package es.spain.controller;

import es.spain.dto.LocalidadDTO;
import es.spain.model.Localidad;
import es.spain.repository.LocalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/localidades")
public class LocalidadController {

    @Autowired
    private LocalidadRepository localidadRepository;


    private LocalidadDTO mapToDto(Localidad localidad){
        return new LocalidadDTO(localidad.getNombre(),localidad.getProvincia().getNombre(),localidad.getProvincia().getCcaa().getNombre());
    }

    @GetMapping
    public List<LocalidadDTO> getAllLocalidad(){
        return localidadRepository.findAll().stream().map(this::mapToDto).toList();
    }

    @GetMapping("byName")
    public LocalidadDTO getLocalidadByName(@RequestParam(value = "name") String name){
        return localidadRepository.findAll().stream()
                .filter(l -> l.getNombre().equalsIgnoreCase(name))
                .findFirst()
                .map(this::mapToDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


}
