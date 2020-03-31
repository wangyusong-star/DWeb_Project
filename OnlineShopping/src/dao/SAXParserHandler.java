package dao;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import bean.User;

public class SAXParserHandler {

	public static void getinfo() throws Exception, SAXException {
		// TODO Auto-generated method stub
		// 使用sax技术解析xml文件（有套路）。
		// 第一步,创建SaxParserFactory:
		SAXParserFactory spf = SAXParserFactory.newInstance();
		// 第二步,创建SaxParser解析器:
		SAXParser saxParser = spf.newSAXParser();
		// 第三步,把xml文件和【事件处理对象】关联
		saxParser.parse("E:\\Web_Project\\DWeb_Project\\OnlineShopping\\WebContent\\Userinfo.xml", new SaxDefaultHandle());// 第二个参数用于关联下面定义的事件处理类
	}
	public static void main(String[] args) throws SAXException, Exception {
		XMLOperateUser x = new XMLOperateUser();
    	User user = x.findByUsername("www");
    	System.out.println(user.getPassword());
	}
}
