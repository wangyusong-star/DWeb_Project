package dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import bean.User;

public class XMLOperateUser {    
    /*
     * 查询全部xml
     * */
    public static List<User> ListClinetLoginUser() throws Exception{
        File dir = new File("E:\\Web_Project\\DWeb_Project\\OnlineShopping\\WebContent\\Userinfo.xml");        
        if (!dir.exists()) {
            dir.createNewFile();
            Document dom = DocumentHelper.createDocument();
            Element root = dom.addElement("User");
            String dirpath = dir+"";
            UtilsForXML.writeToXML(dom, dirpath);
        }
        String dirPath = dir+"";
        Document dom = UtilsForXML.getDocument(dirPath);
        Element root = dom.getRootElement();        
        List<User> persons = new ArrayList<User>();
        
        List<?> list = root.elements();
        for (int i = 0; i < list.size(); i++) {
            Element person = (Element) list.get(i);
            User c = new User();
            String id = person.attributeValue("id");
            c.setId(Integer.parseInt(id));
            List<?> ll = person.elements();
            for (int j = 0; j < ll.size(); j++) {
                Element element = (Element) ll.get(j);
                if ("username".equals(element.getName())) {
                    String username = element.getText();
                    c.setUsername(username);
                }
                if ("password".equals(element.getName())) {
                    String password = element.getText();
                    c.setPassword(password);
                }
            }
            persons.add(c);
        }
        return persons;        
    }
    
    /*
     * 根据person的属性id查询xml
     * */
    public static User QueryClinetLoginUserById(int id) throws Exception{
        File dir = new File("E:\\Web_Project\\DWeb_Project\\OnlineShopping\\WebContent\\Userinfo.xml");
        String dirPath = dir+"";        
        Document dom = UtilsForXML.getDocument(dirPath);        
        Element root = dom.getRootElement();        
        User person = new User();
        Element beQuery = (Element)root.selectSingleNode("//USer[@id="+id+"]");
        if(beQuery!=null){
            person.setUsername(beQuery.elementText("username"));
            person.setPassword(beQuery.elementText("password"));
            person.setId(id);
        }
        return person;                   
    }
     /*
     * 增加xml数据
     * */

    public static int AddClinetLoginUser(String userName,String passWord) throws Exception{
        File dir = new File("E:\\Web_Project\\DWeb_Project\\OnlineShopping\\WebContent\\Userinfo.xml");
        if (!dir.exists()) {
             dir.createNewFile();
        }
        int uniqueid = 1;
        String dirPath = dir+"";
        Document dom = UtilsForXML.getDocument(dirPath);        
        Element root = dom.getRootElement();
        List<Element> list = root.elements("User");
        if(!list.isEmpty()||list.size()!=0){
            int count = list.size();
            Element lastuser = list.get(count-1);
            String value = lastuser.attributeValue("id");
            uniqueid = Integer.parseInt(value)+1;
        }        
//        int id = (int) ((Math.random()*9+1)*1000);
        Element newPerson = root.addElement("User");
        newPerson.addAttribute("id", uniqueid+"");
        Element username = newPerson.addElement("username");
        username.setText(userName);
        Element password = newPerson.addElement("password");
        password.setText(passWord);
        UtilsForXML.writeToXML(dom, dirPath);
        return uniqueid;
    }
    
    /*
     * 根据person属性id修改xml数据
     * */
    public static int UpdateUser(int id,String userName,String passWord) throws Exception{
        File dir = new File("E:\\Web_Project\\DWeb_Project\\OnlineShopping\\WebContent\\Userinfo.xml");
        String dirPath = dir+"";        
        Document dom = UtilsForXML.getDocument(dirPath);        
        Element root = dom.getRootElement();
        Element beQuery = (Element)root.selectSingleNode("//person[@id="+id+"]");
        beQuery.element("username").setText(userName);
        beQuery.element("password").setText(passWord);
        UtilsForXML.writeToXML(dom, dirPath);
        return id;
    }
    /*
     * 根据person属性id删除xml数据
     * */
    public static int DeleteClinetLoginUser(int id) throws Exception{
        File dir = new File("E:\\Web_Project\\DWeb_Project\\OnlineShopping\\WebContent\\Userinfo.xml");
        String dirPath = dir+"";        
        Document dom = UtilsForXML.getDocument(dirPath);        
        Element root = dom.getRootElement();
        Element beQuery = (Element)root.selectSingleNode("//person[@id="+id+"]");
        beQuery.getParent().remove(beQuery);
        UtilsForXML.writeToXML(dom, dirPath);
        return id;
    }
    
	public static User findByUsername(String username){
	    
	    File file = new File("E:\\Web_Project\\DWeb_Project\\OnlineShopping\\WebContent\\Userinfo.xml");
		SAXReader sax = new SAXReader();
		//创建解析器		
		try {
			
			Document doc = sax.read(file);
			// 通过xpath查询得到Element
	
			org.dom4j.Element ele = (org.dom4j.Element) doc.selectSingleNode("//User[@username=" + username + "]");
		
			// 校验ele是否为null，如果为null，返回null
		
			if(ele == null) return  null;
	
			// 把ele的数据封装到User对象中
			 
			User user = new User();
			String attrUsername =  ele.attributeValue("username");//获取该元素的名为username属性值
			String attrPassword =  ele.attributeValue("password");//获取该元素的名为password属性值
			user.setUsername(attrUsername);
			user.setPassword(attrPassword);
			
			return user;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
    public static void main(String[] args) throws Exception {

	}
}
