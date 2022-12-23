package com.jjeneral.falabella.challenge.mapper;

import com.jjeneral.falabella.challenge.model.dto.ProductDto;
import com.jjeneral.falabella.challenge.model.entity.Product;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface ProductMapper extends Converter<Product, ProductDto> {
    ProductDto convert(Product product);
}
