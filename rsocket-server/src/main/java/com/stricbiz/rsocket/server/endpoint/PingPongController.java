package com.stricbiz.rsocket.server.endpoint;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
public class PingPongController {
    @MessageMapping("ping")
    public Mono<String> ping(String ping) {
        return Mono.just("pong");
    }
}
