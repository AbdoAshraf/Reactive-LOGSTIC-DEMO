package com.logistic.demo.shared.dto.logistic.admin;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class RegionAdminDTO {
	private String regionId;
	private String name;
	private Map<String,SalesManDTO> salesMen;
    public RegionAdminDTO() {
    	this.salesMen = new HashMap<>();
    }
}
