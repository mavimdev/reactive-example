package com.mavim.reactive.controller;

import com.mavim.reactive.dto.Foo;
import com.mavim.reactive.service.FooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class FooController {
    private final FooService fooService;

    @Autowired
    public FooController(FooService fooService) {
        this.fooService = fooService;
    }

    @GetMapping(value = "/foo", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Foo> getAllFoo() {
        return this.fooService.getAllFoo();
    }

}
