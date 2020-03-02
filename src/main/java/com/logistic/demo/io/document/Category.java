package com.logistic.demo.io.document;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class Category {
	String name;
	private Map<String,Product> productMap;
}
