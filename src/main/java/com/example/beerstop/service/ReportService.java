package com.example.beerstop.service;

import com.example.beerstop.entity.CustomerConsumistaDTO;
import com.example.beerstop.entity.Product;
import com.example.beerstop.entity.ProductSalesDTO;
import com.example.beerstop.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ReportService {

    @Autowired
    private ReportRepository repository;

        public List<ProductSalesDTO> ProdutoMaisVendido() {
            List<Object[]> results = repository.ProdutoMaisVendido();
            List<ProductSalesDTO> dtos = new ArrayList<>();

            for (Object[] result : results) {
                Long id = (Long) result[0];
                String name = (String) result[1];
                Long totalSold = (Long) result[2];

                ProductSalesDTO dto = new ProductSalesDTO(id, name, totalSold);
                dtos.add(dto);
            }

            return dtos;
        }

    public List<CustomerConsumistaDTO> ClienteConsumista() {
        List<Object[]> results = repository.ClienteConsumista();
        List<CustomerConsumistaDTO> dtos = new ArrayList<>();

        for (Object[] result : results) {
            Long id = (Long) result[0];
            String name = (String) result[1];
            Long totalSold = (Long) result[2];

            CustomerConsumistaDTO dto = new CustomerConsumistaDTO(id, name, totalSold);
            dtos.add(dto);
        }

        return dtos;
    }
}