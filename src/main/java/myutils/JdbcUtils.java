package myutils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;



/**
 * 工具类
 * 所有的数据库连接和资源释放
 * @author 27566
 *
 */
public class JdbcUtils {

	//获取连接
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		String url ="jdbc:mysql://localhost:3306/mymi?serverTimezone=UTC"; //数据库连接字符串
		Class.forName("com.mysql.cj.jdbc.Driver"); //加载驱动程序
		Connection conn= DriverManager.getConnection(url,"root","123456"); //创建连接
		return conn;
	}

	//释放资源
	public static void closeRes(Connection conn,PreparedStatement ps,ResultSet rs) {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(ps!=null) {
				ps.close();
			}
			if(conn!=null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
