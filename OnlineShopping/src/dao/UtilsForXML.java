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

public class UtilsForXML {
    /**
     * 需要一个方法来创建DOM4j的XML解析器并返回一个document对象
     * add by hanwl
     * @throws Exception 
     */
    public static Document getDocument(String xmlPath) throws Exception {
    	File file = new File("E:\\Web_Project\\DWeb_Project\\OnlineShopping\\WebContent\\Userinfo.xml");
    	FileInputStream f =	new FileInputStream(file);
    	Reader reader = new InputStreamReader(f,"utf-8");
        SAXReader saxReader = new SAXReader();
        //将XML文件路径传给Document对象并返回其实例dom
        Document dom = saxReader.read(reader);
        return dom;
    }
    
    /**
     * 需要一个方法来将更新后的document对象写入到XML文件中去
     * add by hanwl
     * @throws Exception 
     */
    public static void writeToXML(Document dom ,String xmlPath) throws Exception{
        
        //首先创建样式和输出流
        OutputFormat format = new OutputFormat().createPrettyPrint();
        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(xmlPath),"utf-8");
        //OutputStream out = new FileOutputStream(xmlPath);
        XMLWriter writer = new XMLWriter(out,format);
        
        //写入之后关闭流
        writer.write(dom);
        writer.close();
    }
}
