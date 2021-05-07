package com.mavim.reactive.service;

import com.mavim.reactive.dto.Foo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
public class FooService {

    public Flux<Foo> getAllFoo() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(i -> new Foo(i, "Foo" + i));
    }

}
