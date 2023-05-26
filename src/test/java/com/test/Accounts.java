package com.test;

import static io.restassured.RestAssured.baseURI;

import java.io.IOException;

import org.junit.Before;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;

/**
 * @author Madhan
 * @Date 25-05-3023
 * @see Accounts of Cyclos4 Communities
 */
public class Accounts extends BaseClass {
	/**
	 * @Date 25-05-2023
	 * @throws IOException
	 * @see Before Method for BaseURI
	 */
	@BeforeMethod
	public void beforeMethod() throws IOException {
		baseURI = getPropertyFileValue("baseURI");
	}

	/**
	 * @Date 25-05-2023
	 * @see To get Account Details
	 */
	@Test(priority = 0)
	public void getAccounts() {
		GET(ACCOUNTS, 200, "type[0].name", "Member account");
	}

	/**
	 * @Date 25-05-2023
	 * @see To get List of Account Details
	 */
	@Test(priority = 1)
	public void getListOfAccounts() {
		GET(LIST_OF_ACCOUNTS, 200, "accounts[0].currency.name", "Units");
	}

	/**
	 * @Date 25-05-2023
	 * @see To get Account Type
	 */
	@Test(priority = 2)
	public void getAccountType() {
		GET(ACCOUNT_TYPE, 200, "type.internalName", "memberaccount");
	}

	/**
	 * @Date 25-05-2023
	 * @see To get History of Account Data
	 */
	@Test(priority = 3)
	public void getDataForHistory() {
		GET(DATA_FOR_HISTORY, 200, "transferFilters[1].name", "System payments");
	}

	/**
	 * @Date 25-05-2023
	 * @see To get Account History
	 */
	@Test(priority = 4)
	public void getHistory() {
		GET(HISTORY, 200, "[0].type.name", "Member payment");
	}

	/**
	 * @Date 25-05-2023
	 * @see To get Account Balance History
	 */
	@Test(priority = 5)
	public void getBalancesHistory() {
		GET(BALANCES_HISTORY, 200, "account.currency.name", "Units");
	}

}
