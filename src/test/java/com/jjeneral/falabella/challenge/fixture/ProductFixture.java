package com.jjeneral.falabella.challenge.fixture;

import com.jjeneral.falabella.challenge.model.dto.ProductDto;
import com.jjeneral.falabella.challenge.model.entity.Product;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductFixture {

    public static String SKU_TEST = "FAL-8406270";
    public static String SKU_NOT_FOUND_TEST = "FAL-1000000";


    public static ProductDto getProductDto() {
        ProductDto productDto = new ProductDto();
        productDto.setSku(SKU_TEST);
        productDto.setName("500 Zapatilla Urbana Mujer");
        productDto.setBrand("New Balance");
        productDto.setSize("37");
        productDto.setPrice(new BigDecimal("42990.00"));
        productDto.setPrincipalImage("https://falabella.scene7.com/is/image/Falabella/8406270_1");

        return productDto;
    }

    public static List<ProductDto> getProductDtoList() {
        List<ProductDto> productDtos = new ArrayList<>();
        productDtos.add(getProductDto());

        return productDtos;
    }
    public static Product getProduct() {
        Product product = new Product();
        product.setId(1L);
        BeanUtils.copyProperties(getProductDto(), product);

        return product;
    }

    public static List<Product> getProductList() {
        List<Product> products = new ArrayList<>();
        products.add(getProduct());

        return products;
    }
}
