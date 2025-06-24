package es.spain.dto;


import java.util.List;


public class CcaaProvinciaDTO {
    private String nombre;
    private List<ProvinciaDTO> provincias;

    public CcaaProvinciaDTO(String nombre, List<ProvinciaDTO> provincias) {
        this.nombre = nombre;
        this.provincias = provincias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<ProvinciaDTO> getProvincias() {
        return provincias;
    }

    public void setProvincias(List<ProvinciaDTO> provincias) {
        this.provincias = provincias;
    }
}
