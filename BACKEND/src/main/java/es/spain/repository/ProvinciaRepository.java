package es.spain.repository;

import es.spain.model.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProvinciaRepository extends JpaRepository<Provincia, Long> {

    List<Provincia> findByCcaa_IdCcaa(Long idCcaa);

    @Query("SELECT p FROM Provincia p LEFT JOIN FETCH p.localidades")
    List<Provincia> findAllWithLocalidades();

    @Query("SELECT p FROM Provincia p JOIN FETCH p.ccaa WHERE LOWER(p.nombre) = LOWER(:name)")
    Optional<Provincia> findByNombreIgnoreCaseWithCcaa(@Param("name") String name);
}
