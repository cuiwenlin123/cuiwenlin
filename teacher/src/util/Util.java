package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.User;

//工具类：连接和关闭数据库
public class Util {
	Connection conn = null;
	PreparedStatement ptmt = null;
	ResultSet rs = null;
	{
		try {
			// 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 创建连接
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/news", "root", "root");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 查询数据库
	public List<User> getAll(String sql) {
		// 创建集合存放对象
		List<User> list = new ArrayList<User>();
		User user = new User();
		try {
			ptmt = conn.prepareStatement(sql);
			rs = ptmt.executeQuery();
			while (rs.next()) {
				// 将查询结果存放到user中
				user.setName(rs.getString(1));
				user.setPwd(rs.getString(2));
				// 将user对象存放集合中
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(rs, ptmt, conn);
		}

		return list;

	}

	// 数据的增删改
	public int exeupdate(String sql, Object[] obj) {
		int index = 0;
		try {
			ptmt = conn.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				ptmt.setObject(i + 1, obj[i]);
			}
			index = ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(null, ptmt, conn);
		}
		return index;

	}

	// 关闭数据库
	public void closeAll(ResultSet rs, PreparedStatement ptmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (ptmt != null) {
			try {
				ptmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
