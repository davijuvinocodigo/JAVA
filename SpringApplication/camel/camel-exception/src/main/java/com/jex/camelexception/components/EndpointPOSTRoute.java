package com.jex.camelexception.components;

import com.jex.camelexception.processor.component.IllegalArgumentExceptionThrowingProcessor;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class EndpointPOSTRoute extends RouteBuilder {

  @Override
  public void configure() throws Exception {
       from("direct:post-service")
        .routeId("idPost-direct-route")
        .tracing()
        .log(">>> ${body.id}")
        .log(">>> ${body.name}")
           .doTry()
               .process(new IllegalArgumentExceptionThrowingProcessor())
               .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(201))
           .doCatch(IOException.class, IllegalArgumentException.class, RuntimeException.class)
               .process(new Processor() {
                   @Override
                   public void process(Exchange exchange) throws Exception {
                        exchange.getIn().setBody("exception illegalArgumentException");
                   }
               })
           .end();
  }
}
