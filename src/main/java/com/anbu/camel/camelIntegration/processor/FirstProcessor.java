package com.anbu.camel.camelIntegration.processor;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FirstProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        String body = exchange.getMessage().getBody(String.class);
        log.info("Processor read the message body "+ body);
        body = body.replace("World", "Anbumani");
        exchange.getMessage().setBody(body);
        log.info("File content has been processed and updated.");
    }
}
