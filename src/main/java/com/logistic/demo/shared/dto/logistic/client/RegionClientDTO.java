package com.logistic.demo.shared.dto.logistic.client;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class RegionClientDTO {
	private String regionId;
	private String name;
	private Map<String,String> aviliableDates;
	public RegionClientDTO(){
		this.aviliableDates = new HashMap<>();
	}
	
}
