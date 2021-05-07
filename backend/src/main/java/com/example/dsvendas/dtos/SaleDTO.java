package com.example.dsvendas.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import com.example.dsvendas.entities.Sale;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
public class SaleDTO implements Serializable {
	
	private static final long serialVersionUID = 5934849067697676259L;

	@EqualsAndHashCode.Include
	private Long id;
	
	private Integer visited;
	
	private Integer deals;
	
	private Double amount;
	
	private LocalDate date;
	
	private SellerDTO seller;

	public SaleDTO(Sale entity) {
		this.id = entity.getId();
		this.visited = entity.getVisited();
		this.deals = entity.getDeals();
		this.amount = entity.getAmount();
		this.date = entity.getDate();
		this.seller = new SellerDTO(entity.getSeller());
	}
	
}
