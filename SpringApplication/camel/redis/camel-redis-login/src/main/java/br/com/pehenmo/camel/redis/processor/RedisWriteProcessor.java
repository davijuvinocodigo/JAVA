package br.com.pehenmo.camel.redis.processor;

import br.com.pehenmo.camel.redis.model.Users;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RedisWriteProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        Users[] body = exchange.getIn().getBody(Users[].class);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(body);
        exchange.getIn().setBody(json);

    }
}
