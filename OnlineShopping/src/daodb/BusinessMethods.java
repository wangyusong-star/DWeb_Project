package daodb;

import java.sql.ResultSet;

public class BusinessMethods {

	String sql;
	ResultSet rs;
	
	public int tableNum() {
		Database db = new Database();
		int row = 0;
		sql = "select business_id,business_name,business_password,business_money from business_info order by business_id";
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
	
	public boolean addInfo(String business_name,String business_password) {
		
		Database db = new Database();
		if(business_name == "" || business_password == "") {
			return false;
		}
		
		int id_num = tableNum() + 1;
		sql = "insert into business_info(business_id,business_name,business_password) values('"+id_num+"','"+business_name+"','"+business_password+"')";
		
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
	
	public boolean UpdatePassword(String business_password){       //修改密码
		Database db = new Database();
		
		if(business_password == null || business_password == "") {
			return false;
		}
		
		sql = "update business_info set business_password='"+business_password+"'";
		
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
		
	public boolean UpdateMoney(String business_money){       //修改钱
		Database db = new Database();
		
		if(business_money == null || business_money == "") {
			return false;
		}
		
		sql = "update business_info set business_money='"+business_money+"'";
		
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
		sql = "select business_id,business_name,business_password,business_money from business_info order by business_id";
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
					sn[i][0] = rs.getString("business_id");
					sn[i][1] = rs.getString("business_name");
					sn[i][2] = rs.getString("business_password");
					sn[i][3] = rs.getString("business_money");
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