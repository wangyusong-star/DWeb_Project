package daodb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Database {

	protected static String dbClassName = "com.mysql.cj.jdbc.Driver";// MySQL���ݿ������������
	protected static String dbUrl = "jdbc:mysql://127.0.0.1:3306/onlineshopping?serverTimezone=UTC";// ����MySQL���ݿ��·��
	protected static String dbUser = "root";// ����MySQL���ݿ���û���
	protected static String dbPwd = "@Wys0412";// ����MySQL���ݿ������
	protected static String dbName = "onlineshopping";// ����MySQL���ݿ��е�ʵ��
	protected static String second = null;//
	public static Connection conn = null;// MySQL���ݿ�����Ӷ���
    public static Statement sql =null;
    public static ResultSet res = null;
	
    public void OpenConn() throws Exception{// ��̬��ʼ����
		try {
			if (conn == null) {
				Class.forName(dbClassName);// ʵ����MySQL���ݿ������
				conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);// ����MySQL���ݿ�
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "�뽫MySQL��JDBC���������Ƶ�lib�ļ����С�");// �����쳣�󣬵�����ʾ��
			System.exit(-1);// ϵͳֹͣ����
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

