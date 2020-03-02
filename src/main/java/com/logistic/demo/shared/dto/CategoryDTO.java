package com.logistic.demo.shared.dto;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDTO {
	private String name;
	private Map<String,ProductDTO> productMap;
	
	public CategoryDTO() {
		this.productMap = new HashMap<String,ProductDTO>();
	}
}
