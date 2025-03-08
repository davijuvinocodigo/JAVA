package br.com.pehenmo.camel.redis.processor;

import br.com.pehenmo.camel.redis.model.Users;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RedisReadProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        Users[] users = exchange.getIn().getBody(Users[].class);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(users);
        exchange.getIn().setBody(json);
    }
}
