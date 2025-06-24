package es.spain.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "provincias")
public class Provincia {

        @Id
        @Column(name = "idProvincia")
        private Long idProvincia;

        @Column(name = "Nombre", nullable = false, length = 50)
        private String nombre;

        /* FK hacia CCAA */
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "codCcaa")
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
}
