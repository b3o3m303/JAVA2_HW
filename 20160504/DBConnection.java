import java.sql.*;
import javax.swing.*;

public class DBConnection {
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://120.108.113.56:23306/csieadm_104021043?useUnicode=true&characterEncoding=utf8";
	private Connection dbConn;
	private f mf1;

	public DBConnection(f mf, String id, String pw) {
		mf1 = mf;
		try {
			Class.forName(driver);
			dbConn = DriverManager.getConnection(url, id, pw);
			JOptionPane.showMessageDialog(mf, "true");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(mf, ex.toString());
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(mf, ex.toString());
		}
	}

	public ResultSet getData() {
		ResultSet rs = null;
		try {
			Statement stm = dbConn.createStatement();
			String sqlStr = "select * from users";
			rs = stm.executeQuery(sqlStr);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(mf1, ex.toString());
		}
		return rs;
	}
}
