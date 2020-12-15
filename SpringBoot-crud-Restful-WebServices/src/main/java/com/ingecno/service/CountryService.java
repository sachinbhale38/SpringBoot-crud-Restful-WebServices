package com.ingecno.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ingecno.entity.Country;
import com.ingecno.repository.CountryRepository;

@Service
public class CountryService {
	
	@Autowired
	private CountryRepository countryRepository;


	public List<Country> fetchAllCountry() {
		// TODO Auto-generated method stub
		return countryRepository.findAll();
	}
	

	public void deletebyCountry(long cid) {
		countryRepository.deleteById(cid);
		
	}

}
