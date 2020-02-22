package com.logistic.demo.io.domain;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter

public class Category {
	@Id
	private String id;
	private String categorytId;
	private String name;
	private List<Product> products;
	Category(){
		this.products = new LinkedList<>();
	}
}
