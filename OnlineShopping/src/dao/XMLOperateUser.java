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
     * ��ѯȫ��xml
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
     * ����person������id��ѯxml
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
     * ����xml����
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
     * ����person����id�޸�xml����
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
     * ����person����idɾ��xml����
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
		//����������		
		try {
			
			Document doc = sax.read(file);
			// ͨ��xpath��ѯ�õ�Element
	
			org.dom4j.Element ele = (org.dom4j.Element) doc.selectSingleNode("//User[@username=" + username + "]");
		
			// У��ele�Ƿ�Ϊnull�����Ϊnull������null
		
			if(ele == null) return  null;
	
			// ��ele�����ݷ�װ��User������
			 
			User user = new User();
			String attrUsername =  ele.attributeValue("username");//��ȡ��Ԫ�ص���Ϊusername����ֵ
			String attrPassword =  ele.attributeValue("password");//��ȡ��Ԫ�ص���Ϊpassword����ֵ
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
