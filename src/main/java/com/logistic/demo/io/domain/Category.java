package com.logistic.demo.io.domain;

import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class Category {
	@Id
	private String id;
	private String CategorytId;
	private String name;
	private List<Product> products;

}
