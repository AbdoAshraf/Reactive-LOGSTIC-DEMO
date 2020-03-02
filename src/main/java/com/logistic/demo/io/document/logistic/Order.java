package com.logistic.demo.io.document.logistic;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import com.logistic.demo.io.document.Product;

import lombok.Getter;
import lombok.Setter;

@Document
@Getter
@Setter


public class Order {
	private String clientId;
	private Product product;
	private String adress;
	private LocalDateTime timeSlot;
}
