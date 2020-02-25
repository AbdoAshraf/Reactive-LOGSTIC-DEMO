package com.logistic.demo.shared.dto.logistic.admin;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.logistic.demo.io.document.logistic.SalesMan;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class RegionAdminDTO {
	private String regionId;
	private String name;
	private HashSet<SalesManDTO> salesMen;
	private Map<String, HashSet<SalesMan>> aviliableDates;
}
