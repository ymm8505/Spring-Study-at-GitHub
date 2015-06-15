package net.icanx.xiaoyang.dao.impl;

import net.icanx.xiaoyang.dao.UserDAO;
import net.icanx.xiaoyang.model.User;

public class UserDaoImpl implements UserDAO{

	@Override
	public void save(User u) {
		System.out.println("a user is save!");		
	}

}
