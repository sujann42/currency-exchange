package com.exsrvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableDiscoveryClient
public class CurrencyExchangeApplication {

    public static void main(String[] args) {
    	SpringApplication.run(CurrencyExchangeApplication.class, args);
    	System.out.println("Currency Exchange Service Application is running fine!!!!");
        
    }
    
    @Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}

