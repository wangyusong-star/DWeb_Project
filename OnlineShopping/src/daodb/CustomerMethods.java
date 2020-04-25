package daodb;

import java.sql.ResultSet;

public class CustomerMethods {

	String sql;
	ResultSet rs;
	
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
	
	public boolean addInfo(String customer_name,String customer_password) {
		int id_num = 0;
		
		Database db = new Database();
		if(customer_name == null || customer_password == "") {
			return false;
		}
		
		id_num = tableNum() + 1;
		
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
	
	public boolean UpdatePassword(String customer_password){       //修改密码
		Database db = new Database();
		
		if(customer_password == null || customer_password == "") {
			return false;
		}
		
		sql = "update customer_info set customer_password='"+customer_password+"'";
		
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
		
	public boolean UpdateMoney(String customer_money){       //修改钱
		Database db = new Database();
		
		if(customer_money == null || customer_money == "") {
			return false;
		}
		
		sql = "update customer_info set customer_money='"+customer_money+"'";
		
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
	public String[][] searchAll() {//登录验证/查询余额信息等
		Database db = new Database();
		String[][] sn = null;
		int row = 0;
		int i = 0;
		sql = "select customer_id,customer_name,customer_password,customer_money from customer_info order by customer_id";
		try {
			db.OpenConn();
			rs = db.QueryInfo(sql);
			if(rs.last()) {
				row = rs.getRow();
			}
			if(row == 0) {
				sn = new String[1][5];
				sn[0][0] = "	";
				sn[0][1] = "	";
				sn[0][2] = "	";
				sn[0][3] = "	";
				sn[0][4] = "	";
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
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally{
			db.closeStmt();
		}
		return sn;
	}
}