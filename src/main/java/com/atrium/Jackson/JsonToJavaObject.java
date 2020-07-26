package com.atrium.Jackson;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToJavaObject {

	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();

		try {

			// JSON file to Java object
			Staff staff = mapper.readValue(new File("e:\\staff.json"), Staff.class);

			// JSON string to Java object
			String jsonInString = "{\"name\":\"hrk\",\"age\":22,\"skills\":[\"Jersey\",\"Jackson\"]}";
			Staff staff2 = mapper.readValue(jsonInString, Staff.class);

			// compact print from Ash
			System.out.println(staff+"\n");

			// pretty print from Ash
			String prettyStaff = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff);

			System.out.println(prettyStaff+"\n");

			// compact print from Hrk
			System.out.println(staff2+"\n");

			// pretty print from hrk
			String prettyStaff1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff2);

			System.out.println(prettyStaff1+"\n");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
