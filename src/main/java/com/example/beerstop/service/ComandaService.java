package com.example.beerstop.service;

import com.example.beerstop.entity.Comanda;
import com.example.beerstop.repository.ComandaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ComandaService {

    @Autowired
    private ComandaRepository repository;

    public void save(Comanda comanda) {
        repository.save(comanda);
    }

    public Page<Comanda> findAllByOrderByIdDesc(int pageNumber,int pageSize){
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        return repository.findAllByOrderByIdDesc(pageable);
    }

    public Page<Comanda> findByCustomerIdOrderByIdDesc(int pageNumber, int pageSize, Long comanda){
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        return repository.findByCustomerIdOrderByIdDesc(pageable, comanda);
    }

    public Optional<Comanda> findComanda(Long comandaId) {
        return repository.findById(comandaId);
    }

    public void deleteById(Long comandaId) {
        repository.deleteById(comandaId);
    }

}
