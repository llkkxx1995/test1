package hand.exam.service;

import hand.exam.pojo.Address;

public interface AddressService {

	public boolean isAddressIdExist(int id)throws Exception;
	
	public Address selectAddress(int id)throws Exception;
}
