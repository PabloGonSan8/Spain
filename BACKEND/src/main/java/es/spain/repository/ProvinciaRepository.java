package es.spain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.spain.model.Provincia;

public interface ProvinciaRepository extends JpaRepository<Provincia, Long> {
    List<Provincia> findByCcaa_IdCcaa(Long idCcaa);
}
