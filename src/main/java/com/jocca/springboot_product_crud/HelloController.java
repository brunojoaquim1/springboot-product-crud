package com.jocca.springboot_product_crud;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @GetMapping("/hello")
    public String falaMeuChapa() {
        return "Fala meu chapa! Spring Boot tá on!";
    }
}
