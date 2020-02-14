package com.logistic.demo.shared.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class VendorDTO {
	private String vendorId;
	private String name;
	private List<CategoryDTO> categories;
}
