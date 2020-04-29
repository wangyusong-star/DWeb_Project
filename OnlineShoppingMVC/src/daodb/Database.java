package daodb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Database {

	protected static String dbClassName = "com.mysql.cj.jdbc.Driver";// MySQL数据库驱动类的名称
	protected static String dbUrl = "jdbc:mysql://127.0.0.1:3306/onlineshopping?serverTimezone=UTC";// 访问MySQL数据库的路径
	protected static String dbUser = "root";// 访问MySQL数据库的用户名
	protected static String dbPwd = "@Wys0412";// 访问MySQL数据库的密码
	protected static String dbName = "onlineshopping";// 访问MySQL数据库中的实例
	protected static String second = null;//
	public static Connection conn = null;// MySQL数据库的连接对象
    public static Statement sql =null;
    public static ResultSet res = null;
	
    public void OpenConn() throws Exception{// 静态初始化类
		try {
			if (conn == null) {
				Class.forName(dbClassName);// 实例化MySQL数据库的驱动
				conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);// 连接MySQL数据库
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "请将MySQL的JDBC驱动包复制到lib文件夹中。");// 捕获异常后，弹出提示框
			System.exit(-1);// 系统停止运行
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Database() {
		
	}
	public ResultSet QueryInfo(String sq) throws SQLException {
		sql = null;
		res = null;
		try {
			sql = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			res = sql.executeQuery(sq);
		} catch (Exception ex) {
			System.err.println("executeQuery:" + ex.getMessage());
		}
		return res;
	}
	
	public void UpdateInfo(String sq) throws SQLException {
		sql = null;
		try {
			sql = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			sql.executeUpdate(sq);
		} catch(Exception ex) {
			System.err.println("executeQuery:" + ex.getMessage());
		}
	}

	public void closeStmt() {
		try{
			if(sql != null) {
				sql.close();
			}
		} catch(Exception ex) {
			System.err.println("executeQuery:" + ex.getMessage());
		}
	}
	
	public void closeConn() {
		try{
			if(conn != null) {
				conn.close();
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}

