package es.spain.dto;

public class ProvinciaCcaaDTO {

    private String provincia;
    private String ccaa;

    public ProvinciaCcaaDTO(String provincia, String ccaa) {
        this.provincia = provincia;
        this.ccaa = ccaa;
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
}
