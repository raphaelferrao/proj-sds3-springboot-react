package com.example.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.dsvendas.dtos.SaleSuccessDTO;
import com.example.dsvendas.dtos.SaleSumDTO;
import com.example.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
	
	@Query("SELECT new com.example.dsvendas.dtos.SaleSumDTO(obj.seller, SUM(obj.amount)) "
		+ " FROM Sale obj GROUP BY obj.seller ")
	List<SaleSumDTO> amountGroupedBySeller();
	
	@Query("SELECT new com.example.dsvendas.dtos.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) "
			+ " FROM Sale obj GROUP BY obj.seller ")
	List<SaleSuccessDTO> successGroupedBySeller();

}
