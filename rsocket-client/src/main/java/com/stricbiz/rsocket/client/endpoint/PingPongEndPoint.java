package com.stricbiz.rsocket.client.endpoint;

import org.reactivestreams.Publisher;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingPongEndPoint {

    private final RSocketRequester rSocketRequester;

    public PingPongEndPoint(RSocketRequester rSocketRequester) {
        this.rSocketRequester = rSocketRequester;
    }

    @GetMapping(value = "/ping")
    public Publisher<String> ping(){
        return rSocketRequester.route("ping").data(new String()).retrieveMono(String.class);
    }
}
