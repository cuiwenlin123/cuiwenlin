package dao;

import java.util.List;

import entity.User;

public interface UserDao {
	// 增加数据
	int save(User user);

	// 删除数据
	int del(User user);

	// 修改数据
	int updade(User user);

	// 查询数据
	List<User> getAll(User user);
}
