package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class GoodsUtilsForXML {
	/**
     * ��Ҫһ������������DOM4j��XML������������һ��document����
     * add by hanwl
     * @throws Exception 
     */
    public static Document getDocument(String xmlPath) throws Exception {
    	File file = new File("E:\\DWeb_Project\\OnlineShopping\\WebContent\\GoodsInfo.xml");
    	FileInputStream f =	new FileInputStream(file);
    	Reader reader = new InputStreamReader(f,"utf-8");
        SAXReader saxReader = new SAXReader();
        //��XML�ļ�·������Document���󲢷�����ʵ��dom
        Document dom = saxReader.read(reader);
        return dom;
    }
    
    /**
     * ��Ҫһ�������������º��document����д�뵽XML�ļ���ȥ
     * add by hanwl
     * @throws Exception 
     */
    public static void writeToXML(Document dom ,String xmlPath) throws Exception{
        
        new OutputFormat();
		//���ȴ�����ʽ�������
        OutputFormat format = OutputFormat.createPrettyPrint();
        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(xmlPath),"utf-8");
        //OutputStream out = new FileOutputStream(xmlPath);
        XMLWriter writer = new XMLWriter(out,format);
        
        //д��֮��ر���
        writer.write(dom);
        writer.close();
    }

}