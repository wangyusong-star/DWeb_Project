package dao;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;

import bean.Goods;

public class XMLOperateGoods {
    public static Goods QueryGoodById(int goodid) throws Exception{
        File dir = new File("E:\\DWeb_Project\\OnlineShopping\\WebContent\\xmldb\\GoodsInfo.xml");
        String dirPath = dir+"";        
        Document dom = GoodsUtilsForXML.getDocument(dirPath);        
        Element root = dom.getRootElement();        
        Goods good = new Goods();
        Element beQuery = (Element)root.selectSingleNode("//Good[@goodid="+goodid+"]");
        if(beQuery!=null){
        	good.setGoodname(beQuery.elementText("goodname"));
        	good.setPrice(beQuery.elementText("price"));
        	good.setStock(beQuery.elementText("stock"));
        	good.setState(beQuery.elementText("state"));
        	good.setDescribe(beQuery.elementText("describe"));
        	good.setGoodid(goodid);
        }
        return good;                   
    }
    
    public static int GoodsNum() throws Exception{
    	int num = 0;
    	File dir = new File("E:\\DWeb_Project\\OnlineShopping\\WebContent\\xmldb\\GoodsInfo.xml");
        if (!dir.exists()) {
             dir.createNewFile();
        }
        String dirPath = dir+"";
        Document dom = GoodsUtilsForXML.getDocument(dirPath);        
        Element root = dom.getRootElement();
        List<Element> list = root.elements("Good");
        if(!list.isEmpty()||list.size()!=0){
            int count = list.size();
            Element lastuser = list.get(count-1);
            String value = lastuser.attributeValue("goodid");
            num = Integer.parseInt(value)+1;
        }
        return num;
    }
    public static int AddGoods(String goodname,String price,String stock,String state,String describe) throws Exception{
        File dir = new File("E:\\DWeb_Project\\OnlineShopping\\WebContent\\xmldb\\Goodsinfo.xml");
        if (!dir.exists()) {
             dir.createNewFile();
        }
        int uniqueid = 1;
        String dirPath = dir+"";
        Document dom = GoodsUtilsForXML.getDocument(dirPath);        
        Element root = dom.getRootElement();
        List<Element> list = root.elements("Good");
        if(!list.isEmpty()||list.size()!=0){
            int count = list.size();
            Element lastuser = list.get(count-1);
            String value = lastuser.attributeValue("goodid");
            uniqueid = Integer.parseInt(value)+1;
        }        
//        int id = (int) ((Math.random()*9+1)*1000);
        Element newPerson = root.addElement("Good");
        newPerson.addAttribute("goodid", uniqueid+"");
        
        Element Goodname = newPerson.addElement("goodname");
        Goodname.setText(goodname);
        Element Price = newPerson.addElement("price");
        Price.setText(price);
        Element Stock = newPerson.addElement("stock");
        Stock.setText(stock);
        Element State = newPerson.addElement("state");
        State.setText(state);
        Element Describe = newPerson.addElement("describe");
        Describe.setText(describe);
        
        GoodsUtilsForXML.writeToXML(dom, dirPath);
        return uniqueid;
    }

}
