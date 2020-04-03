package com.rohan.demoapp.utils;

public class AccountConstants {

	public static final String[] ACCOUNT_LIST = {"Account1","Account2","Account3"};
	public static final String[] SECTOR_LIST = {"sector1","sector2","sector3"};
	
	public static int getAccountIndex(String account)
	{
		int index = -1;
		for(int i = 0;i<AccountConstants.ACCOUNT_LIST.length;i++)
		{
			if(AccountConstants.ACCOUNT_LIST[i].equals(account))
			{
				index = i;
				break;
			}
		}
		return index;
	}
	
	public static int getSectorIndex(String account)
	{
		int index = -1;
		for(int i = 0;i<AccountConstants.SECTOR_LIST.length;i++)
		{
			if(AccountConstants.SECTOR_LIST[i].equals(account))
			{
				index = i;
				break;
			}
		}
		return index;
	}
	
}
