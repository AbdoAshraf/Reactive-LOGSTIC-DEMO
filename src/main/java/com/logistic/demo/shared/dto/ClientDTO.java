package com.logistic.demo.shared.dto;

import java.util.LinkedList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ClientDTO {
	private String clientId;
	private String name;
	private String age;
	private List<OrderDTO> orders;
	
	public ClientDTO() {
		this.orders = new LinkedList<>();
	}
}
