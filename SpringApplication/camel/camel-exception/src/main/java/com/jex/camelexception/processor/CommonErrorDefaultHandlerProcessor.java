package com.jex.camelexception.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class CommonErrorDefaultHandlerProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {

        Exception cause = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);
        System.out.println("passou aquiii");
        exchange.getIn().setBody("deadLetterChannel");
;

    }
}
