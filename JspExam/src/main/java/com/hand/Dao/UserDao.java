package com.hand.Dao;

import java.sql.Connection;

import com.hand.pojo.Customer;

public interface UserDao {

	public Customer queryCustomerByName(Connection con,String name)throws Exception;
}
