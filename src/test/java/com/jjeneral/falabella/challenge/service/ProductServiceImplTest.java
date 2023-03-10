package com.jjeneral.falabella.challenge.service;

import com.jjeneral.falabella.challenge.exception.DuplicatedProductException;
import com.jjeneral.falabella.challenge.exception.ProductNotFoundException;
import com.jjeneral.falabella.challenge.fixture.ProductFixture;
import com.jjeneral.falabella.challenge.model.dto.ProductDto;
import com.jjeneral.falabella.challenge.model.entity.Product;
import com.jjeneral.falabella.challenge.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.convert.ConversionService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

    @InjectMocks
    ProductServiceImpl productService;

    @Mock
    ProductRepository repository;

    @Mock
    ConversionService conversionService;

    @Test
    public void create_productDto_createdProductDto() {
        when(repository.findFirstBySku(anyString())).thenReturn(null);
        doReturn(ProductFixture.getProduct())
                .when(conversionService).convert(any(ProductDto.class), eq(Product.class));
        when(repository.save(any(Product.class))).thenReturn(ProductFixture.getProduct());
        doReturn(ProductFixture.getProductDto())
                .when(conversionService).convert(any(Product.class), eq(ProductDto.class));

        ProductDto expected = ProductFixture.getProductDto();
        ProductDto actual   = productService.create(ProductFixture.getProductDto());

        assertEquals(expected, actual);
    }

    @Test()
    public void create_productDto_duplicatedProductException() {

        DuplicatedProductException thrown = assertThrows(DuplicatedProductException.class, () -> {
            when(repository.findFirstBySku(anyString()))
                    .thenReturn(ProductFixture.getProduct());
            productService.create(ProductFixture.getProductDto());
        });

        assertTrue(thrown.getMessage().contains(ProductFixture.SKU_TEST));
    }

    @Test
    public void getAll_void_listOfProductDto() {
        when(repository.findAll()).thenReturn(ProductFixture.getProductList());
        doReturn(ProductFixture.getProductDto())
                .when(conversionService).convert(any(Product.class), eq(ProductDto.class));

        List<ProductDto> expected = ProductFixture.getProductDtoList();
        List<ProductDto> actual   = productService.getAll();

        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void findBySku_string_productDto() {
        when(repository.findFirstBySku(anyString()))
                .thenReturn(ProductFixture.getProduct());
        doReturn(ProductFixture.getProductDto())
                .when(conversionService).convert(any(Product.class), eq(ProductDto.class));

        ProductDto expected = ProductFixture.getProductDto();
        ProductDto actual   = productService.findBySku(ProductFixture.SKU_TEST);

        assertEquals(expected, actual);
    }

    @Test
    public void findBySku_string_productNotFoundException() {
        ProductNotFoundException thrown = assertThrows(ProductNotFoundException.class, () -> {
            when(repository.findFirstBySku(anyString()))
                    .thenReturn(null);
            productService.findBySku(ProductFixture.SKU_NOT_FOUND_TEST);
        });

        assertTrue(thrown.getMessage().startsWith("No product found"));
        assertTrue(thrown.getMessage().contains(ProductFixture.SKU_NOT_FOUND_TEST));
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}