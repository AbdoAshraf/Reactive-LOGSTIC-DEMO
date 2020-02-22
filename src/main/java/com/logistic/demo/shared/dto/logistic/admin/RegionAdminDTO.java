package com.logistic.demo.shared.dto.logistic.admin;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class RegionAdminDTO {
	private String regionId;
	private String name;
	private List<SalesManDTO> salesMenDTO;

}
