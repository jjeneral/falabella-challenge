package com.jjeneral.falabella.challenge.controller;

import com.jjeneral.falabella.challenge.model.dto.ProductDto;
import com.jjeneral.falabella.challenge.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public List<ProductDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{sku}")
    @ResponseStatus( HttpStatus.OK)
    public ProductDto getBySku(@PathVariable String sku) {
        return service.findBySku(sku);
    }

}
