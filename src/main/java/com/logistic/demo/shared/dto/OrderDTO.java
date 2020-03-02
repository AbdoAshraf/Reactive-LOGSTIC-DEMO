package com.logistic.demo.shared.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderDTO {
	private String regionId;
	private String clientId;
	private String orderId;
	private ProductDTO product;
	private String adress;
	private String salesManName;
	private LocalDateTime timeSlot;
}
