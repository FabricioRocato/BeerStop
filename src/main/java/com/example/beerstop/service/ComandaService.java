package com.example.beerstop.service;

import com.example.beerstop.entity.Comanda;
import com.example.beerstop.entity.ItemComanda;
import com.example.beerstop.repository.ComandaRepository;
import com.example.beerstop.repository.ItemComandaRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ComandaService {

    @Autowired
    private ComandaRepository repository;

    private ItemComandaRepository itemComandaRepository;

        @Transactional
        public Comanda save(Comanda comanda) {
            return repository.save(comanda);
        }

    public Page<Comanda> findAllByOrderByIdDesc(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("id").descending());
        Page<Comanda> comandasPage = repository.findAll(pageable);
        // Inicialize os itens de comanda com os produtos
        comandasPage.getContent().forEach(comanda -> Hibernate.initialize(comanda.getItens()));

        return comandasPage;
    }


    public Optional<Comanda> findComanda(Long comandaId) {
        return repository.findById(comandaId);
    }

    public void deleteById(Long comandaId) {
        repository.deleteById(comandaId);
    }

}
