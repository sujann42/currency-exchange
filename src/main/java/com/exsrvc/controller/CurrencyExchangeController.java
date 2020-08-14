package com.exsrvc.controller;

import com.exsrvc.beans.ExchangeValue;
import com.exsrvc.repo.ExchangeValueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {
	
	private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
    private Environment environment;
    
    @Autowired
    private ExchangeValueRepository repository;
    

    @GetMapping("/test")
    public String test() {
        return "This is a message from currency exchange service";
    }

    @GetMapping("/hard-coded/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValueHardCoded(@PathVariable String from, @PathVariable String to) {
        return new ExchangeValue(1000L, from, to, BigDecimal.valueOf(65));
    }


    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
        ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);
        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        
        //Logging 
        logger.info("{}", exchangeValue);
        
        return exchangeValue;
    }



}
