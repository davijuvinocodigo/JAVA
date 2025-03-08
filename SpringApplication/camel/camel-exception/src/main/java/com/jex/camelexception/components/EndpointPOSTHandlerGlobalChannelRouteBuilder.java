package com.jex.camelexception.components;

import com.jex.camelexception.processor.CommonErrorDefaultHandlerProcessor;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class EndpointPOSTHandlerGlobalChannelRouteBuilder extends RouteBuilder {

  @Override
  public void configure() throws Exception {
       from("direct:post-global")
        .routeId("idGlobal-direct-route")
        .tracing()
        .doTry()
           .process(new CommonErrorDefaultHandlerProcessor())
           .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(201))
        .doCatch(IOException.class)
           .process(new CommonErrorDefaultHandlerProcessor())
        .doCatch(IllegalArgumentException.class)
           .process(new Processor() {
               @Override
               public void process(Exchange exchange) throws Exception {
                   exchange.getIn().setBody("exception illegalArgumentException");
               }
           })
        .end();
  }
}
