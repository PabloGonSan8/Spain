package es.spain.controller;

import es.spain.dto.CcaaProvinciasLocalidadesDTO;
import es.spain.dto.LocalidadNombreDTO;
import es.spain.dto.ProvinciaLocalidadDTO;
import es.spain.repository.CcaaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    private CcaaRepository ccaaRepository;

    @GetMapping("/")
    public List<CcaaProvinciasLocalidadesDTO> getCcaaWithProvinciasAndLocalidades() {
        return ccaaRepository.findAll().stream()
                .map(ccaa -> {
                    List<ProvinciaLocalidadDTO> provinciaLocalidadDtos = ccaa.getProvincias().stream()
                            .map(provincia -> {
                                List<LocalidadNombreDTO> localidadDtos = provincia.getLocalidades().stream()
                                        .map(localidad -> new LocalidadNombreDTO(localidad.getNombre()))
                                        .toList();

                                return new ProvinciaLocalidadDTO(provincia.getNombre(), localidadDtos);
                            })
                            .toList();

                    return new CcaaProvinciasLocalidadesDTO(ccaa.getNombre(), provinciaLocalidadDtos);
                })
                .toList();
    }
}
