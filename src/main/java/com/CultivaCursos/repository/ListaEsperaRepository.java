package com.CultivaCursos.repository;

import com.CultivaCursos.model.ListaEspera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaEsperaRepository extends JpaRepository<ListaEspera, Long> {

}
