package net.icanx.xiaoyang.service;

import net.icanx.xiaoyang.dao.UserDAO;
import net.icanx.xiaoyang.dao.impl.UserDaoImpl;
import net.icanx.xiaoyang.model.User;

public class UserService {
	
	public void save(User u){
		userDAO.save(u);
	};
	
	
	
//	灵活性 从这里出来   想连接什么数据库 就New 一个什么数据库的实现类
//	从配置文件读取
	private UserDAO userDAO =  new UserDaoImpl();

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	
	
	
	
}
