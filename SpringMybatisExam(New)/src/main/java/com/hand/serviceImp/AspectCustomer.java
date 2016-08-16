package com.hand.serviceImp;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectCustomer {

	
	@Before("execution(* com.hand.serviceImp.CustomerServiceImp.insertAndSelect(..))")
	public void beforeInsert(){
		System.out.println("Before	Insert	Customer	Data");
	}
	
	@After("execution(* com.hand.serviceImp.CustomerServiceImp.insertAndSelect(..))")
	public void afterInsert(){
		System.out.println("After	Insert	Customer	Data");
	}
}
