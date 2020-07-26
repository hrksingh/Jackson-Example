package com.atrium.Jackson;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TreeModelExample {

	private static final ObjectMapper mapper = new ObjectMapper();

	public static void main(String[] args) {

		try {
			JsonNode root = mapper.readTree(new File("e:\\staff.json"));

			// Get Name
			String name = root.path("staff_name").asText();
			System.out.println(name);

			// Get Age
			Long id = root.path("age").asLong();
			System.out.println(id);

			// Get Salary
			JsonNode salaryNode = root.path("salary");
			if (!salaryNode.isMissingNode()) {
				System.out.println("2018 :" + salaryNode.path("2018").asText());
				System.out.println("2019 :" + salaryNode.path("2019").asText());
				System.out.println("2020 :" + salaryNode.path("2020").asText());
			}

			// Get Skills
			JsonNode skillNode = root.path("skills");

			if (skillNode.isArray()) {

				for (JsonNode node : skillNode) {
					System.out.println(node);

				}

			}

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
