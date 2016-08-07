package com.hand.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseObject<T> {

    private Class<T> objClass;
	private ResultSet rs;
	
	public DatabaseObject(ResultSet rs,Class<T> objClass){
		this.rs = rs;
		this.objClass = objClass; 
	}
	

	public T getObject(){
		
		T obj = null;
		try {
			if(rs.next()&&rs.isLast()){
				obj = this.createObject();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return obj;
	}
	
	public List<T> getObjectList(){
		List<T> objs = new ArrayList<T>();
		try {
			while(rs.next()){
				objs.add(this.createObject());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objs;
		
	}

    
 
	private T createObject(){
    	T obj = null;
    	try {
    		
    		//获取结果集信息
    		ResultSetMetaData metaData = rs.getMetaData();
    	
    		obj = objClass.newInstance();
    		//获取类中的域
    		Field[] fields = objClass.getDeclaredFields();
    		
    		//根据结果集执行set方法
    		for(int i=0; i<fields.length; i++){
    			StringBuffer sb = new StringBuffer();
    			String fieldName = fields[i].getName();
    			String setMethodName = sb.append("set")
    			  .append(fieldName.substring(0, 1).toUpperCase())
    			  .append(fieldName.substring(1)).toString();
    			
    			Method setMethod= objClass.getMethod(setMethodName, fields[i].getType());
    			
    			//判断当前列的类型
    			String columType = metaData.getColumnTypeName(i+1);
 
    			
    			//执行set方法
    			if (columType.equals("BLOB")) {
    				
    				setMethod.invoke(obj, rs.getBlob(fields[i].getName()));
    			}else if(columType.equals("BLOB")){
    				setMethod.invoke(obj, rs.getObject(fields[i].getName()));
    			}else{
    				setMethod.invoke(obj, rs.getObject(fields[i].getName()));
    			}
		}
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (NoSuchMethodException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalArgumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InvocationTargetException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    	return obj;
    }
    
    }
