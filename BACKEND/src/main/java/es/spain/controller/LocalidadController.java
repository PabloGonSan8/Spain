package es.spain.controller;

import es.spain.dto.LocalidadDTO;
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

    @GetMapping
    public List<LocalidadDTO> getAllLocalidad() {
        return localidadRepository.findAllWithProvinciaAndCcaa().stream()
                .map(l -> new LocalidadDTO(l.getNombre(), l.getProvincia().getNombre(), l.getProvincia().getCcaa().getNombre()))
                .toList();
    }

    @GetMapping("byName")
    public LocalidadDTO getLocalidadByName(@RequestParam String name) {
        return localidadRepository.findByNombreIgnoreCaseWithProvincia(name)
                .map(l -> new LocalidadDTO(l.getNombre(), l.getProvincia().getNombre(), l.getProvincia().getCcaa().getNombre()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
