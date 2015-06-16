package net.icanx.xiaoyang.service;

import java.io.IOException;

import net.icanx.xiaoyang.dao.UserDAO;
import net.icanx.xiaoyang.model.User;
import net.icanx.xiaoyang.spring.BeanFactory;
import net.icanx.xiaoyang.spring.ClassPathXmlApplicationContext;

import org.jdom.JDOMException;
import org.junit.Test;

public class UserServiceTest {

	@Test
	public void test() throws JDOMException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		BeanFactory factory = new ClassPathXmlApplicationContext();
		UserDAO userDao = (UserDAO)factory.getBean("u");
		
		UserService service = new UserService(); 	
		service.setUserDAO(userDao);
		
		User u = new User();
		service.save(u);
	}

}
