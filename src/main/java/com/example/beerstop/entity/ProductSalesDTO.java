package com.example.beerstop.entity;

public class ProductSalesDTO {
        private Long id;
        private String name;
        private Long totalSold;

        public ProductSalesDTO(Long id, String name, Long totalSold) {
            this.id = id;
            this.name = name;
            this.totalSold = totalSold;
        }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTotalSold() {
        return totalSold;
    }

    public void setTotalSold(Long totalSold) {
        this.totalSold = totalSold;
    }
}
