package com.atrium.Jackson.StreamingModel;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonMappingException;

public class JsonReader {
	public static void main(String[] args) {
		ReadFromJsonArray();
		System.out.println();
		ReadFromJsonObject();
	}

	private static void ReadFromJsonObject() {
		try (JsonParser jParser = new JsonFactory().createParser(new File("e:\\StreamingStaffObject.json"));) {

			// loop until token equal to "}"
			while (jParser.nextToken() != JsonToken.END_OBJECT) {

				String fieldname = jParser.getCurrentName();

				if ("name".equals(fieldname)) {
					// current token is "name",
					// move to next, which is "name"'s value
					jParser.nextToken();
					System.out.println(jParser.getText());
				}

				if ("age".equals(fieldname)) {
					jParser.nextToken();
					System.out.println(jParser.getIntValue());
				}

				if ("messages".equals(fieldname)) {

					if (jParser.nextToken() == JsonToken.START_ARRAY) {
						// messages is array, loop until token equal to "]"
						while (jParser.nextToken() != JsonToken.END_ARRAY) {
							System.out.println(jParser.getText());
						}
					}

				}

			}

		} catch (JsonParseException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	private static void ReadFromJsonArray() {
		try (JsonParser jParser = new JsonFactory().createParser(new File("e:\\StreamingStaffArray.json"));) {

			// JSON array?
			if (jParser.nextToken() == JsonToken.START_ARRAY) {

				while (jParser.nextToken() != JsonToken.END_ARRAY) {

					// loop until token equal to "}"
					while (jParser.nextToken() != JsonToken.END_OBJECT) {

						String fieldname = jParser.getCurrentName();
						if ("name".equals(fieldname)) {
							// current token is "name",
							// move to next, which is "name"'s value
							jParser.nextToken();
							System.out.println(jParser.getText());
						}

						if ("age".equals(fieldname)) {
							jParser.nextToken();
							System.out.println(jParser.getIntValue());
						}

						if ("messages".equals(fieldname)) {

							// jParser.nextToken(); // current token is "[", move next
							if (jParser.nextToken() == JsonToken.START_ARRAY) {
								// messages is array, loop until token equal to "]"
								while (jParser.nextToken() != JsonToken.END_ARRAY) {
									System.out.println(jParser.getText());
								}
							}

						}

					}

				}
			}

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
