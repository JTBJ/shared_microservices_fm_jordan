package com.in28minutes.microservices.currencyexchangeservice.my_preferred.dao;

import java.util.List;

import com.in28minutes.microservices.currencyexchangeservice.my_preferred.model.MyCurrencyExchange;

public interface MyCurrencyExchangeDao {

	List<MyCurrencyExchange> findAll();

	MyCurrencyExchange findById(Long id);

	MyCurrencyExchange save(MyCurrencyExchange currencyExchange);

	void deleteById(Long id);
	
	MyCurrencyExchange findByFromAndTo(String from, String to);
}
