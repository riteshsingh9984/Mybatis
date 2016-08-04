package com;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public enum ApplicationBeanLoader {

	INSTANCE;
	private ApplicationContext applicationContext;
	
	private ApplicationBeanLoader() {
		System.out.println("Beans are going to load .............");
		applicationContext = 
		    	 new ClassPathXmlApplicationContext(new String[] {"springConf.xml"});
		System.out.println("Beans are loaded .............");
	}
	public Object getBean(String serviceName) throws Exception{
		Object obj = null;
		if(serviceName != null && !serviceName.isEmpty()){
			obj = applicationContext.getBean(serviceName);
			if(obj != null){
				return obj;
			}else{
				throw new Exception("Bean is not found");
			}
		}
		return null;
	}
	
	public ApplicationBeanLoader getInstance(){
		return ApplicationBeanLoader.INSTANCE.getInstance();
	}
}