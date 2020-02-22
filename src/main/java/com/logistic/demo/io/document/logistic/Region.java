package com.logistic.demo.io.document.logistic;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class Region {
	@Id
	private String Id;
	private String regionId;
	private String name;
	private List<SalesMan> salesMen;
	private List<LocalDateTime> avilableDates;
}
