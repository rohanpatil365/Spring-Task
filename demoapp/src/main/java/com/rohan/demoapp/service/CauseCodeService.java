package com.rohan.demoapp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohan.demoapp.dao.CauseCodeRepository;
import com.rohan.demoapp.utils.AccountConstants;
import com.rohan.demoapp.utils.EntityManagerUtils;

@Service
public class CauseCodeService {
	private ArrayList<Map<String,Object>> dataResponse = null;
	
	@Autowired
	private CauseCodeRepository repository;
	
	@Autowired 
	private EntityManagerUtils emUtils;
	
	public ArrayList<Map<String,Object>> getCauseCodeCount(String account)
	{
		dataResponse = new ArrayList<Map<String,Object>>();
		if("all".equalsIgnoreCase(account))
		{
			for(int i=0;i<AccountConstants.ACCOUNT_LIST.length;i++)
			{
				String accountName = AccountConstants.ACCOUNT_LIST[i];
				setRepository(i);
				int count = repository.getTotalCount();
				Map<String,Object> accountMap = new HashMap<String, Object>();
				accountMap.put("account", accountName);
				accountMap.put("count", count);
				dataResponse.add(accountMap);
			}
		}
		else
		{
			int index = -1;
			
			index = AccountConstants.getAccountIndex(account);
			
			if(index != -1)
			{
				String accountName = AccountConstants.ACCOUNT_LIST[index];
				setRepository(index);
				int count = repository.getTotalCount();
				Map<String,Object> accountMap = new HashMap<String, Object>();
				accountMap.put("account", accountName);
				accountMap.put("count", count);
				dataResponse.add(accountMap);
			}
			
		}
		return dataResponse;
	}
	
	private void setRepository(int id){
        repository = emUtils.getJpaFactory(id).getRepository(CauseCodeRepository.class);
    }
}
