package com.jex.camelexception.components;

import com.jex.camelexception.model.OutBean;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class EndpointGETRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:get-service")
                .routeId("idGet-direct-route")
                .tracing()
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        OutBean out = new OutBean();
                        out.setId(1);
                        out.setName("Test");
                        exchange.getIn().setBody(out);

                        OutBean payload = exchange.getIn().getBody(OutBean.class);
                        exchange.getIn().setBody(payload);
                    }
                })
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(200));
    }
}
