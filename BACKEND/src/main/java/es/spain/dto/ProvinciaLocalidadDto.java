package es.spain.dto;

import java.util.List;

public class ProvinciaLocalidadDto {

    private String nombre;
    private List<LocalidadNombreDTO> localidades;

    public ProvinciaLocalidadDto(String nombre, List<LocalidadNombreDTO> localidades) {
        this.nombre = nombre;
        this.localidades = localidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<LocalidadNombreDTO> getLocalidades() {
        return localidades;
    }

    public void setLocalidades(List<LocalidadNombreDTO> localidades) {
        this.localidades = localidades;
    }
}
