package com.mavim.reactive.service;

import com.mavim.reactive.dto.Foo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@Service
public class FooService {

    public Flux<Foo> getAllFoo() {
        return Flux.fromIterable(
                LongStream.rangeClosed(0, 20)
                        .mapToObj(i -> new Foo(i, "Foo" + i))
                        .collect(Collectors.toList())
        ).delayElements(Duration.ofSeconds(1));
    }
}
