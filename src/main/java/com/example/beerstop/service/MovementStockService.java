package com.example.beerstop.service;

import com.example.beerstop.entity.Comanda;
import com.example.beerstop.entity.ItemComanda;
import com.example.beerstop.entity.Product;
import com.example.beerstop.entity.Status;
import com.example.beerstop.repository.ComandaRepository;
import com.example.beerstop.repository.MovementStockRepository;
import com.example.beerstop.repository.ProductRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class MovementStockService {

    @Autowired
    public ComandaRepository repository;

    @Autowired
    public MovementStockRepository movementStockRepository;

    @Autowired
    private ProductRepository productRepository;

    public Comanda closeComanda(Long comandaId) {
        var comanda = repository.closeComanda(comandaId);
        comanda.setStatus(Status.CLOSED);
        return comanda;
    }

    public Comanda finishMovement(Long comandaId) {
        Comanda item = closeComanda(comandaId);
        var itens = item.getItens();
        for (ItemComanda command : itens){
            var itenComandaId = repository.getId(command.getId());
            var stock = repository.moveStock(comandaId,itenComandaId);
            command.getProduto().setQuantityInStock(stock);
        }
        return item;
    }

    public Product entradaStock(Long productId, int quantity) {
        var produto = productRepository.findProductId(productId);
        productRepository.updateStock(quantity,productId);
        return produto;
    }
}
