package com.jjeneral.falabella.challenge.service;

import com.jjeneral.falabella.challenge.exception.ProductNotFoundException;
import com.jjeneral.falabella.challenge.model.dto.ProductDto;
import com.jjeneral.falabella.challenge.model.entity.Product;
import com.jjeneral.falabella.challenge.repository.ProductRepository;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        return repository.findAll().stream()
                .map(product -> conversionService.convert(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto findBySku(String sku) {
        return Optional.ofNullable(repository.findFirstBySku(sku))
                .map(product -> conversionService.convert(product, ProductDto.class))
                .orElseThrow(() -> new ProductNotFoundException("No product exist by SKU: " + sku));
    }

    @Override
    public void update(String sku, ProductDto productDto) {
        Product product = repository.findFirstBySku(sku);

    }

    @Override
    public void delete(String sku) {

    }
}
