package com.hand.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hand.exam.mapper.CustomerMapper;
import hand.exam.pojo.Address;
import hand.exam.pojo.Customer;
import hand.exam.service.AddressService;
import hand.exam.service.CustomerService;

@Service
public class CustomerServiceImp implements CustomerService {

	@Autowired
	public CustomerMapper customerMapper;
	
	@Autowired
	public AddressService addressService;
	
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	public Customer insertAndSelect(Customer customer) throws Exception {
		//插入用户
		customerMapper.insertCustomer(customer);
		
		int id = customer.getCustomer_id();
		//查询插入的用户
		Customer inCustomer = customerMapper.selectCustomerById(id);
		
	
		if (inCustomer!=null) {
			Address address = addressService.selectAddress(inCustomer.getAddress_id());
					
			System.out.println("ID:"+inCustomer.getCustomer_id());
			System.out.println("First_Name:"+inCustomer.getFirst_name());
			System.out.println("Last_Name:"+inCustomer.getLast_name());
			System.out.println("Email:"+inCustomer.getEmail());
			System.out.println("Address:"+address.getAddress());
		}
		return inCustomer;
	}

	@Transactional
	public boolean isCustomerIdExist(int id) throws Exception {
		// TODO Auto-generated method stub
		boolean result = false;
		Customer customer = customerMapper.selectCustomerById(id);
		if (customer!=null&&customer.getCustomer_id()>=0) {
			result = true;
		}
		return result;
	}

	@Transactional
	public void deleteCustomerById(int id) throws Exception {
		// TODO Auto-generated method stub
		customerMapper.deleteCustomerById(id);
	}

}
