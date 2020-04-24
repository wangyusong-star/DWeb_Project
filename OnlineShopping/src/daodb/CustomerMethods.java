package daodb;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import daodb.Database;


public class CustomerMethods {

	String sql;
	ResultSet rs;
	
	public boolean addInfo(String customer_name,String customer_password) {
		int id_num = 0;
		
		Database db = new Database();
		if(customer_name == null || customer_password == "") {
			JOptionPane.showMessageDialog(null, "请输入","错误",JOptionPane.ERROR_MESSAGE);
			return false;
		}
			try {
				db.OpenConn();
				rs = db.QueryInfo(sql);
				id_num = rs.getRow() + 1;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		sql = "insert into customer_info(customer_id,customer_name,customer_password) values('"+id_num+"','"+customer_name+"','"+customer_password+"')";
		
		try {
			db.UpdateInfo(sql);
			JOptionPane.showMessageDialog(null, "成功添加一条记录");
			db.closeStmt();
			return true;
		}catch(Exception ex){
			System.out.println(ex);
			JOptionPane.showMessageDialog(null, "保存失败","错误",JOptionPane.ERROR_MESSAGE);
			db.closeStmt();

			return false;
		}
	}
	
	public boolean UpdatePassword(String customer_password){       //修改密码
		Database db = new Database();
		
		if(customer_password == null || customer_password == "") {
			JOptionPane.showMessageDialog(null, "请输入","错误",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		sql = "update customer_info set customer_password='"+customer_password+"'";
		
		try {
			db.OpenConn();
			db.UpdateInfo(sql);  //更新信息
			JOptionPane.showMessageDialog(null, "成功修改一条记录");
			db.closeStmt();

			return true;
		} catch(Exception ex) {
			System.out.println(ex);
			JOptionPane.showMessageDialog(null, "保存失败","错误",JOptionPane.ERROR_MESSAGE);
			db.closeStmt();

			return false;
		}
		
	}
		
	public boolean UpdateMoney(String customer_money){       //修改钱
		Database db = new Database();
		
		if(customer_money == null || customer_money == "") {
			JOptionPane.showMessageDialog(null, "请输入","错误",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		sql = "update customer_info set customer_money='"+customer_money+"'";
		
		try {
			db.OpenConn();
			db.UpdateInfo(sql);  //更新信息
			JOptionPane.showMessageDialog(null, "成功修改一条记录");
			db.closeStmt();

			return true;
		} catch(Exception ex) {
			System.out.println(ex);
			JOptionPane.showMessageDialog(null, "保存失败","错误",JOptionPane.ERROR_MESSAGE);
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
			JOptionPane.showMessageDialog(null, "成功删除一条记录");
			db.closeStmt();

			return true;
		} catch(Exception ex) {
			System.out.println(ex);
			JOptionPane.showMessageDialog(null, "删除失败","错误",JOptionPane.ERROR_MESSAGE);
			db.closeStmt();

			return false;
		}
	}

	
	public String[][] searchAll() {
		Database db = new Database();
		String[][] sn = null;
		int row = 0;
		int i = 0;
		sql = "select carno,carbrand,carprice,carnum,remark from db_sellcar_car order by carno";
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
				sn = new String[row][5];
				rs.first();
				rs.previous();
				while(rs.next()) {
					sn[i][0] = rs.getString("customer_id");
					sn[i][1] = rs.getString("customer_name");
					sn[i][2] = rs.getString("customer_password");
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

*/

}

