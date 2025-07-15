package es.spain.controller;

import es.spain.dto.CcaaDTO;
import es.spain.dto.CcaaProvinciaDTO;
import es.spain.dto.ProvinciaDTO;
import es.spain.model.Ccaa;
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

    private CcaaDTO mapToDto(Ccaa ccaa){
        return new CcaaDTO(ccaa.getNombre());
    }

    @GetMapping
    public List<CcaaDTO> getAllCcaa(){
        return ccaaRepository.findAll().stream().map(this::mapToDto).toList();
    }

    @GetMapping("byName")
    public CcaaDTO getCcaaByName(@RequestParam(value = "name") String name){
        return ccaaRepository.findAll().stream()
                .filter(p-> p.getNombre().equalsIgnoreCase(name))
                .findFirst()
                .map(this::mapToDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("provincia")
    public List<CcaaProvinciaDTO> getCcaaProvincia(){
       return ccaaRepository.findAll().stream()
                .map(ccaa -> {
                    List<ProvinciaDTO> provinciaDtos = ccaa.getProvincias().stream()
                            .map(provincia -> new ProvinciaDTO(provincia.getNombre()))
                            .toList();
                    return new CcaaProvinciaDTO(ccaa.getNombre(), provinciaDtos);
                })
                .toList();
    }
}
