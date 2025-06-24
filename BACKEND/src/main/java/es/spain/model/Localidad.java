package es.spain.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "localidades")
public class Localidad {

        @Id
        @Column(name = "idLocalidad")
        private Long idLocalidad;

        @Column(name = "Nombre", nullable = false, length = 50)
        private String nombre;

        /* FK hacia Provincia */
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "codProvincia")
        private Provincia provincia;

        public Long getIdLocalidad() {
            return idLocalidad;
        }

        public void setIdLocalidad(Long idLocalidad) {
            this.idLocalidad = idLocalidad;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public Provincia getProvincia() {
            return provincia;
        }

        public void setProvincia(Provincia provincia) {
            this.provincia = provincia;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Localidad localidad = (Localidad) o;
            return Objects.equals(idLocalidad, localidad.idLocalidad) && Objects.equals(nombre, localidad.nombre) && Objects.equals(provincia, localidad.provincia);
        }

        @Override
        public int hashCode() {
            return Objects.hash(idLocalidad, nombre, provincia);
        }
    }
