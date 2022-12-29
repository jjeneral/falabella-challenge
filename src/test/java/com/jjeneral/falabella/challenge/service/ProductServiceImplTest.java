package com.jjeneral.falabella.challenge.service;

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

    @Test
    public void getAll_void_listOfProductDto() {
        when(repository.findAll()).thenReturn(ProductFixture.getProductList());
        doReturn(ProductFixture.getProductDto())
                .when(conversionService).convert(any(Product.class), eq(ProductDto.class));

        List<ProductDto> expected = ProductFixture.getProductDtoList();
        List<ProductDto> actual   = productService.getAll();

        assertEquals(expected, actual);
    }

    @Test
    public void findBySku() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}