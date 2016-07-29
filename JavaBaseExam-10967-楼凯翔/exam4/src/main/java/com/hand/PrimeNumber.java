package com.hand;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumber {

	public static boolean isPrime(int number){
		boolean result = false;
		for(int i=2; i<number; i++){
			int remainNumber = number%i;
			if(remainNumber==0){
				result = true;
				break;
			}
		}
		return result;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	  List<Integer> primeList = new ArrayList<Integer>();
	  for(int i=101; i<=200; i++){
		  if(!PrimeNumber.isPrime(i)){
			  primeList.add(i);
		  }
	  }
	  
	  System.out.print("共有"+primeList.size()+"个素数"+",分别是：");
	  for(int i=0; i<primeList.size(); i++){
		  System.out.print(" "+primeList.get(i));
	  }
	}

}
