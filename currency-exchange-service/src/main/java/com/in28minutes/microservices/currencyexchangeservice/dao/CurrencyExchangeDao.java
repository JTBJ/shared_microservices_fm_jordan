package com.in28minutes.microservices.currencyexchangeservice.dao;

import java.util.List;

import com.in28minutes.microservices.currencyexchangeservice.model.CurrencyExchange;

public interface CurrencyExchangeDao {
	
	List<CurrencyExchange>findAll();
	
	CurrencyExchange findById(Long id);
	
	CurrencyExchange save(CurrencyExchange currencyExchange);
	
	void deleteById(Long id);
	
	CurrencyExchange findByFromAndTo(String from, String to);

}
