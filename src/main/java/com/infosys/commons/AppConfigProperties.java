package com.infosys.commons;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;


@Configuration
@Data
@ConfigurationProperties(prefix = "plan.module")
@EnableConfigurationProperties
public class AppConfigProperties {
	private Map<String,String> messages;
}
//Bulk Injection from Application.yml is done to messages.