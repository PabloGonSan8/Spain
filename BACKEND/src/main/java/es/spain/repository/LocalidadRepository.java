package es.spain.repository;

import es.spain.model.Localidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LocalidadRepository extends JpaRepository<Localidad, Long> {

    List<Localidad> findByProvincia_IdProvincia(Long idProvincia);

    @Query("SELECT l FROM Localidad l JOIN FETCH l.provincia p JOIN FETCH p.ccaa")
    List<Localidad> findAllWithProvinciaAndCcaa();

    @Query("SELECT l FROM Localidad l JOIN FETCH l.provincia p JOIN FETCH p.ccaa WHERE LOWER(l.nombre) = LOWER(:name)")
    Optional<Localidad> findByNombreIgnoreCaseWithProvincia(@Param("name") String name);
}
