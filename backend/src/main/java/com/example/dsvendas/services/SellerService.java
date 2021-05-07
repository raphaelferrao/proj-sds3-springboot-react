package com.example.dsvendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dsvendas.dtos.SellerDTO;
import com.example.dsvendas.entities.Seller;
import com.example.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {

	@Autowired
	private SellerRepository sellerRepository;
	
	public List<SellerDTO> findAll() {
		List<Seller> sellers = sellerRepository.findAll();
		return sellers.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
	}
	
}
