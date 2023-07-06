package com.example.beerstop.api;

import com.example.beerstop.entity.CustomerConsumistaDTO;
import com.example.beerstop.entity.Movement;
import com.example.beerstop.entity.Product;
import com.example.beerstop.entity.ProductSalesDTO;
import com.example.beerstop.service.MovementStockService;
import com.example.beerstop.service.ProductService;
import com.example.beerstop.service.ReportService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api
@RestController
@RequestMapping("reports")
public class ReportAPI {

    @Autowired
    private ReportService service;

    @Autowired
    private ProductService productService;

    @Autowired
    private MovementStockService movementStockService;

    @GetMapping("/produto-mais-vendido")
    public List<ProductSalesDTO> ProdutoMaisVendido() {
        return service.ProdutoMaisVendido();
    }

    @GetMapping("/produto-estoque")
    public List<Product> ProdutoEstoque() {
        return productService.ProdutoEstoque();
    }

    @GetMapping("/entrada-estoque")
    public List<Movement> EntradaEstoque() {
        return movementStockService.EntradaEstoque();
    }

    @GetMapping("/saida-estoque")
    public List<Movement> SaidaEstoque() {
        return movementStockService.SaidaEstoque();
    }

    @GetMapping("/cliente-consumista")
    public List<CustomerConsumistaDTO> ClienteConsumista() {
        return service.ClienteConsumista();
    }

}