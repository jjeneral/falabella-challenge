package com.jjeneral.falabella.challenge.controller;

import com.jjeneral.falabella.challenge.model.dto.ProductDto;
import com.jjeneral.falabella.challenge.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1/products")
public class ProductController {

    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping()
    @ResponseStatus( HttpStatus.CREATED )
    public ProductDto createProduct(@Valid @RequestBody ProductDto productDto) {
        return service.create(productDto);

    }
    @GetMapping()
    @ResponseStatus( HttpStatus.OK)
    public List<ProductDto> getAllProducts() {
        return service.getAll();
    }

    @GetMapping("/{sku}")
    @ResponseStatus( HttpStatus.OK)
    public ProductDto getProductBySku(@PathVariable String sku) {
        return service.findBySku(sku);
    }

    @PutMapping("/{sku}")
    @ResponseStatus( HttpStatus.OK)
    public void updateProduct(@PathVariable String sku, @Valid @RequestBody ProductDto productDto) {
        service.update(sku, productDto);
    }

    @DeleteMapping("/{sku}")
    @ResponseStatus( HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable String sku) {
        service.delete(sku);
    }

}
