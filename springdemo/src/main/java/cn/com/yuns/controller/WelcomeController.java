package cn.com.yuns.controller;

import cn.com.yuns.service.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class WelcomeController {

	@Autowired
	private WelcomeService welcomeService;

	public void doRequest() {
		welcomeService.sayHello("来自Controller的调用问候");
	}
}
