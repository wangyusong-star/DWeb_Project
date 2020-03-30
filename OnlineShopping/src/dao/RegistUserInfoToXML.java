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
		//1������һ��SAXTransformerFactoryһ������
	    SAXTransformerFactory sf = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
	    OutputStream in =null;
	    try {	    	
	        //2��ͨ��SAXTransformerFactory����һ��TransformerHandler����
	        TransformerHandler handler = sf.newTransformerHandler();
	        //3��ͨ��TransformerHandler�����ȡTransformer����(��������xml�������ʽ��ͷ��
	        javax.xml.transform.Transformer transformer = handler.getTransformer();
	        //����û��������DTD(Document Type Defination �ĵ����Ͷ��壩�淶
	        transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
	        //���ñ����ʽ����ʽ����ʾ��<?xml version="1.0" ?>��
	        transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
	        //���û���
	        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	        //�ļ����
	        File file =new File("E:/Eclipse_appwork/OnlineShopping/WebContent/UserInfo.xml");
	        //ȷ��file�Ǵ��ڵ�
	        if(!file.exists()){
	            if(!file.createNewFile()){
	                throw new FileNotFoundException("�ļ�����ʧ�ܣ�");
	            }
	        }
	        //4�����������OutputStream����
	        in = new FileOutputStream(file);
	        //5��������Result����
	        Result result = new StreamResult(in);
	        //6������result����ʱ��������Ԫ�صķ�����handler�ṩ�ķ�������װԪ�ص�������result����
	        handler.setResult(result);
	        //���ĵ�
	        handler.startDocument();
	        //��������
	        AttributesImpl attr = new AttributesImpl();
	        //��ʼ����Ԫ��
	        handler.startElement("", "", "UserInfo", attr);	        
	        attr.addAttribute("", "", "Username", "", username);
	        attr.addAttribute("", "", "Password", "", password);	       
	        handler.startElement("", "", "User", attr);	        
	        handler.endElement("", "", "User");
	        //����Ԫ�ش���	        
	        handler.endElement("", "", "UserInfo");
	        //�ر��ĵ�
	        handler.endDocument();
	    } catch (TransformerConfigurationException e) {
	        e.printStackTrace();
	    } catch (SAXException e1) {
	    } catch (IOException e2) {
	        e2.printStackTrace();
	    } 
	}
}
