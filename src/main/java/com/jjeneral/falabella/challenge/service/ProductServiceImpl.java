package com.jjeneral.falabella.challenge.service;

import com.jjeneral.falabella.challenge.model.dto.ProductDto;
import com.jjeneral.falabella.challenge.model.entity.Product;
import com.jjeneral.falabella.challenge.repository.ProductRepository;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository repository;
    private ConversionService conversionService;

    public ProductServiceImpl(ProductRepository repository, ConversionService conversionService) {
        this.repository = repository;
        this.conversionService = conversionService;
    }

    @Override
    public ProductDto create(ProductDto productDto) {
        Product product = conversionService.convert(productDto, Product.class);
        Product newProduct = repository.save(product);
        return conversionService.convert(newProduct, ProductDto.class);
    }

    @Override
    public List<ProductDto> getAll() {
        return null;
    }

    @Override
    public ProductDto findBySku(String sku) {
        return null;
    }

    @Override
    public void update(String sku, ProductDto productDto) {

    }

    @Override
    public void delete(String sku) {

    }
}
