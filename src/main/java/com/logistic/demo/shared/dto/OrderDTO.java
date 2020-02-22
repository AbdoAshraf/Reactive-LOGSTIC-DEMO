package com.logistic.demo.shared.dto;

import com.logistic.demo.io.document.Product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class OrderDTO {
	private String OrderId;
	private Product product;
	private String adress;
	private String SalesManName;
}
