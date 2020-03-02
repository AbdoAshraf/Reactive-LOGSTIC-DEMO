package com.logistic.demo.io.document.logistic;

import java.time.LocalTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalesManTimingInfos {
	private List<String> HolyDaies;
	private LocalTime workingStart;
	private LocalTime workingEnd;
	

}
