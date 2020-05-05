package daodb;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javabean.Customer;
import javabean.Goods;
import javabean.ShoppingRecord;

public class GoodsMethods {
	String sql;
	ResultSet rs;

	// 算行数
	public int tableNum() {// 总表行数
		Database db = new Database();
		int row = 0;
		sql = "select goods_id from goods_info order by goods_id";
		try {
			db.OpenConn();
			rs = db.QueryInfo(sql);
			if (rs.last()) {
				row = rs.getRow();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			db.closeStmt();
		}
		return row;
	}

	public int RecordtableNum() {// 购买记录表行数
		Database db = new Database();
		int row = 0;
		sql = "select record_id from shopping_record order by record_id";
		try {
			db.OpenConn();
			rs = db.QueryInfo(sql);
			if (rs.last()) {
				row = rs.getRow();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			db.closeStmt();
		}
		return row;
	}
	
	public Goods SearchGoodsInfo(String goods_name) {// 搜索功能 用户方法
		Database db = new Database();
		Goods good = new Goods();
		String[][] sn = null;
		int row = 0;
		int i = 0;
		int flag = 0;

		sql = "select goods_id,goods_name,goods_price,goods_stock,goods_state,goods_describe,goods_offer "
				+ "from goods_info where goods_name = '"+goods_name+"'";

		try {
			db.OpenConn();
			rs = db.QueryInfo(sql);
			if (rs.last()) {
				row = rs.getRow();
			}
			if (row == 0) {
				sn = new String[1][7];
				sn[0][0] = "	";
				sn[0][1] = "	";
				sn[0][2] = "	";
				sn[0][3] = "	";
				sn[0][4] = "	";
				sn[0][5] = "	";
				sn[0][6] = "	";
				rs.close();
			} else {
				sn = new String[row][7];
				rs.first();
				rs.previous();
				while (rs.next()) {
					sn[i][0] = rs.getString("goods_id");
					sn[i][1] = rs.getString("goods_name");
					sn[i][2] = rs.getString("goods_price");
					sn[i][3] = rs.getString("goods_stock");
					sn[i][4] = rs.getString("goods_state");
					sn[i][5] = rs.getString("goods_describe");
					sn[i][6] = rs.getString("goods_offer");
					i++;
				}
				rs.close();
			}

			for (int j = 0; j < row; j++) {
				if (sn[j][1].equalsIgnoreCase(goods_name)) {
					good.setGoods_id(sn[j][0]);
					good.setGoods_name(sn[j][1]);
					good.setGoods_price(sn[j][2]);
					good.setGoods_stock(sn[j][3]);
					good.setGoods_state(sn[j][4]);
					good.setGoods_describe(sn[j][5]);
					good.setGoods_offer(sn[j][6]);
					flag = 1;
				}
			}
			if (flag == 0) {
				good.setGoods_id("");
				good.setGoods_name("");
				good.setGoods_price("");
				good.setGoods_stock("");
				good.setGoods_state("");
				good.setGoods_describe("");
				good.setGoods_offer("");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			db.closeStmt();
		}
		return good;
	}

	// 修改货物信息 商家方法
	public boolean UpdateGoods(String goods_name, String goods_price, String goods_stock, String goods_state,
			String goods_describe) {
		Database db = new Database();

		if (goods_name == "" || goods_price == "" || goods_stock == "" || goods_state == "" || goods_describe == "") {
			return false;
		}

		sql = "update goods_info set goods_name='" + goods_name + "' goods_price='" + goods_price + "' goods_stock='"
				+ goods_stock + "' " + "goods_state='" + goods_state + "' goods_describe='" + goods_describe
				+ "'where goods_name='" + goods_name + "'";

		try {
			db.OpenConn();
			db.UpdateInfo(sql); // 更新信息
			db.closeStmt();

			return true;
		} catch (Exception ex) {
			System.out.println(ex);
			db.closeStmt();

			return false;
		}

	}

	public boolean nameRepeat(String goods_name) {
		Goods good = new Goods();
		good = SearchGoodsInfo(goods_name);
		if(good.getGoods_name().equalsIgnoreCase(goods_name)) {
			return true;
		}else{
			return false;
		}
	}
	
	// 加信息到总表
	public boolean addInfo(String goods_name, String goods_price, String goods_stock, String goods_state,
			String goods_describe, String goods_offer) {

		Database db = new Database();
		if (goods_name == "" || goods_price == "" || goods_stock == "" || goods_state == "" || goods_describe == ""
				|| goods_offer == "") {
			return false;
		}
		
		if(nameRepeat(goods_name)) {
			return false;//输入重复商品名
		}
		
		int id_num = tableNum() + 1;

		sql = "insert into goods_info(goods_id,goods_name,goods_price,goods_stock,goods_state,goods_describe,goods_offer) values('"
				+ id_num + "','" + goods_name + "','" + goods_price + "','" + goods_stock + "','" + goods_describe
				+ "','" + goods_offer + "')";

		try {
			db.OpenConn();
			db.UpdateInfo(sql);
			db.closeStmt();

			return true;
		} catch (Exception ex) {
			System.out.println(ex);
			db.closeStmt();

			return false;
		}
	}

	public boolean Buy(String goods_name, String goods_price, String goods_num, String goods_offer,
			String goods_buyer) {
		int flag = 0;
		String customer_newmoney = null;
		// 查询用户余额够不够
		CustomerMethods c = new CustomerMethods();
		Customer cus = c.searchAll(goods_buyer);
		int customer_money = Integer.parseInt(cus.getCustomer_money());
		// 商品数量够不够
		Goods good = SearchGoodsInfo(goods_name);
		int goods_stock = Integer.parseInt(good.getGoods_stock()) - 1;// 库存查询先减一
		String goods_newstock = Integer.toString(goods_stock);// 匹配方法转型字符串
		int good_price = Integer.parseInt(good.getGoods_price());
		String goods_state = good.getGoods_state();
		String goods_describe = good.getGoods_describe();
		// compare money
		if (customer_money >= good_price) {
			customer_money = customer_money - good_price;
			customer_newmoney = Integer.toString(customer_money);
			flag = 1;
		}
		// 购买记录+1
		if (flag == 1) {
			Database db = new Database();
			if (goods_name == "" || goods_buyer == "") {
				return false;
			}
			int id_num = RecordtableNum() + 1;
			sql = "insert into shopping_record(record_id,goods_name,goods_price,goods_num,goods_offer,goods_buyer) values('"
					+ id_num + "','" + goods_name + "','" + goods_price + "','" + goods_num + "','" + goods_offer
					+ "','" + goods_buyer + "')";
			try {
				db.OpenConn();
				db.UpdateInfo(sql);
				db.closeStmt();
			} catch (Exception ex) {
				System.out.println(ex);
				db.closeStmt();
			}
			// goods_info-1
			UpdateGoods(goods_name, goods_price, goods_newstock, goods_state, goods_describe);
			// customer_money-1
			CustomerMethods customer = new CustomerMethods();
			customer.UpdateMoney(goods_buyer, customer_newmoney);
			return true;
		}
		return false;
	}

	public String Profit(String businessman_name) {// 查看利润
		String profit = null;
		int row = 0;
		Database db = new Database();
		sql = "select (sum)goods_price from shopping_record where goods_offer = '" + businessman_name + "'";
		try {
			db.OpenConn();
			rs = db.QueryInfo(sql);
			if (rs.last()) {
				row = rs.getRow();
			}
			if(row != 0) {
				rs.first();
				rs.previous();
				if(rs.next()) {
					profit = rs.getString("(sum)goods_price");			
				}
				rs.close();
			}else {
				rs.close();
			}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				db.closeStmt();
			}
		return profit;
	}
	
	public List<ShoppingRecord> SearchGoodsRecordForSpecificBusinessman(String business_name) {// 查看卖出情况
		Database db = new Database();
		ShoppingRecord sr = new ShoppingRecord();
		List<ShoppingRecord> list = new ArrayList<ShoppingRecord>();
		String[][] sn = null;
		int row = 0;
		int i = 0;
		int flag = 0;

		sql = "select record_id,goods_name,goods_price,goods_num,goods_offer,goods_buyer"
				+ "from shopping_record order by record_id";

		try {
			db.OpenConn();
			rs = db.QueryInfo(sql);
			if (rs.last()) {
				row = rs.getRow();
			}
			if (row == 0) {
				sn = new String[1][6];
				sn[0][0] = "	";
				sn[0][1] = "	";
				sn[0][2] = "	";
				sn[0][3] = "	";
				sn[0][4] = "	";
				sn[0][5] = "	";
				rs.close();
			} else {
				sn = new String[row][6];
				rs.first();
				rs.previous();
				while (rs.next()) {
					sn[i][0] = rs.getString("record_id");
					sn[i][1] = rs.getString("goods_name");
					sn[i][2] = rs.getString("goods_price");
					sn[i][3] = rs.getString("goods_num");
					sn[i][4] = rs.getString("goods_offer");
					sn[i][5] = rs.getString("goods_buyer");
					i++;
				}
				rs.close();
			}

			for (int j = 0; j < row; j++) {
				if (sn[j][4].equalsIgnoreCase(business_name)) {
					sr.setRecord_id(sn[j][0]);
					sr.setGoods_name(sn[j][1]);
					sr.setGoods_price(sn[j][2]);
					sr.setGoods_num(sn[j][3]);
					sr.setGoods_offer(sn[j][4]);
					sr.setGoods_buyer(sn[j][5]);
					list.add(sr);
					flag = 1;
				}
			}
			if (flag == 0) {
				sr.setRecord_id("");
				sr.setGoods_name("");
				sr.setGoods_price("");
				sr.setGoods_num("");
				sr.setGoods_offer("");
				sr.setGoods_buyer("");
			}			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			db.closeStmt();
		}
		return list;
	}

	// 登录验证/查询余额信息等

	/*
	 * public boolean deleteInfo(String userid) { Database db = new Database();
	 * this.userid = userid; sql =
	 * "delete from db_sellcar_customer where userid= '"+userid+"'"; try {
	 * db.OpenConn(); db.UpdateInfo(sql); //删除该记录 db.closeStmt();
	 * 
	 * return true; } catch(Exception ex) { System.out.println(ex); db.closeStmt();
	 * 
	 * return false; }
	 */

}
