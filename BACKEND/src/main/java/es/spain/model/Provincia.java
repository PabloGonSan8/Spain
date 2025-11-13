package es.spain.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "provincias")
public class Provincia {

        @Id
        @Column(name = "idprovincia")
        private Long idProvincia;

        @Column(name = "nombre", nullable = false, length = 50)
        private String nombre;

        /* FK hacia CCAA */
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "codccaa")
        private Ccaa ccaa;

    /* Relación con Localidad */
    @OneToMany(mappedBy = "provincia", fetch = FetchType.LAZY)
    private List<Localidad> localidades;

    public List<Localidad> getLocalidades() {
        return localidades;
    }

    public void setLocalidades(List<Localidad> localidades) {
        this.localidades = localidades;
    }

    public Long getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(Long idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Ccaa getCcaa() {
        return ccaa;
    }

    public void setCcaa(Ccaa ccaa) {
        this.ccaa = ccaa;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Provincia provincia = (Provincia) o;
        return Objects.equals(idProvincia, provincia.idProvincia) && Objects.equals(nombre, provincia.nombre) && Objects.equals(ccaa, provincia.ccaa) && Objects.equals(localidades, provincia.localidades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProvincia, nombre, ccaa, localidades);
    }
}
