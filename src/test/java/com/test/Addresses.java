package com.test;

import static io.restassured.RestAssured.baseURI;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;

/**
 * @author Madhan
 * @Date 26-05-3023
 * @see Addresses of Cyclos4 Communities
 */
public class Addresses extends BaseClass {

	/**
	 * @Date 26-05-2023
	 * @throws IOException
	 * @see Before Method for BaseURI
	 */
	@BeforeMethod
	public void beforeMethod() throws IOException {
		baseURI = getPropertyFileValue("baseURI");
	}

	/**
	 * @Date 26-05-3023
	 * @see To get the List of Datas
	 */
	@Test
	public void getListData() {
		GET(LIST_DATA, 200, "addresses[0].name", "home");
	}

	/**
	 * @Date 26-05-3023
	 * @see To get the Account Holder List of Addresses 
	 */
	@Test
	public void getListAddresses() {
		GET(LIST_ADDRESSES, 200, "[0].name", "home");
	}

	/**
	 * @date 26-05-2023
	 * @throws IOException
	 * @see To Create the New Address
	 */
	@Test
	public void postAddressCreation() throws IOException {
		POST("createAddress", CREATE_ADDRESS, 201, "[0].name", "office");
	}

	/**
	 * @Date 26-05-3023
	 * @see To get the primary address
	 */
	@Test
	public void getPrimaryAddress() {
		GET(PRIMARY_ADDRESS, 200, "name", "home");
	}

}
