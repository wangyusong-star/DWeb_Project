package dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;

import bean.Goods;

public class XMLOperateGoods {
    public static Goods QueryGoodById(int goodid) throws Exception{
        File dir = new File("E:\\DWeb_Project\\OnlineShopping\\WebContent\\GoodsInfo.xml");
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
    	File dir = new File("E:\\DWeb_Project\\OnlineShopping\\WebContent\\GoodsInfo.xml");
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
    
    public static void main(String[] args) {

    	/*try {
			Goods g = new Goods();
			g = QueryGoodById(1);
			System.out.println(g.getGoodid()+g.getGoodname()+g.getPrice()+g.getState()+g.getStock());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			int a = GoodsNum();
			System.out.println(a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}
