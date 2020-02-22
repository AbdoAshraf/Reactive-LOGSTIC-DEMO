package com.logistic.demo.io.document.logistic;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.logistic.demo.io.document.Product;

import lombok.Getter;
import lombok.Setter;

@Document
@Getter
@Setter


public class Order {
	@Id
	private String id;
	private String OrderId;
	private Product product;
	private String adress;
	private LocalDateTime diliverDate;
	private enum status{PENDING,DILEVRED,CANCLED,URECHABLE};
}
