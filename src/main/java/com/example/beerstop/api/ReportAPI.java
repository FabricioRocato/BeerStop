package com.example.beerstop.api;

import com.example.beerstop.entity.ProductSalesDTO;
import com.example.beerstop.service.ReportService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api
@RestController
@RequestMapping("reports")
public class ReportAPI {

    @Autowired
    private ReportService service;

    @GetMapping("/produto-mais-vendido")
    public List<ProductSalesDTO> ProdutoMaisVendido() {
        return service.ProdutoMaisVendido();
    }
}