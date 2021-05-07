package com.example.dsvendas.dtos;

import java.io.Serializable;

import com.example.dsvendas.entities.Seller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleSumDTO implements Serializable {
	
	private static final long serialVersionUID = -8930873757790647083L;
	
	private String sellerName;
	private Double sum;
	
	public SaleSumDTO(Seller seller, Double sum) {
		super();
		this.sellerName = seller.getName();
		this.sum = sum;
	}

}
