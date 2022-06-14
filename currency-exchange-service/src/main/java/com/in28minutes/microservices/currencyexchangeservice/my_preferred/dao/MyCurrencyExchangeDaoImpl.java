package com.in28minutes.microservices.currencyexchangeservice.my_preferred.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.in28minutes.microservices.currencyexchangeservice.my_preferred.model.MyCurrencyExchange;
import com.in28minutes.microservices.currencyexchangeservice.my_preferred.repository.MyCurrencyExchangeRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MyCurrencyExchangeDaoImpl implements MyCurrencyExchangeDao {

private final MyCurrencyExchangeRepository currencyExchangeRepository;
	
	@Override
	public MyCurrencyExchange findByFromAndTo(String from, String to) {
		return currencyExchangeRepository.findByFromAndTo(from, to);
	}

	@Override
	public List<MyCurrencyExchange> findAll() {
		List<MyCurrencyExchange> list = (List<MyCurrencyExchange>)currencyExchangeRepository.findAll();
		return list;
	}

	@Override
	public MyCurrencyExchange findById(Long id) {
		Optional<MyCurrencyExchange> result = currencyExchangeRepository.findById(id);
		
		if(!result.isPresent()) {
			System.out.print("null value");
		}
		
		return result.get();
	}

	@Override
	public MyCurrencyExchange save(MyCurrencyExchange currencyExchange) {
		return currencyExchangeRepository.save(currencyExchange);
	}

	@Override
	public void deleteById(Long id) {
		currencyExchangeRepository.deleteById(id);
	}

}
