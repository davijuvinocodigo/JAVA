package br.com.pehenmo.camel.redis.route;

import br.com.pehenmo.camel.redis.model.Users;
import br.com.pehenmo.camel.redis.processor.RedisReadProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.redis.RedisConstants;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RedisReadRoute extends RouteBuilder {

    @Value("${spring.redis.uri}")
    private String URL;

    @Autowired
    private RedisReadProcessor redisReadProcessor;

    public static final String READ_REDIS_ROUTE = "direct:readRedisRoute";

    @Override
    public void configure() throws Exception {

        from(READ_REDIS_ROUTE)
                .routeId("step-read-redis")
                .setBody(simple(null))
                .setHeader(RedisConstants.COMMAND, constant("GET"))
                .setHeader(RedisConstants.KEY, constant("key_value"))
                .to(URL)//"?redisTemplate=#redisTemplate"
                .unmarshal().json(JsonLibrary.Jackson, Users[].class)
                .process(redisReadProcessor)
                .log("Response redis: ${body}");

    }
}
