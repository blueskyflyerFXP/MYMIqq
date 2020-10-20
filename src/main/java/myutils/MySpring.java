package myutils;

import java.util.HashMap;

public class MySpring {
	//存储所有被管理的对象
	//生命周期托管实现单例模式
	private static HashMap<String, Object> beanBox = new HashMap<>();
	public static <T>T getBean(String className) {
		T obj = null;
		try {
			obj = (T)beanBox.get(className);
			if(obj==null) {
				Class clazz = Class.forName(className);
				obj = (T)clazz.newInstance();
				beanBox.put(className, obj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return obj;
	}
}
