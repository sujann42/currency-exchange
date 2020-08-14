package com.exsrvc.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exsrvc.beans.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long>{
	
	ExchangeValue findByFromAndTo(String from, String to);

}
