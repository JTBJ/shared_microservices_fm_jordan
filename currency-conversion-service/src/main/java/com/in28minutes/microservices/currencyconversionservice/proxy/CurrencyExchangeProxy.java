package com.in28minutes.microservices.currencyconversionservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.in28minutes.microservices.currencyconversionservice.model.CurrencyConversion;

//@FeignClient(name = "currency-exchange", url = "localhost:8000") //configuration for particular port
@FeignClient(name = "currency-exchange") //configuration for load-balancing
public interface CurrencyExchangeProxy {

	//invokes method of currency-exchange service
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}
