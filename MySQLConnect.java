import java.sql.*;
import java.util.*;

public class MySQLConnect {
	public static final String DB_NAME = "jdbc:mysql://localhost:3306/server_client?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	public static final String USERNAME = "yodi555";
	public static final String PASWORD = "yodi654";
	private static Connection c;
	private static Statement st;
	private static ResultSet rs;
	public static String[] getInfo(int id) {
		LinkedList<String> l = new LinkedList<String>();
		try {
			String query = "SELECT name,phone FROM info WHERE id = " + id + ";";
			c = DriverManager.getConnection(DB_NAME, USERNAME, PASWORD);
			st = c.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				String name = rs.getString("name");
				int phone = rs.getInt("phone");
				l.add(name);
				l.add("" + phone);
			}
			rs.close();
			st.close();
			c.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return l.toArray(new String[l.size()]);
	}
}
