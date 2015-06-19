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

	//����һ��Map������� ʵ������beans
	private Map <String,Object> beans = new HashMap<String,Object>();
	
	public ClassPathXmlApplicationContext() throws JDOMException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException{
//		��һ��SB�������
		SAXBuilder sb  = new SAXBuilder();
//		���Ҫ������XML�ļ�
		Document doc = sb.build(this.getClass().getClassLoader().getResourceAsStream("beans.xml")); 
//		
		Element root = doc.getRootElement();  		//��ø�Ԫ��
		List list = root.getChildren("bean");		//��ø�Ԫ����������bean���ӽڵ�
		for(int i = 0; i < list.size(); i++){
			Element element = (Element)list.get(i);
			String id = element.getAttributeValue("id");
			String clazz = element.getAttributeValue("class");
			System.out.println("id:"+id +" ----->class ["+clazz +"]   is create.");
			Object o = Class.forName(clazz).newInstance();
			beans.put(id, o);
			
			//�������� bean�ڵ������property �ڵ�
			for(Element propertyElement : (List<Element>)element.getChildren("property")){
				String name = propertyElement.getAttributeValue("name");
				String bean = propertyElement.getAttributeValue("bean");
				//�Ȱ�Ҫע���bean ��ʵ����
				Object beanObject = beans.get(bean);
				
				//ƴ��SetUserDAO��������
				String methodName = "set"+ name.substring(0, 1).toUpperCase()+name.substring(1);
				System.out.println("ƴ�õķ�����Ϊ-------->"   + methodName);
				
												//SetUserDAO(userDAO) ��� SetUserDAO�����ҵ����Ӧ����� ����Ϊu 
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
