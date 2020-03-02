package com.logistic.demo.shared.dto;

import java.util.HashMap;
import java.util.Map;

import com.logistic.demo.io.document.Category;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendorDTO {
	private String vendorId;
	private String name;
	private Map<String, Category> categoryMap;
	public VendorDTO() {
		this.categoryMap = new HashMap<String, Category>();
	}
}
