package com.jjeneral.falabella.challenge.mapper;

import com.jjeneral.falabella.challenge.fixture.ProductFixture;
import com.jjeneral.falabella.challenge.model.dto.ProductDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductMapperImplTest {

    private ProductMapperImpl productMapper = new ProductMapperImpl();

    @Test
    void convert() {
        ProductDto expected = ProductFixture.getProductDto();
        ProductDto actual   = productMapper.convert(ProductFixture.getProduct());

        Assertions.assertEquals(expected.getSku(), actual.getSku());
        Assertions.assertEquals(expected.getName(), actual.getName());
        Assertions.assertEquals(expected.getBrand(), actual.getBrand());
        Assertions.assertEquals(expected.getSize(), actual.getSize());
        Assertions.assertEquals(expected.getPrice(), actual.getPrice());
        Assertions.assertEquals(expected.getPrincipalImage(), actual.getPrincipalImage());
    }
}