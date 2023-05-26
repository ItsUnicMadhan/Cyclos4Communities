package com.endpoint;

/**
 * @date 25-05-2023
 * @author Madhan
 * @see To maintain then Endpoints
 *
 */
public interface Endpoints {

	public final static String ACCOUNTS = "self/accounts";
	public final static String LIST_OF_ACCOUNTS = "self/accounts/list-data";
	public final static String ACCOUNT_TYPE = "self/accounts/memberaccount";
	public final static String DATA_FOR_HISTORY = "self/accounts/memberaccount/data-for-history";
	public final static String HISTORY = "self/accounts/memberaccount/history";
	public final static String EXPORT_FORMAT = "self/accounts/memberaccount/export/pdf";
	public final static String BALANCES_HISTORY = "self/accounts/memberaccount/balances-history";
	public final static String DATA_FOR_USER_BALANCES = "accounts/data-for-user-balances";

	public final static String LIST_DATA = "self/addresses/list-data";
	public final static String LIST_ADDRESSES = "self/addresses";

	public final static String CREATE_ADDRESS = "self/addresses";

	public final static String PRIMARY_ADDRESS = "self/addresses/primary";

}
