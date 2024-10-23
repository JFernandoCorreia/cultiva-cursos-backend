package com.FlorDaCidade.service;

import com.FlorDaCidade.model.ListaEspera;
import com.FlorDaCidade.repository.ListaEsperaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListaEsperaService {

    @Autowired
    private ListaEsperaRepository listaEsperaRepository;

    public ListaEspera adicionarAListaEspera(ListaEspera listaEspera) {
        return listaEsperaRepository.save(listaEspera);
    }

    public List<ListaEspera> listarEspera() {
        return listaEsperaRepository.findAll();
    }

    // Outros métodos, se necessário
}
