package com.logistic.demo.shared.dto.logistic.admin;

import java.time.LocalTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalesManTimingInfosDTO {
	private List<String> HolyDaies;
	private LocalTime workingStart;
	private LocalTime workingEnd;
	
}
