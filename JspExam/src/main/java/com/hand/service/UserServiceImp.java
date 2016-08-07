package com.hand.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.hand.Dao.UserDao;
import com.hand.DaoImp.UserDaoImp;
import com.hand.pojo.Customer;
import com.hand.utils.ConnectionFactory;

public class UserServiceImp {

	private UserDao userDao = new UserDaoImp();
	
	//查询用户登录是否合法
	public boolean queryCustomer(String name){
		boolean result = false;
		Connection con = ConnectionFactory.newInstance().getConnection();
		Customer customer = null;
		try {
			customer = userDao.queryCustomerByName(con, name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (customer!=null) {
			result = true;
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}
