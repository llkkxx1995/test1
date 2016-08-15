package com.hand.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hand.exam.mapper.AddressMapper;
import hand.exam.pojo.Address;
import hand.exam.service.AddressService;

@Service
public class AddressServiceImp implements AddressService {

	
	@Autowired
	private AddressMapper addressMapper;
	
	@Transactional
	public boolean isAddressIdExist(int id) throws Exception {
		
		boolean result=false;
		
		Address address = addressMapper.selectAdressById(id);
		if (address!=null&&address.getAddress_id()>=0) {
			result = true;
		}
		return result;
		
	}

	@Transactional
	public Address selectAddress(int id)throws Exception{
		return  addressMapper.selectAdressById(id);
	}
}
