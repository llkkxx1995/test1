package com.hand;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class SinaStock {

	String stock = "http://hq.sinajs.cn/list=sz300170";
	
	private String xmlPath;
	private String jsonPath;
	
	public SinaStock(String xmlPath,String jsonPath){
		this.xmlPath = xmlPath;
		this.jsonPath = jsonPath;
	}
	
	public void getStockInfo(){
		try {
			URL url = new URL(stock);
			URLConnection connection = url.openConnection();
			InputStream is = connection.getInputStream();
			InputStreamReader isr = new InputStreamReader(is,"GBK");
			BufferedReader br = new BufferedReader(isr);
			StringBuffer sb = new StringBuffer();
			String line = null;
			while((line=br.readLine())!=null){
				sb.append(line);
			}
			System.out.println(sb);
			String stockInfo  = sb.toString();
			int index = stockInfo.indexOf("\"");
			stockInfo = stockInfo.substring(index+1, stockInfo.length()-2);
			System.out.println(stockInfo);
			String[] stockInfos = stockInfo.split(",");
			
			this.setXml(stockInfos);
			this.setJson(stockInfos);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void setJson(String[] infos){
		JsonObject object = new JsonObject();
		//向json中添加信息
		object.addProperty("name", infos[0]);
		object.addProperty("open", infos[1]);
		object.addProperty("close", infos[2]);
		object.addProperty("current", infos[3]);
		object.addProperty("high", infos[4]);
		object.addProperty("low", infos[5]);
		String jsonInfos = object.toString();
		
		//将json写入文件
		try {
			File file = new File(jsonPath+"\\stock_json.txt");
			FileWriter fw = new FileWriter(file);
			PrintWriter pw = new PrintWriter(fw,true);
			pw.println(jsonInfos);
			pw.close();
			fw.close();
			System.out.println("json success");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void setXml(String[] infos){
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();
			
			Element root = document.createElement("xml");
			Element stock = document.createElement("stock");
			
			//内容
			Element name =document.createElement("name");
			name.setTextContent(infos[0]);
			Element open =document.createElement("open");
		    open.setTextContent(infos[1]);
			Element close =document.createElement("close");
			close.setTextContent(infos[2]);
			Element current =document.createElement("current");
			current.setTextContent(infos[3]);
			Element high =document.createElement("high");
			high.setTextContent(infos[4]);
			Element low =document.createElement("low");
			low.setTextContent(infos[5]);
			
			//向stock节点添加内容
			stock.appendChild(name);
			stock.appendChild(open);
			stock.appendChild(close);
			stock.appendChild(current);
			stock.appendChild(high);
			stock.appendChild(low);
			
			root.appendChild(stock);
			document.appendChild(root);
			
			//向文件中写入xml
			TransformerFactory transFactory = TransformerFactory.newInstance();
			Transformer transformer = transFactory.newTransformer();
			DOMSource domSource = new DOMSource(document);
			File file = new File(xmlPath+"\\stock_xml.txt");
			FileWriter fileWriter = new FileWriter(file);
			StreamResult result = new StreamResult(fileWriter);
			
			transformer.transform(domSource, result);
            System.out.println("xml success");
		}catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
}
