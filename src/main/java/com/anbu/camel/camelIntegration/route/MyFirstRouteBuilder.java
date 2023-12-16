package com.anbu.camel.camelIntegration.route;

import com.anbu.camel.camelIntegration.processor.FirstProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyFirstRouteBuilder extends RouteBuilder {

    @Autowired
    FirstProcessor firstProcessor;

    @Override
    public void configure() throws Exception {
        from("file:src/main/inputDirectory?noop=true")
                .log("Received file: ${header.CamelFileName}")
                .to("direct:processFile");

        from("direct:processFile")
                .log("Processing file: ${header.CamelFileName} - Content: ${body}")
                .process(firstProcessor)
                .log("Content after processing: ${body}")
                .stop();
    }
}
