package com.jjeneral.falabella.challenge.controller;

import com.jjeneral.falabella.challenge.model.dto.ProductDto;
import com.jjeneral.falabella.challenge.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

}
