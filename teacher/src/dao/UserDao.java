package dao;

import java.util.List;

import entity.User;

public interface UserDao {
	// ��������
	int save(User user);

	// ɾ������
	int del(User user);

	// �޸�����
	int updade(User user);

	// ��ѯ����
	List<User> getAll(User user);
}
