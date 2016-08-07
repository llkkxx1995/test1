package com.hand.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import com.hand.pojo.City;

public class ConTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection con = ConnectionFactory.newInstance().getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "select * from city";
			ResultSet rs = stmt.executeQuery(sql);
			DatabaseObject<City> dbObject = new DatabaseObject<City>(rs,City.class);
			List<City> citys = dbObject.getObjectList();
			Iterator<City> iter = citys.iterator();
			while(iter.hasNext()){
				City city = iter.next();
				System.out.println(city);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
