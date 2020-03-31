package dao;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxDefaultHandle extends DefaultHandler {
/*
	@Override // 该函数发现文档开始：
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("发现文档开始的函数：startDocument()");
		super.startDocument();
	}

	@Override // 该函数顺序发现xml文件中的元素（【推的机制】）：
	public void startElement(String arg0, String arg1, String arg2, Attributes arg3) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("元素名称：" + arg2);
		//super.startElement(arg0, arg1, arg2, arg3);
	}
*/
	@Override // 该函数发现xml文件中的文本：
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		String con=new String(ch,start,length);//这是接收到的文本内容
		if(!con.trim().equals("")) {//trim()的目的是消除文本两端的空行
			System.out.println(new String(ch,start,length));
		}
		//super.characters(ch, start, length);
	}
/*
	@Override // 该函数发现xml文件中一个元素的结束（即发现这样的标签：</xx>）：
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
	}

	@Override // 该函数发现整个xml文件的结束：
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("发现文档结束的函数：endDocument()");
		super.endDocument();
	}
*/
}
