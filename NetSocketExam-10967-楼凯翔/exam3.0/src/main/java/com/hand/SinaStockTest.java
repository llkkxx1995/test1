package com.hand;

public class SinaStockTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String xmlPath = args[0];
		String jsonPath=args[1];
        SinaStock ss = new SinaStock(xmlPath,jsonPath);
        ss.getStockInfo();
	}

}
