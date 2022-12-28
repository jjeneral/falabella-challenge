package com.jjeneral.falabella.challenge.service;

import com.jjeneral.falabella.challenge.fixture.ProductFixture;
import com.jjeneral.falabella.challenge.model.dto.ProductDto;
import com.jjeneral.falabella.challenge.model.entity.Product;
import com.jjeneral.falabella.challenge.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.convert.ConversionService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class ProductServiceImplTest {

    @InjectMocks
    ProductServiceImpl productService;

    @Mock
    ProductRepository repository;

    @Mock
    ConversionService conversionService;

    @Test
    void create_productDto_createdProductDto() {
        when(repository.findFirstBySku(anyString())).thenReturn(null);
        when(conversionService.convert(any(ProductDto.class), Product.class))
                .thenReturn(ProductFixture.getProduct());
        when(repository.save(any(Product.class))).thenReturn(ProductFixture.getProduct());

        ProductDto actual = productService.create(ProductFixture.getProductDto());
        ProductDto expected = ProductFixture.getProductDto();

        Assert.assertEquals(expected, actual);

    }

    @Test
    void getAll() {
    }

    @Test
    void findBySku() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}