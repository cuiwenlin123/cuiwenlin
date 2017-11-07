package dao.imple;

import java.util.List;

import util.Util;
import dao.UserDao;
import entity.User;

public class UserDaoImple extends Util implements UserDao {

	// ��������
	@Override
	public int save(User user) {
		String sql = "insert into users(name,pwd)values(?,?)";
		Object[] obj = { user.getName(), user.getPwd() };
		return exeupdate(sql, obj);
	}

	// ɾ������
	@Override
	public int del(User user) {
		String sql = "delete from users where name=?";
		Object[] obj = { user.getName() };
		return exeupdate(sql, obj);
	}

	// �޸�����
	@Override
	public int updade(User user) {
		String sql = "update users set  pwd=? where name=?";
		Object[] obj = { user.getPwd(), user.getName() };
		return exeupdate(sql, obj);
	}

	// ��ѯ����
	@Override
	public List<User> getAll(User user) {
		String sql = "select * from users";
		return getAll(sql);
	}

}
