package br.com.pehenmo.camel.redis.route;

import br.com.pehenmo.camel.redis.model.Users;
import br.com.pehenmo.camel.redis.processor.RedisWriteProcessor;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.redis.RedisConstants;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RedisWriteRoute extends RouteBuilder {

    @Value("${spring.redis.uri}")
    private String URL;

    @Autowired
    private RedisWriteProcessor redisProcessor;

    @Override
    public void configure() throws Exception {
        from("timer://test?period=5000")
                .routeId("step-publish-redis")
                .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
                .to("https://jsonplaceholder.typicode.com/users")
                .unmarshal().json(JsonLibrary.Jackson, Users[].class)
                .process(redisProcessor)
                .log("Request redis: ${body}")
                .removeHeaders("*")
                .setHeader(RedisConstants.COMMAND, constant("SETEX"))
                .setHeader(RedisConstants.KEY, constant("key_value"))
                .setHeader(RedisConstants.VALUE, simple("${body}"))
                .setHeader(RedisConstants.TIMEOUT, constant(100))
                .log(URL)
                .to(URL)
                .to(RedisReadRoute.READ_REDIS_ROUTE);
    }
}