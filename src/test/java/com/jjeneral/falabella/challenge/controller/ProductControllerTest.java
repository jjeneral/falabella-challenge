package com.jjeneral.falabella.challenge.controller;

import com.jjeneral.falabella.challenge.fixture.ProductFixture;
import com.jjeneral.falabella.challenge.model.dto.ProductDto;
import com.jjeneral.falabella.challenge.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

    @InjectMocks
    ProductController controller;

    @Mock
    private ProductService service;

    @Test
    void createProduct_productDto_productDto() {
        when(service.create(any(ProductDto.class))).thenReturn(ProductFixture.getProductDto());
        ProductDto expected = ProductFixture.getProductDto();
        ProductDto actual = controller.createProduct(ProductFixture.getProductDto());

        assertEquals(expected, actual);
    }

    @Test
    void getAllProducts() {
        when(service.getAll()).thenReturn(ProductFixture.getProductDtoList());

        List<ProductDto> expected = ProductFixture.getProductDtoList();
        List<ProductDto> actual   = controller.getAllProducts();

        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    void getProductBySku() {
    }

    @Test
    void updateProduct() {
    }
}