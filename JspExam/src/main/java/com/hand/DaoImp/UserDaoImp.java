package com.hand.DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hand.Dao.UserDao;
import com.hand.pojo.Customer;
import com.hand.utils.DatabaseObject;


public class UserDaoImp implements UserDao {

	public Customer queryCustomerByName(Connection con, String name) throws Exception {
		// TODO Auto-generated method stub
		Customer customer = null;
		String sql = "select * from customer where first_name = ?";
		PreparedStatement ptmt = con.prepareStatement(sql);
		ptmt.setString(1, name);
		ResultSet rs = ptmt.executeQuery();
	    customer = new DatabaseObject<Customer>(rs, Customer.class).getObject();
		System.out.println(customer);
		rs.close();
		ptmt.close();
		return customer;
	}

}
