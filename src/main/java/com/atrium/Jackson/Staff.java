package com.atrium.Jackson;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

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
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({ "toIgnoreProperties1", "toIgnoreProperties2" })
public class Staff {

	@JsonProperty("staff_name")
	@JsonView(CompanyViews.Normal.class)
	private String name;

	@JsonView(CompanyViews.Normal.class)
	private int age;

	@JsonView(CompanyViews.Manager.class)
	private String[] position;

	@JsonView(CompanyViews.Manager.class)
	private List<String> skills;

	@JsonView(CompanyViews.Manager.class)
	private Map<String, BigDecimal> salary;

	@JsonIgnore
	private String toIgnore;

	private String toIgnoreProperties1;

	private String toIgnoreProperties2;
}
