package com.logistic.demo.io.document;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter

public class Category {
	@Id
	//UUID alternative approach for securing ur DB
	@Indexed
	private String id;
	private String categorytId;
	private String name;
	private List<Product> products;
	Category(){
		this.products = new LinkedList<>();
	}
}
