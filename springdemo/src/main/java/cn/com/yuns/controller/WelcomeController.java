package cn.com.yuns.controller;

import cn.com.yuns.service.WelcomeService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;

@Controller
public class WelcomeController implements ApplicationContextAware, BeanNameAware {

	private String myName;

	private ApplicationContext myContainer;

	@Autowired
	private WelcomeService welcomeService;

	public void doRequest() {
		welcomeService.sayHello("来自Controller的调用问候");
		System.out.println("我是谁：" + myName);
		System.out.println("我所在的容器：" + myContainer);
		String[] allBeanNames = myContainer.getBeanDefinitionNames();
		for (String beanName : allBeanNames) {
			System.out.println(beanName);
		}
		System.out.println("======================");
	}

	@Override
	public void setBeanName(String name) {
		this.myName = name;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.myContainer = applicationContext;
	}
}
