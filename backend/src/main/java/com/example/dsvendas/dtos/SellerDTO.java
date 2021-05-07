package com.example.dsvendas.dtos;

import java.io.Serializable;

import com.example.dsvendas.entities.Seller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
public class SellerDTO implements Serializable {
	
	private static final long serialVersionUID = 5934849067697676259L;

	@EqualsAndHashCode.Include
	private Long id;
	
	private String name;

	public SellerDTO(Seller entity) {
		this.id = entity.getId();
		this.name = entity.getName();
	}
	
}
