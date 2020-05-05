package daodb;

import java.sql.ResultSet;

import javabean.Businessman;

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

	//判断用户名是否重复
	public boolean nameRepeat(String business_name) {
		Businessman business = new Businessman();
		business = searchAll(business_name);
		if(business.getBusiness_name().equalsIgnoreCase(business_name)) {
			return true;
		}else{
			return false;
		}
	}

	public boolean addInfo(String business_name,String business_password) {

		Database db = new Database();
		if(business_name == "" || business_password == "") {
			return false;
		}
		if(nameRepeat(business_name)) {
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

	public boolean UpdatePassword(String business_name,String business_password){       //修改密码
		Database db = new Database();

		if(business_name == "" || business_password == "") {
			return false;
		}
		if(nameRepeat(business_name)) {
			return false;
		}


		sql = "update business_info set business_password='"+business_password+"' where business_name='"+business_name+"'";

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

	public boolean UpdateMoney(String business_name,String business_money){       //修改钱
		Database db = new Database();

		if(business_money == null || business_money == "") {
			return false;
		}
		if(!nameRepeat(business_name)) {
			return false;
		}
		sql = "update business_info set business_money='"+business_money+"' where business_name='"+business_name+"'";

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
	public Businessman searchAll(String business_name) {//登录验证/查询余额信息等
		Database db = new Database();
		Businessman businessman = new Businessman();
		String[][] sn = null;
		int row = 0;
		int i = 0;
		int flag = 0;

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

			for(int j = 0;j < row;j ++) {
				if(sn[j][1].equalsIgnoreCase(business_name)) {
					businessman.setBusiness_id(sn[j][0]);
					businessman.setBusiness_name(sn[j][1]);
					businessman.setBusiness_password(sn[j][2]);
					businessman.setBusiness_money(sn[j][3]);
					flag = 1;
				}
			}
			if(flag == 0) {
				businessman.setBusiness_id("");
				businessman.setBusiness_name("");
				businessman.setBusiness_password("");
				businessman.setBusiness_money("");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally{
			db.closeStmt();
		}
		return businessman;
	}
}
