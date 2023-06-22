package com.example.beerstop.service;

import com.example.beerstop.entity.Comanda;
import com.example.beerstop.entity.ItemComanda;
import com.example.beerstop.entity.Status;
import com.example.beerstop.repository.ComandaRepository;
import com.example.beerstop.repository.MovementStockRepository;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MovementStockService {

    @Autowired
    public ComandaRepository repository;

    public Comanda closeComanda(Long comandaId) {
        var comanda = repository.closeComanda(comandaId);
        comanda.setStatus(Status.CLOSED);
        return comanda;
    }

    public Comanda finishMovement(Long comandaId) {
        Comanda item = repository.closeComanda(comandaId);
        var itens = item.getItens();
        for (ItemComanda command : itens){
            var itenComandaId = repository.getId(command.getId());
            var stock = repository.moveStock(comandaId,itenComandaId);
            command.getProduto().setQuantityInStock(stock);
        }
        return item;
    }
}
