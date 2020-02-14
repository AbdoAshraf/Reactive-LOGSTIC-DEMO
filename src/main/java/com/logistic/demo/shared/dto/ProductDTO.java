package com.logistic.demo.shared.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {
	private String ProductId;
	private String name;
	private float price;
	private String curraucy;
	//private String category;
}
