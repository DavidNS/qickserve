package com.dns.qikserve.baskets.wiremockclient;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@EnableAutoConfiguration
@ConfigurationProperties(prefix = "wiremock")
public class WiremockClientConfiguration {

	private String endpoint;

}
