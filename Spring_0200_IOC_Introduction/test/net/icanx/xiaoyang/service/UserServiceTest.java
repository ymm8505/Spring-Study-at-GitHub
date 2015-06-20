package net.icanx.xiaoyang.service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import net.icanx.xiaoyang.model.User;

import org.jdom.JDOMException;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {

	@Test
	public void test() throws JDOMException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("beans.xml");
//		UserDAO userDao = (UserDAO)factory.getBean("u");
		
		UserService service = (UserService)factory.getBean("userService");
//		service.setUserDAO(userDao);
		
		User u = new User();
		service.save(u);
	}

}