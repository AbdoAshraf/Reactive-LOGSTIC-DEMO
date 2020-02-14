package com.logistic.demo.io.domain;


import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
	private String ClientId;
	private String name;
	private String age;
	private List<Order> orders;
}
