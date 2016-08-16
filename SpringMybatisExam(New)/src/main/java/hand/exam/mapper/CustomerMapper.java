package hand.exam.mapper;

import hand.exam.pojo.Customer;

public interface CustomerMapper {

	public void insertCustomer(Customer customer)throws Exception;
	
	public Customer selectCustomerById(int id)throws Exception;
	
	public void deleteCustomerById(int id)throws Exception;
}
