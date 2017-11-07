package dao.imple;

import java.util.List;

import util.Util;
import dao.UserDao;
import entity.User;

public class UserDaoImple extends Util implements UserDao {

	// 增加数据
	@Override
	public int save(User user) {
		String sql = "insert into users(name,pwd)values(?,?)";
		Object[] obj = { user.getName(), user.getPwd() };
		return exeupdate(sql, obj);
	}

	// 删除数据
	@Override
	public int del(User user) {
		String sql = "delete from users where name=?";
		Object[] obj = { user.getName() };
		return exeupdate(sql, obj);
	}

	// 修改数据
	@Override
	public int updade(User user) {
		String sql = "update users set  pwd=? where name=?";
		Object[] obj = { user.getPwd(), user.getName() };
		return exeupdate(sql, obj);
	}

	// 查询数据
	@Override
	public List<User> getAll(User user) {
		String sql = "select * from users";
		return getAll(sql);
	}

}
