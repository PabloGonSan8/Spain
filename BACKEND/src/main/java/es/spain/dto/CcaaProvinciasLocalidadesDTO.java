package es.spain.dto;

import java.util.List;

public class CcaaProvinciasLocalidadesDTO {
    private String nombre;
    private List<ProvinciaLocalidadDTO> localidades;

    public CcaaProvinciasLocalidadesDTO(String nombre, List<ProvinciaLocalidadDTO> localidades) {
        this.nombre = nombre;
        this.localidades = localidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<ProvinciaLocalidadDTO> getLocalidades() {
        return localidades;
    }

    public void setLocalidades(List<ProvinciaLocalidadDTO> localidades) {
        this.localidades = localidades;
    }
}
