package com.jjeneral.falabella.challenge.service;

import com.jjeneral.falabella.challenge.exception.DuplicatedProductException;
import com.jjeneral.falabella.challenge.exception.ProductNotFoundException;
import com.jjeneral.falabella.challenge.model.dto.ProductDto;
import com.jjeneral.falabella.challenge.model.entity.Product;
import com.jjeneral.falabella.challenge.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    private ProductRepository repository;
    private ConversionService conversionService;

    public ProductServiceImpl(ProductRepository repository, ConversionService conversionService) {
        this.repository = repository;
        this.conversionService = conversionService;
    }

    @Override
    public ProductDto create(ProductDto productDto) {
        Optional.ofNullable(repository.findFirstBySku(productDto.getSku()))
                .ifPresent(s -> {
                    throw new DuplicatedProductException("There is a product with SKU " + productDto.getSku());
                });

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
        return conversionService.convert(getProduct(sku), ProductDto.class);
    }

    @Override
    public void update(String sku, ProductDto productDto) {
        Product product = getProduct(sku);
        BeanUtils.copyProperties(productDto, product);
        repository.save(product);
    }

    @Override
    public void delete(String sku) {
        Product product = getProduct(sku);
        Long idToDelete = product.getId();
        repository.deleteById(idToDelete);
        log.info("Product id " + idToDelete + " deleted");
    }

    private Product getProduct(String sku) {
        return Optional.ofNullable(repository.findFirstBySku(sku))
                .orElseThrow(() -> new ProductNotFoundException("No product found by SKU: " + sku));
    }
}
