package dao;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxDefaultHandle extends DefaultHandler {
/*
	@Override // �ú��������ĵ���ʼ��
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("�����ĵ���ʼ�ĺ�����startDocument()");
		super.startDocument();
	}

	@Override // �ú���˳����xml�ļ��е�Ԫ�أ����ƵĻ��ơ�����
	public void startElement(String arg0, String arg1, String arg2, Attributes arg3) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("Ԫ�����ƣ�" + arg2);
		//super.startElement(arg0, arg1, arg2, arg3);
	}
*/
	@Override // �ú�������xml�ļ��е��ı���
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		String con=new String(ch,start,length);//���ǽ��յ����ı�����
		if(!con.trim().equals("")) {//trim()��Ŀ���������ı����˵Ŀ���
			System.out.println(new String(ch,start,length));
		}
		//super.characters(ch, start, length);
	}
/*
	@Override // �ú�������xml�ļ���һ��Ԫ�صĽ����������������ı�ǩ��</xx>����
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
	}

	@Override // �ú�����������xml�ļ��Ľ�����
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("�����ĵ������ĺ�����endDocument()");
		super.endDocument();
	}
*/
}
