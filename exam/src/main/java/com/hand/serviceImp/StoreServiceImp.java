package com.hand.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hand.exam.mapper.StoreMapper;
import hand.exam.pojo.Store;
import hand.exam.service.StoreService;

@Service
public class StoreServiceImp implements StoreService {

	@Autowired
	private StoreMapper storeMapper;
	
	@Transactional
	public boolean isStoreIdExist(int id) throws Exception {
		boolean result = false;
		Store store = storeMapper.selectStoreById(id);
		if (store!=null&&store.getAddress_id()>=0) {
			result = true;
		}
		return result;
	}

}
