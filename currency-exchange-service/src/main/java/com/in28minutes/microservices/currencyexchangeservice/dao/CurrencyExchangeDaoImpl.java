package com.in28minutes.microservices.currencyexchangeservice.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.in28minutes.microservices.currencyexchangeservice.model.CurrencyExchange;
import com.in28minutes.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;


@Repository
public class CurrencyExchangeDaoImpl implements CurrencyExchangeDao {

	private CurrencyExchangeRepository currencyExchangeRepository;
	
	public CurrencyExchangeDaoImpl(CurrencyExchangeRepository currencyExchangeRepository) {
		this.currencyExchangeRepository = currencyExchangeRepository;
	}

	@Override
	public List<CurrencyExchange> findAll() {
		List<CurrencyExchange> list = (List<CurrencyExchange>)currencyExchangeRepository.findAll();
		return list;
	}

	@Override
	public CurrencyExchange findById(Long id) {
		Optional<CurrencyExchange> result = currencyExchangeRepository.findById(id);
		
		if(!result.isPresent()) {
			System.out.print("null value");
		}
		
		return result.get();
	}

	@Override
	public CurrencyExchange save(CurrencyExchange currencyExchange) {
		return currencyExchangeRepository.save(currencyExchange);
	}

	@Override
	public void deleteById(Long id) {
		currencyExchangeRepository.deleteById(id);
	}

	@Override
	public CurrencyExchange findByFromAndTo(String from, String to) {
		return currencyExchangeRepository.findByFromAndTo(from, to);
	}

}
