package com.hand;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DownLoadPdf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			String filePath = args[0]+"\\downLoad.pdf";
			URL url = new URL("http://files.saas.hand-china.com/java/target.pdf");
			URLConnection connection = url.openConnection();
			InputStream is = connection.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			
			File file = new File(filePath);
			OutputStream os = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(os);
			
			byte[] bytes = new byte[1000];
			int length = -1;
			while((length=bis.read(bytes))!=-1){
				bos.write(bytes,0,length);
			}
			bos.flush();
			bis.close();
			is.close();
			bos.close();
			os.close();
			System.out.println("download success");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("download failed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("download failed");
		}
		
		
	}

}
