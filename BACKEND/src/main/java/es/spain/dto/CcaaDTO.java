package es.spain.dto;

import java.util.Objects;

public class CcaaDTO {

    private String nombre;

    public CcaaDTO( String nombre) {

        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CcaaDTO ccaaDTO = (CcaaDTO) o;
        return Objects.equals(nombre, ccaaDTO.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }
}
