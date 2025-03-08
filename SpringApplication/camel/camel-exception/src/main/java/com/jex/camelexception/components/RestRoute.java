package com.jex.camelexception.components;

import com.jex.camelexception.model.MyBean;
import com.jex.camelexception.model.OutBean;
import com.jex.camelexception.processor.CommonErrorDefaultHandlerProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

import static com.jex.camelexception.model.constants.ModelConstants.TO_DIRECT_GLOBAL;

@Component
public class RestRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        errorHandler(deadLetterChannel(TO_DIRECT_GLOBAL)
                .onPrepareFailure(new CommonErrorDefaultHandlerProcessor()));

        //camelConfigurator.myDefaultErrorHandler().setDeadLetterUri(TO_DIRECT_GLOBAL);
        // http://localhost:8080/camel/api-doc
        restConfiguration().contextPath("/camel") //
            .port("8080")
            .enableCORS(true)
            .apiContextPath("/api-doc")
            .apiProperty("api.title", "Test REST API")
            .apiProperty("api.version", "v1")
            .apiProperty("cors", "true") // cross-site
            .apiContextRouteId("doc-api")
            .component("servlet")
            .bindingMode(RestBindingMode.json)
            .dataFormatProperty("prettyPrint", "true");
        /**
         The Rest DSL supports automatic binding json/xml contents to/from
         POJOs using Camels Data Format.
         By default the binding mode is off, meaning there is no automatic
         binding happening for incoming and outgoing messages.
         You may want to use binding if you develop POJOs that maps to
         your REST services request and response types.
         */

        rest("/api/")
            .description("Rest service")
            .consumes("application/json")
            .produces("application/json")
            .post("/bean")
                .description("post create")
                .bindingMode(RestBindingMode.auto)
                .type(MyBean.class)
                .enableCORS(true)
                .to("direct:post-service")
            .post("/global")
                .description("post create")
                .bindingMode(RestBindingMode.auto)
                .type(MyBean.class)
                .enableCORS(true)
                .to(TO_DIRECT_GLOBAL)
            .get("/bean")
                .description("get all")
                .bindingMode(RestBindingMode.auto)
                .enableCORS(true)
                .outType(OutBean.class)
                .to("direct:get-service");
    }

}
