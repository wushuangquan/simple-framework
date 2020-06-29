package cn.com.yuns.demo.resource;

import org.springframework.core.io.FileSystemResource;

import java.io.BufferedWriter;
import java.io.File;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * @author wsq
 * @version ResourceDemo.java  2020/6/26  上午3:29 下午
 */
public class ResourceDemo {

	public static void main(String args[]) throws Exception {
		FileSystemResource fileSystemResource = new FileSystemResource("/Users/wsq/Documents/spring/spring-framework-5.2.0.RELEASE/springdemo/src/main/java/cn/com/yuns/demo/resource/test.txt");
		File file = fileSystemResource.getFile();
		System.out.println(file.length());
		OutputStream outputStream = fileSystemResource.getOutputStream();
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
		bufferedWriter.write("hell world");
		bufferedWriter.flush();
		outputStream.close();
		bufferedWriter.close();
	}
}
