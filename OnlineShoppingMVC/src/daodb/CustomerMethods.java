package daodb;

import java.sql.ResultSet;
import javabean.Customer;
public class CustomerMethods {

	String sql;
	ResultSet rs;
	
	//算行数
	public int tableNum() {
		Database db = new Database();
		int row = 0;
		sql = "select customer_id,customer_name,customer_password,customer_money from customer_info order by customer_id";
		try {
			db.OpenConn();
			rs = db.QueryInfo(sql);
			if(rs.last()) {
				row = rs.getRow();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally{
			db.closeStmt();
		}
		return row;
	}
	
	//判断用户名是否重复,返回true存在
	public boolean nameRepeat(String customer_name) {
		Customer customer = new Customer();
		customer = searchAll(customer_name);
		if(customer.getCustomer_name().equalsIgnoreCase(customer_name)) {
			return true;
		}else{
			return false;
		}
	}
	
	//加
	public boolean addInfo(String customer_name,String customer_password) {
		
		Database db = new Database();
		if(customer_name == "" || customer_password == "") {
			return false;
		}
		if(nameRepeat(customer_name)) {
			return false;
		}
		
		int id_num = tableNum() + 1;
		
		sql = "insert into customer_info(customer_id,customer_name,customer_password) values('"+id_num+"','"+customer_name+"','"+customer_password+"')";
		
		try {
			db.OpenConn();
			db.UpdateInfo(sql);
			db.closeStmt();
			
			return true;
		}catch(Exception ex){
			System.out.println(ex);
			db.closeStmt();

			return false;
		}
	}
	
	//修改密码
	public boolean UpdatePassword(String customer_name,String customer_password){       
		Database db = new Database();
		
		if(customer_name == "" || customer_password == "") {
			return false;
		}
		if(!nameRepeat(customer_name)) {
			return false;
		}
		sql = "update customer_info set customer_password='"+customer_password+"' where customer_name='"+customer_name+"'";
		
		try {
			db.OpenConn();
			db.UpdateInfo(sql);  //更新信息
			db.closeStmt();

			return true;
		} catch(Exception ex) {
			System.out.println(ex);
			db.closeStmt();

			return false;
		}
		
	}
	
	//修改钱	
	public boolean UpdateMoney(String customer_name,String customer_money){       
		Database db = new Database();
		
		if(customer_money == null || customer_money == "") {
			return false;
		}
		if(!nameRepeat(customer_name)) {
			return false;
		}
		
		sql = "update customer_info set customer_money='"+customer_money+"' where customer_name='"+customer_name+"'";
		
		try {
			db.OpenConn();
			db.UpdateInfo(sql);  //更新信息
			db.closeStmt();

			return true;
		} catch(Exception ex) {
			System.out.println(ex);
			db.closeStmt();

			return false;
		}
		
	}

	//登录验证/查询余额信息等
	public Customer searchAll(String customer_name) {
		Database db = new Database();
		Customer customer = new Customer();
		String[][] sn = null;
		int row = 0;
		int i = 0;
		int flag = 0;
		
		sql = "select customer_id,customer_name,customer_password,customer_money from customer_info order by customer_id";
		
		try {
			db.OpenConn();
			rs = db.QueryInfo(sql);
			if(rs.last()) {
				row = rs.getRow();
			}
			if(row == 0) {
				sn = new String[1][4];
				sn[0][0] = "	";
				sn[0][1] = "	";
				sn[0][2] = "	";
				sn[0][3] = "	";
				rs.close();
			}
			else {
				sn = new String[row][4];
				rs.first();
				rs.previous();
				while(rs.next()) {
					sn[i][0] = rs.getString("customer_id");
					sn[i][1] = rs.getString("customer_name");
					sn[i][2] = rs.getString("customer_password");
					sn[i][3] = rs.getString("customer_money");
					i++;
				}
				rs.close();
			}
			
			for(int j = 0;j < row;j ++) {
				if(sn[j][1].equalsIgnoreCase(customer_name)) {
					customer.setCustomer_id(sn[j][0]);
					customer.setCustomer_name(sn[j][1]);
					customer.setCustomer_password(sn[j][2]);
					customer.setCustomer_money(sn[j][3]);
					flag = 1;
				}
			}
			if(flag == 0) {
				customer.setCustomer_id("");
				customer.setCustomer_name("");
				customer.setCustomer_password("");
				customer.setCustomer_money("");
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally{
			db.closeStmt();
		}
		return customer;
	}
	
	/*
	public boolean deleteInfo(String userid) {
		Database db = new Database();
		this.userid = userid;
		sql = "delete from db_sellcar_customer where userid= '"+userid+"'";
		try {
			db.OpenConn();
			db.UpdateInfo(sql);  //删除该记录
			db.closeStmt();

			return true;
		} catch(Exception ex) {
			System.out.println(ex);
			db.closeStmt();

			return false;
		}
	}
*/
	
}