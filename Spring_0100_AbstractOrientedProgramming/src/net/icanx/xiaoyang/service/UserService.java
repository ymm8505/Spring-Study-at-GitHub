package net.icanx.xiaoyang.service;

import net.icanx.xiaoyang.dao.UserDAO;
import net.icanx.xiaoyang.dao.impl.UserDaoImpl;
import net.icanx.xiaoyang.model.User;

public class UserService {
	
	public void save(User u){
		userDAO.save(u);
	};
	
	
	
//	����� ���������   ������ʲô���ݿ� ��New һ��ʲô���ݿ��ʵ����
//	�������ļ���ȡ
	private UserDAO userDAO =  new UserDaoImpl();

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	
	
	
	
}
