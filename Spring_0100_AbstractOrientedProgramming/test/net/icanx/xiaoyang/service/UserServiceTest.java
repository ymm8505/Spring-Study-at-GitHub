package net.icanx.xiaoyang.service;

import net.icanx.xiaoyang.model.User;

import org.junit.Test;

public class UserServiceTest {

	@Test
	public void test() {
		UserService service = new UserService();
		User u = new User();
		service.save(u);
	}

}
