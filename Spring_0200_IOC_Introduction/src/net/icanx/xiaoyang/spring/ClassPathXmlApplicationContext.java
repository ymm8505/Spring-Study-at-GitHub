package net.icanx.xiaoyang.spring;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class ClassPathXmlApplicationContext implements BeanFactory{

	//定义一个Map用来存放 实例化的beans
	private Map <String,Object> beans = new HashMap<String,Object>();
	
	public ClassPathXmlApplicationContext() throws JDOMException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException{
//		搞一个SB对象出来
		SAXBuilder sb  = new SAXBuilder();
//		获得要解析的XML文件
		Document doc = sb.build(this.getClass().getClassLoader().getResourceAsStream("beans.xml")); 
//		
		Element root = doc.getRootElement();  		//获得根元素
		List list = root.getChildren("bean");		//获得根元素下面所有bean的子节点
		for(int i = 0; i < list.size(); i++){
			Element element = (Element)list.get(i);
			String id = element.getAttributeValue("id");
			String clazz = element.getAttributeValue("class");
			System.out.println("id:"+id +" ----->class ["+clazz +"]   is create.");
			Object o = Class.forName(clazz).newInstance();
			beans.put(id, o);
			
			//挨个遍历 bean节点下面的property 节点
			for(Element propertyElement : (List<Element>)element.getChildren("property")){
				String name = propertyElement.getAttributeValue("name");
				String bean = propertyElement.getAttributeValue("bean");
				//先把要注入的bean 给实例化
				Object beanObject = beans.get(bean);
				
				//拼好SetUserDAO方法名称
				String methodName = "set"+ name.substring(0, 1).toUpperCase()+name.substring(1);
				System.out.println("拼好的方法名为-------->"   + methodName);
				
												//SetUserDAO(userDAO) 如果 SetUserDAO重载找到相对应的入参 这里为u 
				Method m = o.getClass().getMethod(methodName, beanObject.getClass().getInterfaces()[0]);
				// userService.SetUserDAO(u)
				m.invoke(o, beanObject);
			}
			
			
		}
	}
	
	@Override
	public Object getBean(String name) {
		return beans.get(name);
	}

}
