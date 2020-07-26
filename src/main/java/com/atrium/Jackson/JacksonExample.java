package com.atrium.Jackson;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Java Objects to JSON
 */
public class JacksonExample {
	public static void main(String[] args) {

		ObjectMapper mapper = new ObjectMapper();

		Staff staff = createStaff();

		try {

			// Java objects to JSON file
			mapper.writeValue(new File("e:\\staff.json"), staff);

			// Java objects to JSON string - compact-print
			String jsonString = mapper.writeValueAsString(staff);

			System.out.println(jsonString+"\n");

			// Java objects to JSON string - pretty-print
			String jsonInStringpretty = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff);

			System.out.println(jsonInStringpretty);

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
		staff.setSkills(Arrays.asList("java", "python", "Android", "C","C++"));

		return staff;

	}
}