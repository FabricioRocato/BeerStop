package com.example.beerstop.service;

import com.example.beerstop.entity.*;
import com.example.beerstop.repository.ComandaRepository;
import com.example.beerstop.repository.MovementRepository;
import com.example.beerstop.repository.MovementStockRepository;
import com.example.beerstop.repository.ProductRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MovementStockService {

    @Autowired
    public ComandaRepository repository;

    @Autowired
    public MovementStockRepository movementStockRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MovementRepository movementRepository;

    public Movement save(Movement movement) {
        var produto = movement.getProduto().getId();
        int produtoQuantity = productRepository.getProductQuantity(movement.getProduto().getId());
        var quantity = movement.getQuantity();
        if (movement.getMovementType().equals(MovementType.SAIDA)){
            var move = produtoQuantity - quantity;
            productRepository.updateStock(move,produto);
            var mov = -quantity;
            movement.setQuantity(mov);
        } else {
            var move = produtoQuantity + quantity;
            productRepository.updateStock(move,produto);
        }
        movementRepository.save(movement);
        return movement;
    }

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

    public Product movementStock(Long productId, int quantity) {
        var produto = productRepository.findProductId(productId);
        var stock = produto.getQuantityInStock();
        productRepository.updateStock(quantity,productId);
        return produto;
    }

    public List<Movement> EntradaEstoque() {
        return movementRepository.EntradaEstoque();
    }

    public List<Movement> SaidaEstoque() {
        return movementRepository.SaidaEstoque();
    }
}
