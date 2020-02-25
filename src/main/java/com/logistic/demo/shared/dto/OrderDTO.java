package com.logistic.demo.shared.dto;

import java.time.LocalDateTime;

import com.logistic.demo.io.document.Product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class OrderDTO {
	private String orderId;
	private String regionId;
	private Product product;
	private String adress;
	private String SalesManName;
	private LocalDateTime timeSlot;
}
