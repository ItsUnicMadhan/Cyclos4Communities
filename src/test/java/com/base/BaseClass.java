package com.base;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.endpoint.Endpoints;

import io.restassured.http.ContentType;

/**
 * @date 25-05-2023
 * @author Madhan
 * @see To maintain the genrics and Reusuable methods
 *
 */
public class BaseClass implements Endpoints {

	/**
	 * @date 25-05-2023
	 * @param value
	 * @return String value
	 * @throws IOException
	 * @see To read the File and get the value
	 */
	public static String getPropertyFileValue(String value) throws IOException {
		FileInputStream file = new FileInputStream("Config\\config.properties");
		Properties p = new Properties();
		p.load(file);
		return p.getProperty(value);
	}

	/**
	 * @date 25-05-2023
	 * @param param
	 * @param statusCode
	 * @param jsonObj
	 * @param value
	 * @see GET Method with Authentication
	 */
	public void GET(String param, int statusCode, String jsonObj, String value) {
		given().header("accept", "application/json").header("Authorization", "Basic ZGVtbzoxMjM0").get(param).then()
				.assertThat().statusCode(statusCode).body(jsonObj, equalTo(value)).log().all();
	}

	/**
	 * @date 25-05-2023
	 * @param responseBody
	 * @param param
	 * @param statusCode
	 * @param jsonObj
	 * @param value
	 * @throws IOException
	 * @see POST Method with Authentication
	 */
	public void POST(String responseBody, String param, int statusCode, String jsonObj, String value)
			throws IOException {
		given().header("Authorization", "Basic ZGVtbzoxMjM0").header("Content-Type", "application/json")
				.contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(new File(getPropertyFileValue(responseBody))).when().post(param).then().assertThat()
				.statusCode(statusCode).body(jsonObj, equalTo(value)).log().all();
	}

	/**
	 * @date 25-05-2023
	 * @param token
	 * @param param
	 * @param statusCode
	 * @param jsonObj
	 * @param value
	 * @param responseBody
	 * @throws IOException
	 * @see PATCH Method with Authentication
	 */
	public void PATCH(String token, String param, int statusCode, String jsonObj, String value, String responseBody)
			throws IOException {
		given().header("Authorization", "Bearer " + getPropertyFileValue(token))
				.header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(new File(getPropertyFileValue(responseBody))).when().patch(param).then().assertThat()
				.statusCode(statusCode).body(jsonObj, equalTo(value)).log().all();
	}

	/**
	 * @date 25-05-2023
	 * @param token
	 * @param param
	 * @param statusCode
	 * @throws IOException
	 * @see DELETE Method with Authentication
	 */
	public void DELETE(String token, String param, int statusCode) throws IOException {
		given().header("Authorization", "Bearer " + getPropertyFileValue(token)).when().delete(param).then()
				.assertThat().statusCode(statusCode).log().all();
	}

}
