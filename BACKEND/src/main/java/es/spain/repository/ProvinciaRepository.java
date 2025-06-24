package es.spain.repository;

import es.spain.model.Ccaa;
import es.spain.model.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProvinciaRepository extends JpaRepository<Provincia, Long> {
    List<Provincia> findByCcaa_IdCcaa(Long idCcaa);
}
