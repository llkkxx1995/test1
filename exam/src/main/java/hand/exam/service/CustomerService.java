package hand.exam.service;

import hand.exam.pojo.Customer;

public interface CustomerService {

	
	public Customer insertAndSelect(Customer customer)throws Exception;

	public boolean isCustomerIdExist(int id)throws Exception;
	
	public void deleteCustomerById(int id)throws Exception;
}
