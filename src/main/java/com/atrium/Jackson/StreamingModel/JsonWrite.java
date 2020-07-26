package com.atrium.Jackson.StreamingModel;

import java.io.File;
import java.io.IOException;


import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonWrite {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();

		JsonAsObjectsAsExample(mapper);
		JsonAsArrayAsExample(mapper);

	}

	private static void JsonAsArrayAsExample(ObjectMapper mapper) {
		try (JsonGenerator jGenerator = mapper.getFactory().createGenerator(new File("e:\\StreamingStaffArray.json"),
				JsonEncoding.UTF8)) {
			// pretty print
			jGenerator.useDefaultPrettyPrinter();

			// start array
			jGenerator.writeStartArray();

			jGenerator.writeStartObject();

			jGenerator.writeStringField("name", "Ash");
			jGenerator.writeNumberField("age", 21);

			jGenerator.writeFieldName("messages");

			jGenerator.writeStartArray();

			jGenerator.writeString("msg 1 from Ash");
			jGenerator.writeString("msg 2 from Ash");
			jGenerator.writeString("msg 3 from Ash");

			jGenerator.writeEndArray();

			jGenerator.writeEndObject();

			// next object, pls

			jGenerator.writeStartObject();

			jGenerator.writeStringField("name", "Hrk");
			jGenerator.writeNumberField("age", 21);

			jGenerator.writeFieldName("messages");

			jGenerator.writeStartArray();

			jGenerator.writeString("msg a from Hrk");
			jGenerator.writeString("msg b from Hrk");
			jGenerator.writeString("msg c from Hrk");

			jGenerator.writeEndArray();

			jGenerator.writeEndObject();

			jGenerator.writeEndArray();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void JsonAsObjectsAsExample(ObjectMapper mapper) {
		try (JsonGenerator jGenerator = mapper.getFactory().createGenerator(new File("e:\\StreamingStaffObject.json"),
				JsonEncoding.UTF8)) {
			// pretty print
			jGenerator.useDefaultPrettyPrinter();

			jGenerator.writeStartObject();

			jGenerator.writeStringField("name", "Ash");
			jGenerator.writeNumberField("age", 21);

			jGenerator.writeFieldName("messages");
			jGenerator.writeStartArray();

			jGenerator.writeString("msg 1");
			jGenerator.writeString("msg 2");
			jGenerator.writeString("msg 3");

			jGenerator.writeEndArray();
			jGenerator.writeEndObject();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}