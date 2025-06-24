package es.spain.repository;

import es.spain.model.Localidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocalidadRepository extends JpaRepository<Localidad, Long> {
    List<Localidad> findByProvincia_IdProvincia(Long idProvincia);
}
