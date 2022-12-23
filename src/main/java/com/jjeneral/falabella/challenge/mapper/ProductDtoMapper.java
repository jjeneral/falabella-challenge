package com.jjeneral.falabella.challenge.mapper;

import com.jjeneral.falabella.challenge.model.dto.ProductDto;
import com.jjeneral.falabella.challenge.model.entity.Product;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface ProductDtoMapper extends Converter<ProductDto, Product> {
    Product convert(ProductDto productDto);
}
