package com.jjeneral.falabella.challenge.controller;

import com.jjeneral.falabella.challenge.exception.ProductNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class ExceptionControllerTest {

    ExceptionController controller = new ExceptionController();


    @Test
    void handleProductNotFound_productNotFoundException_mapError() {
        ProductNotFoundException productNotFoundException = new ProductNotFoundException("No product found by SKU");
        Map<String, List<String>> errorResponse = controller.handleProductNotFound(productNotFoundException);

        Assertions.assertTrue(errorResponse.containsKey("errors"));
        Assertions.assertNotNull(errorResponse.get("errors"));
        Assertions.assertFalse(errorResponse.get("errors").isEmpty());
    }

}