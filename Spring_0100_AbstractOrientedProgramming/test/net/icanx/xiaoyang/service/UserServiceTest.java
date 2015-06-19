package net.icanx.xiaoyang.service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import net.icanx.xiaoyang.model.User;
import net.icanx.xiaoyang.spring.BeanFactory;
import net.icanx.xiaoyang.spring.ClassPathXmlApplicationContext;

import org.jdom.JDOMException;
import org.junit.Test;

public class UserServiceTest {

	@Test
	public void test() throws JDOMException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
		
		BeanFactory factory = new ClassPathXmlApplicationContext();
//		UserDAO userDao = (UserDAO)factory.getBean("u");
		
		UserService service = (UserService)factory.getBean("userService");
//		service.setUserDAO(userDao);
		
		User u = new User();
		service.save(u);
	}

}