package com.jjeneral.falabella.challenge.model.dto;

import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
public class ProductDto {

    @NotNull(message = "SKU must not be null" )
    @Pattern(regexp = "^FAL\\-[1-9][0-9]{6,8}$",
            message = "SKU must start with FAL- and then a value between 1000000 and 99999999")
    private String sku;
    @NotNull(message = "name must not be null" )
    @Size(min = 3,  message = "minimum name length must be 3")
    @Size(max = 50, message = "maximum name length must be 50")
    private String name;
    @NotNull(message = "brand must not be null" )
    @NotBlank(message = "brand must not be empty" )
    @Size(min = 3,  message = "minimum brand length must 3" )
    @Size(max = 50, message = "maximum brand length must be 50")
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
