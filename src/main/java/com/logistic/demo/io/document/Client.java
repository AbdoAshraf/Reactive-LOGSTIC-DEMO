package com.logistic.demo.io.document;


import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.logistic.demo.io.document.logistic.Order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Document(collection="client")
@Getter
@Setter
@NoArgsConstructor
public class Client{
	@Id
	private String id;
	private String clientId;
	private String name;
	private String age;
	private List<Order> orders;
}
