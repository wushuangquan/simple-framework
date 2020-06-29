package cn.com.yuns.demo;

import cn.com.yuns.controller.WelcomeController;
import cn.com.yuns.entity.User;
import cn.com.yuns.entity.factory.UserFactoryBean;
import cn.com.yuns.service.WelcomeService;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.FileSystemXmlApplicationContext;

@Configurable
@ComponentScan("cn.com.yuns")
public class Entrance {

	/**
	 * 配置引入
	 *
	 * @param args
	 */
	public static void main1(String args[]) {
		System.out.println("Spring 项目成功编译！！！！走配置使用Spring");
		String path = "//Users/wsq/Documents/spring/spring-framework-5.2.0.RELEASE/springdemo/src/main/resources/spring/spring-config.xml";
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext(path);
		WelcomeService ws = (WelcomeService) applicationContext.getBean("welcomeService");
		ws.sayHello("wsq");
		User user1a = (User) applicationContext.getBean("user1");
		User user1b = (User) applicationContext.getBean("user1");
		User user2a = (User) applicationContext.getBean("user2");
		User user2b = (User) applicationContext.getBean("user2");
		User user3a = (User) applicationContext.getBean("user3");
		User user3b = (User) applicationContext.getBean("user3");
		System.out.println("无参构造函数创建的对象" + user1a);
		System.out.println("无参构造函数创建的对象" + user1b);
		System.out.println("静态工厂创建的对象" + user2a);
		System.out.println("静态工厂创建的对象" + user2b);
		System.out.println("实例工厂创建的对象" + user3a);
		System.out.println("实例工厂创建的对象" + user3b);
		User userFactoryBean1 = (User) applicationContext.getBean("userFactoryBean");
		User userFactoryBean2 = (User) applicationContext.getBean("userFactoryBean");
		System.out.println("userFactoryBean1：" + userFactoryBean1);
		System.out.println("userFactoryBean2：" + userFactoryBean2);
		//需要使用如下方式获取 UserFactoryBean
		UserFactoryBean userFactoryBean3 = (UserFactoryBean) applicationContext.getBean("&userFactoryBean");
		UserFactoryBean userFactoryBean4 = (UserFactoryBean) applicationContext.getBean("&userFactoryBean");
		System.out.println("userFactoryBean3：" + userFactoryBean3);
		System.out.println("userFactoryBean4：" + userFactoryBean4);
	}

	/**
	 * 注解引入
	 *
	 * @param args
	 */
	public static void main(String args[]) {
		System.out.println("Spring 项目成功编译！！！！走注解使用Spring");
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Entrance.class);
		WelcomeService ws = (WelcomeService) applicationContext.getBean("welcomeServiceImpl");
		ws.sayHello("wsq");
		WelcomeController controller = (WelcomeController) applicationContext.getBean("welcomeController");
		controller.doRequest();
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println(beanDefinitionName);
		}
		User user5 = (User) applicationContext.getBean("user5");
		System.out.println("CustomizedBeanDefinitionRegistryPostProcessor 注册的额外对象" + user5);
	}
}
