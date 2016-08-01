package com.hand;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyClientSocket extends Thread{

	private String filePath;
	public MyClientSocket(String filePath){
		this.filePath = filePath;
	}
	public void run(){
		try {
			Socket socket = new Socket("127.0.0.1",30527);
			InputStream is = socket.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			
			File file = new File(filePath+"\\toClientSocketFile.pdf");
			OutputStream os = new FileOutputStream(file);
			 BufferedOutputStream bos = new BufferedOutputStream(os);
			byte[] bytes = new byte[1000];
			int length = -1;
			while((length=bis.read(bytes))!=-1){
				bos.write(bytes,0,length);
			}
			bos.flush();
			bos.close();
			os.close();
			bis.close();
			is.close();
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
