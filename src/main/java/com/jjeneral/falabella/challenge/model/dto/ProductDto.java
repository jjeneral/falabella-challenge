package com.jjeneral.falabella.challenge.model.dto;

import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
public class ProductDto {

    @NotNull(message = "SKU must not be null" )
    private String sku;
    @NotNull(message = "name must not be null" )
    @Size(min = 3,  message = "Minimum name length must be 3")
    @Size(max = 50, message = "Maximum name length must be 50")
    private String name;
    @NotNull(message = "brand must not be null" )
    @NotBlank(message = "brand must not be empty" )
    @Size(min = 3,  message = "Minimum brand length must 3" )
    @Size(max = 50, message = "Maximum brand length must be 50")
    private String brand;
    @NotBlank(message = "size must not be empty" )
    private String size;
    @NotNull(message = "price must not be null" )
    @DecimalMin(value = "1.00",  message = "Minimum price must be 1.00")
    @DecimalMax(value = "99999999.00", message = "Maximum price must be 1.00")
    private BigDecimal price;
    @NotNull(message = "principalImage must not be null" )
    @URL(message = "principalImage is not an url" )
    private String principalImage;

}
