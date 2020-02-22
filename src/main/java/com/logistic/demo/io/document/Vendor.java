package com.logistic.demo.io.document;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Document(collection="vendor")
@Getter
@Setter
@NoArgsConstructor
public class Vendor {
	@Id
	private String id;
	private String vendorId;
	private String name;
	private List<Category> categories;
}
