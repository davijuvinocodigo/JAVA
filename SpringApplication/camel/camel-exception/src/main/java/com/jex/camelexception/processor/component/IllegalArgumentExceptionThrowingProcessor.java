package com.jex.camelexception.processor.component;

import com.jex.camelexception.model.MyBean;
import com.jex.camelexception.service.ExampleServices;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class IllegalArgumentExceptionThrowingProcessor implements Processor {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionLoggingProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        // - Implements ---------------------------------------
        MyBean bodyIn = (MyBean) exchange.getIn().getBody();
        ExampleServices.example(bodyIn);
        exchange.getIn().setBody(bodyIn);

        // - Fim implements -----------------------------------
        LOGGER.error("Exception Thrown");
        throw new IllegalArgumentException("An exception happened on purpose");
    }

}
