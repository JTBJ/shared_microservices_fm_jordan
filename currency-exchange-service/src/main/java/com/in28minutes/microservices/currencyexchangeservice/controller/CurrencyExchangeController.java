package com.in28minutes.microservices.currencyexchangeservice.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.microservices.currencyexchangeservice.dao.CurrencyExchangeDao;
import com.in28minutes.microservices.currencyexchangeservice.model.CurrencyExchange;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CurrencyExchangeController {

	private final Environment environment;

	private final CurrencyExchangeDao currencyExchangeDao;

	//endpoint to be invoked from currency-conversion microservice
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to) {

		CurrencyExchange currencyExchange = currencyExchangeDao.findByFromAndTo(from, to);
		currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
		
		if(currencyExchange.equals(null)) {
			throw new RuntimeException("Unable to find match from " + from + " to " + to);
		}
		
		return currencyExchange;
	}

	@GetMapping("currency-exchange")
	public List<CurrencyExchange> findAll() {
		return currencyExchangeDao.findAll();
	}

	@GetMapping("currency-exchange/{id}")
	public CurrencyExchange findById(@PathVariable("id") Long id) throws Exception {
		return currencyExchangeDao.findById(id);
	}

	@PostMapping("currency-exchange")
	public CurrencyExchange save(@RequestBody CurrencyExchange currencyExchange) {
		return currencyExchangeDao.save(currencyExchange);
	}

	@DeleteMapping("currency-exchange/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		currencyExchangeDao.deleteById(id);
	}
}
