package es.spain.controller;

import es.spain.dto.*;
import es.spain.repository.CcaaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/ccaa")
public class CcaaController {

    @Autowired
    private CcaaRepository ccaaRepository;

    @GetMapping
    public List<CcaaDTO> getAllCcaa() {
        return ccaaRepository.findAll().stream()
                .map(c -> new CcaaDTO(c.getNombre()))
                .toList();
    }

    @GetMapping("byName")
    public CcaaDTO getCcaaByName(@RequestParam String name) {
        return ccaaRepository.findByNombreIgnoreCase(name)
                .map(c -> new CcaaDTO(c.getNombre()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("provincia")
    public List<CcaaProvinciaDTO> getCcaaProvincia() {
        return ccaaRepository.findAllWithProvincias().stream()
                .map(ccaa -> {
                    List<ProvinciaDTO> provinciaDtos = ccaa.getProvincias().stream()
                            .map(p -> new ProvinciaDTO(p.getNombre()))
                            .toList();
                    return new CcaaProvinciaDTO(ccaa.getNombre(), provinciaDtos);
                })
                .toList();
    }
}
