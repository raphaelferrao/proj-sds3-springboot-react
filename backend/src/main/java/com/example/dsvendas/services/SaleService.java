package com.example.dsvendas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dsvendas.dtos.SaleDTO;
import com.example.dsvendas.entities.Sale;
import com.example.dsvendas.repositories.SaleRepository;
import com.example.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository saleRepository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable) {
		sellerRepository.findAll();
		
		Page<Sale> sellers = saleRepository.findAll(pageable);
		return sellers.map(SaleDTO::new);
	}
	
}
