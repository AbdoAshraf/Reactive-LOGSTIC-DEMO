package com.logistic.demo.io.document.logistic;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class Region {
	@Id
	private String Id;
	private String regionId;
	private String name;
	private Map<String,SalesMan> salesMen;
}
