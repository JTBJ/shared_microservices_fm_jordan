package com.in28minutes.microservices.currencyexchangeservice.my_preferred.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.microservices.currencyexchangeservice.my_preferred.model.MyCurrencyExchange;

public interface MyCurrencyExchangeRepository extends JpaRepository<MyCurrencyExchange, Long>{

	MyCurrencyExchange findByFromAndTo(String from, String to);
}
