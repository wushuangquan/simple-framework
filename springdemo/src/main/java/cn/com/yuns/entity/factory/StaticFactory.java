package cn.com.yuns.entity.factory;

import cn.com.yuns.entity.User;

public class StaticFactory {

	public static User getUser() {
		return new User();
	}
}
