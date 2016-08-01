package com.hand;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServerSocket extends Thread{

	private String filePath;
	
	public MyServerSocket(String filePath){
		this.filePath = filePath;
	}
	public void run(){
		
		try {
			ServerSocket serverSocket = new ServerSocket(30527);
			while(true){
				 Socket socket = serverSocket.accept();
				 OutputStream os = socket.getOutputStream();
				 BufferedOutputStream bos = new BufferedOutputStream(os);
				 File file = new File(filePath);
				 InputStream is = new FileInputStream(file);
				 BufferedInputStream bis = new BufferedInputStream(is);
				 byte[] bytes = new byte[1024];
				 int length = -1;
				 while((length=bis.read(bytes))!=-1){
					bos.write(bytes,0,length);
				 }
				 bis.close();
				 is.close();
				 bos.close();
				 os.close();
				 socket.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
