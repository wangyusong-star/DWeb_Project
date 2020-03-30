package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

public class RegistUserInfoToXML {
	public void registuserinfo(String username, String password) {
		//1、创建一个SAXTransformerFactory一个对象
	    SAXTransformerFactory sf = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
	    OutputStream in =null;
	    try {	    	
	        //2、通过SAXTransformerFactory创建一个TransformerHandler对象
	        TransformerHandler handler = sf.newTransformerHandler();
	        //3、通过TransformerHandler对象获取Transformer对象(用于设置xml输出的样式和头）
	        javax.xml.transform.Transformer transformer = handler.getTransformer();
	        //设置没有其他的DTD(Document Type Defination 文档类型定义）规范
	        transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
	        //设置编码格式，显式的显示在<?xml version="1.0" ?>中
	        transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
	        //设置换行
	        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	        //文件输出
	        File file =new File("E:/Eclipse_appwork/OnlineShopping/WebContent/UserInfo.xml");
	        //确保file是存在的
	        if(!file.exists()){
	            if(!file.createNewFile()){
	                throw new FileNotFoundException("文件创建失败！");
	            }
	        }
	        //4、创建输出流OutputStream对象
	        in = new FileOutputStream(file);
	        //5、创建流Result对象
	        Result result = new StreamResult(in);
	        //6、关联result，此时有了生成元素的方法（handler提供的方法）和装元素的容器（result对象）
	        handler.setResult(result);
	        //打开文档
	        handler.startDocument();
	        //属性设置
	        AttributesImpl attr = new AttributesImpl();
	        //开始创建元素
	        handler.startElement("", "", "UserInfo", attr);	        
	        attr.addAttribute("", "", "Username", "", username);
	        attr.addAttribute("", "", "Password", "", password);	       
	        handler.startElement("", "", "User", attr);	        
	        handler.endElement("", "", "User");
	        //结束元素创建	        
	        handler.endElement("", "", "UserInfo");
	        //关闭文档
	        handler.endDocument();
	    } catch (TransformerConfigurationException e) {
	        e.printStackTrace();
	    } catch (SAXException e1) {
	    } catch (IOException e2) {
	        e2.printStackTrace();
	    } 
	}
}
