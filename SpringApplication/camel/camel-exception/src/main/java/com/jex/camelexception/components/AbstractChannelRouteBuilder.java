package com.jex.camelexception.components;

import com.jex.camelexception.processor.CommonErrorDefaultHandlerProcessor;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractChannelRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        errorHandler(deadLetterChannel("direct:post-global")
                .onPrepareFailure(new CommonErrorDefaultHandlerProcessor()));

    }
}
