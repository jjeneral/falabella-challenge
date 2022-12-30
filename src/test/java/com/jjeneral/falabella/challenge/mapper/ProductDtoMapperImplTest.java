package com.jjeneral.falabella.challenge.mapper;

import com.jjeneral.falabella.challenge.fixture.ProductFixture;
import com.jjeneral.falabella.challenge.model.entity.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductDtoMapperImplTest {

    private ProductDtoMapperImpl productDtoMapper = new ProductDtoMapperImpl();

    @Test
    public void convert() {

        Product expected = ProductFixture.getProduct();
        Product actual = productDtoMapper.convert(ProductFixture.getProductDto());

        Assertions.assertEquals(expected.getSku(), actual.getSku());
        Assertions.assertEquals(expected.getName(), actual.getName());
        Assertions.assertEquals(expected.getBrand(), actual.getBrand());
        Assertions.assertEquals(expected.getSize(), actual.getSize());
        Assertions.assertEquals(expected.getPrice(), actual.getPrice());
        Assertions.assertEquals(expected.getPrincipalImage(), actual.getPrincipalImage());
    }
}