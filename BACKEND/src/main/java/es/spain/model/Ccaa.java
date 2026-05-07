package es.spain.model;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ccaa")
public class Ccaa {

    @Id
    @Column(name = "idccaa")
    private Long idCcaa;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    /* Relación 1‑N con provincias */
    @OneToMany(mappedBy = "ccaa", fetch = FetchType.LAZY)
    private Set<Provincia> provincias;

    public Set<Provincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(Set<Provincia> provincias) {
        this.provincias = provincias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getIdCcaa() {
        return idCcaa;
    }

    public void setIdCcaa(Long idCcaa) {
        this.idCcaa = idCcaa;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ccaa ccaa = (Ccaa) o;
        return Objects.equals(idCcaa, ccaa.idCcaa) && Objects.equals(nombre, ccaa.nombre) && Objects.equals(provincias, ccaa.provincias);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCcaa, nombre, provincias);
    }
}
