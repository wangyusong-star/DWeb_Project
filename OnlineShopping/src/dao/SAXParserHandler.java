package dao;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;


public class SAXParserHandler {

	public static void getinfo() throws Exception, SAXException {
		// TODO Auto-generated method stub
		// ʹ��sax��������xml�ļ�������·����
		// ��һ��,����SaxParserFactory:
		SAXParserFactory spf = SAXParserFactory.newInstance();
		// �ڶ���,����SaxParser������:
		SAXParser saxParser = spf.newSAXParser();
		// ������,��xml�ļ��͡��¼�������󡿹���
		saxParser.parse("E:\\DWeb_Project\\OnlineShopping\\WebContent\\Userinfo.xml", new SaxDefaultHandle());// �ڶ����������ڹ������涨����¼�������
	}
	public static void main(String[] args) throws SAXException, Exception {

	}
}
