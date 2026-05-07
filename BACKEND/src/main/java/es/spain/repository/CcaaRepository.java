package es.spain.repository;

import es.spain.model.Ccaa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CcaaRepository extends JpaRepository<Ccaa, Long> {

    @Query("SELECT c FROM Ccaa c LEFT JOIN FETCH c.provincias")
    List<Ccaa> findAllWithProvincias();

    @Query("SELECT DISTINCT c FROM Ccaa c LEFT JOIN FETCH c.provincias p LEFT JOIN FETCH p.localidades")
    List<Ccaa> findAllWithProvinciasAndLocalidades();

    @Query("SELECT c FROM Ccaa c WHERE LOWER(c.nombre) = LOWER(:name)")
    Optional<Ccaa> findByNombreIgnoreCase(@Param("name") String name);
}
