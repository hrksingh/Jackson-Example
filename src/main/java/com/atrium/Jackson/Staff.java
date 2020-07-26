package com.atrium.Jackson;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Staff {
	private String name;
	private int age;
	private String[] position;
	private List<String> skills;
	private Map<String, BigDecimal> salary;
}
