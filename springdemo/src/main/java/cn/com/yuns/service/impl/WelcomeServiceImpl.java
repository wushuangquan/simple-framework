package cn.com.yuns.service.impl;

import cn.com.yuns.service.WelcomeService;
import org.springframework.stereotype.Service;

@Service
public class WelcomeServiceImpl implements WelcomeService {

	@Override
	public String sayHello(String naem) {
		System.out.println("Hellow :" + naem);
		return "success";
	}
}
