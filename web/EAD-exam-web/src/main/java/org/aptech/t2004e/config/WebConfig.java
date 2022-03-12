package org.aptech.t2004e.config;

import java.time.Duration;

import org.aptech.t2004e.filter.SiteMeshFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WebConfig {
	@Autowired
	private ServiceProperties serviceProperties;
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder
                .setConnectTimeout(Duration.ofMillis(serviceProperties.getApiTimeout()))
                .setReadTimeout(Duration.ofMillis(serviceProperties.getApiTimeout()))
               .build();
	}
	@Bean
	public FilterRegistrationBean<SiteMeshFilter> siteMeshFilter() {
		FilterRegistrationBean<SiteMeshFilter> fitler = new FilterRegistrationBean<>();
		SiteMeshFilter siteMeshFilter = new SiteMeshFilter();
		fitler.setFilter(siteMeshFilter);
		return fitler;
	}
}
