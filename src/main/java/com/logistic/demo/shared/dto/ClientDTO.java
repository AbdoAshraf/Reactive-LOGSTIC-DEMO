package com.logistic.demo.shared.dto;

import java.util.List;

import com.logistic.demo.io.domain.Category;
import com.logistic.demo.io.domain.Order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class ClientDTO {
	private String ClientId;
	private String name;
	private String age;
	private List<OrderDTO> ordersDTO;

}
