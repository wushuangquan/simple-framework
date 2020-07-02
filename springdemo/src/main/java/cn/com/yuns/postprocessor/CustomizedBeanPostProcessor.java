package cn.com.yuns.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

/**
 * @author wsq
 * @version  CustomizedBeanPostProcessor.java  2020/6/30  上午7:08 下午
 *
 * 该功能可以用于对 Bean 的包装，包装上一些通用的逻辑，在 Bean实例创建出来之后，postProcessAfterInitialization
 * 进行一些处理，如做耗时统计方面的的日志记录，增强后再返回
 */
@Configuration
public class CustomizedBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(beanName + "调用了 postProcessBeforeInitialization");
		//对 bean做任何操作，处理
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(beanName + "调用了 postProcessAfterInitialization");
		//对 bean做任何操作，处理
		return bean;
	}
}
