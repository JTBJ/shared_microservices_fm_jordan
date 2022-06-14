package com.in28minutes.microservices.currencyexchangeservice.my_preferred.controller;

import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.microservices.currencyexchangeservice.my_preferred.dao.MyCurrencyExchangeDao;
import com.in28minutes.microservices.currencyexchangeservice.my_preferred.model.MyCurrencyExchange;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MyCurrencyExchangeController {
	
	private final Environment environment;
	
	private final MyCurrencyExchangeDao myCurrencyExchangeDao;

	@GetMapping("/my-currency-exchange/from/{from}/to/{to}")
	public MyCurrencyExchange retrieveExchangeValue(
			@PathVariable("from") String from, @PathVariable("to") String to) {
		
		MyCurrencyExchange currencyExchange = myCurrencyExchangeDao.findByFromAndTo(from, to);
		
		currencyExchange.setEnvironment(environment.getProperty("current.server.port"));
		
		return currencyExchange;
		
//		return MyCurrencyExchange.builder()
//				.id(3000L)
//				.from(from)
//				.to(to)
//				.conversionMultiple(BigDecimal.valueOf(100))
//				.environment(environment.getProperty("local.server.port"))
//				.build();
	}
	
	@GetMapping("my-currency-exchange")
	public List<MyCurrencyExchange> findAll() {
		return myCurrencyExchangeDao.findAll();
	}
	
	@GetMapping("my-currency-exchange/{id}")
	public MyCurrencyExchange findById(@PathVariable("id") Long id) throws Exception {
		return myCurrencyExchangeDao.findById(id);
	}
	
	@PostMapping("my-currency-exchange")
	public MyCurrencyExchange save(@RequestBody MyCurrencyExchange currencyExchange) {
		return myCurrencyExchangeDao.save(currencyExchange);
	}
	
	@DeleteMapping("my-currency-exchange/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		myCurrencyExchangeDao.deleteById(id);
	}

}
