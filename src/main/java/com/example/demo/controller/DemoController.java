package com.example.demo.controller;

import com.example.demo.dto.DemoResponse;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo")
public class DemoController {

    @GetMapping
    public EntityModel<DemoResponse> demo() {
        DemoResponse response = new DemoResponse("API funcionando dentro de Docker con HATEOAS");

        return EntityModel.of(
                response,
                WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(DemoController.class).demo()
                ).withSelfRel()
        );
    }
}
