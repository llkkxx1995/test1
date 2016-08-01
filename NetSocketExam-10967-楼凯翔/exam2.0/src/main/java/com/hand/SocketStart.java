package com.hand;

public class SocketStart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String inFilePath = args[0];
		String outFilePath = args[1];
		System.out.println(args[0]);
		System.out.println(args[1]);
		MyServerSocket mss = new MyServerSocket(inFilePath);
		mss.start();
		MyClientSocket mcs = new MyClientSocket(outFilePath);
		mcs.start();
		System.out.println("===================success====================");
	}

}
