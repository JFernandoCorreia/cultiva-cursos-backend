package com.FlorDaCidade.repository;

import com.FlorDaCidade.model.ListaEspera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaEsperaRepository extends JpaRepository<ListaEspera, Long> {

}
