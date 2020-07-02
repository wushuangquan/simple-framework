package cn.com.yuns.demo;

import org.springframework.core.ResolvableType;

import java.util.HashMap;
import java.util.List;

/**
 * @author wsq
 * @version ResolvableDemo.java  2020/6/30  上午9:29 下午
 */
public class ResolvableDemo {

	private HashMap<String, List<Integer>> customizedMap;

	public static void main(String args[]) throws NoSuchFieldException {
		//通过 反射 获取目标类的信息 HashMap<String, List<Integer>> customizedMap
		ResolvableType resolvableType = ResolvableType.forField(ResolvableDemo.class.getDeclaredField("customizedMap"));
		System.out.println("resolvableType.getGeneric(0).resolve()     " + resolvableType.getGeneric(0).resolve());
		System.out.println("resolvableType.getGeneric(1).resolve()     " + resolvableType.getGeneric(1).resolve());
		System.out.println("resolvableType.getGeneric(1)               " + resolvableType.getGeneric(1));
		System.out.println("resolvableType.getSuperType()              " + resolvableType.getSuperType());
		System.out.println("resolvableType.asMap()                     " + resolvableType.asMap());
		System.out.println("resolvableType.getGeneric(0,1)             " + resolvableType.getGeneric(0, 1));
	}
}
