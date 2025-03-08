package com.jex.camelexception.config;

import com.jex.camelexception.processor.CommonErrorDefaultHandlerProcessor;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.DefaultErrorHandlerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CamelConfigurator {
	
	@Bean
	public DefaultErrorHandlerBuilder myDefaultErrorHandler() {
		DefaultErrorHandlerBuilder defaultErrorHandlerBuilder = new DefaultErrorHandlerBuilder();
		defaultErrorHandlerBuilder.maximumRedeliveries(3)
			.maximumRedeliveryDelay(1)
				.onPrepareFailure(new CommonErrorDefaultHandlerProcessor())
			.retryAttemptedLogLevel(LoggingLevel.WARN);
		
		return defaultErrorHandlerBuilder;
	}
}