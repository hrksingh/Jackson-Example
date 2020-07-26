package com.atrium.Jackson;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class WithViewsExample {

	public static void main(String[] args) {

		ObjectMapper mapper = new ObjectMapper();

		Staff staff = createStaff();

		try {

			// to enable pretty print
			mapper.enable(SerializationFeature.INDENT_OUTPUT);

			// normal
			String normalView = mapper.writerWithView(CompanyViews.Normal.class).writeValueAsString(staff);

			System.out.format("Normal views\n%s\n", normalView);

			// manager
			String managerView = mapper.writerWithView(CompanyViews.Manager.class).writeValueAsString(staff);

			System.out.format("Manager views\n%s\n", managerView);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static Staff createStaff() {

		Staff staff = new Staff();

		staff.setName("Ash");
		staff.setAge(21);
		staff.setPosition(new String[] { "Founder", "Developer", "Writer" });
		@SuppressWarnings("serial")
		HashMap<String, BigDecimal> salary = new HashMap<String, BigDecimal>() {

			{
				put("2018", new BigDecimal(10000));
				put("2019", new BigDecimal(15000));
				put("2020", new BigDecimal(19000));
			}
		};
		staff.setSalary(salary);
		staff.setSkills(Arrays.asList("java", "python", "Android", "C", "C++"));

		return staff;

	}
}
