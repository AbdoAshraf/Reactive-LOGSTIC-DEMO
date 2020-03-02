package com.logistic.demo.io.document;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;


@Document(collection="vendor")
@Getter
@Setter
public class Vendor {
	@Id
	private String id;
	@Indexed(unique=true)
	private String vendorId;
	private String name;
	private Map<String,Category> categoryMap;
}
