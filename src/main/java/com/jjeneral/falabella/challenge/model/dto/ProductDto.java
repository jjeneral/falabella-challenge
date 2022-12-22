package com.jjeneral.falabella.challenge.model.dto;

import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
public class ProductDto {

    @NotNull
    private String sku;
    @NotNull
    @Size(min = 3)
    @Size(max = 50)
    private String name;
    @NotNull
    @NotBlank
    @Size(min = 3)
    @Size(max = 50)
    private String brand;
    @NotBlank
    private String size;
    @NotNull
    @DecimalMin(value = "1.00")
    @DecimalMax(value = "99999999.00")
    private BigDecimal price;
    @NotNull
    @URL
    private String principalImage;



}
