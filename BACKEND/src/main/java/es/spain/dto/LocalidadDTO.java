package es.spain.dto;

import java.util.Objects;

public class LocalidadDTO {
    private String localidad;
    private String provincia;
    private String ccaa;

    public LocalidadDTO(String localidad, String provincia, String ccaa) {
        this.localidad = localidad;
        this.provincia = provincia;
        this.ccaa = ccaa;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCcaa() {
        return ccaa;
    }

    public void setCcaa(String ccaa) {
        this.ccaa = ccaa;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LocalidadDTO that = (LocalidadDTO) o;
        return Objects.equals(localidad, that.localidad) && Objects.equals(provincia, that.provincia) && Objects.equals(ccaa, that.ccaa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(localidad, provincia, ccaa);
    }
}
