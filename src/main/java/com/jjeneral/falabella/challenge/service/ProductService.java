package com.jjeneral.falabella.challenge.service;

import com.jjeneral.falabella.challenge.model.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto create(ProductDto productDto);
    List<ProductDto> getAll();
    ProductDto findBySku(String sku);
    void update(String sku, ProductDto productDto);
    void delete(String sku);

}
