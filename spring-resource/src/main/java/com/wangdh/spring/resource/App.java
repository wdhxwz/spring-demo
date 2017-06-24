package com.wangdh.spring.resource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		String filePath = "D:\\logs\\test.txt";
		WritableResource writableResource = new PathResource(filePath);

		Resource resource = new ClassPathResource("readme.txt");

		try (OutputStream outputStream = writableResource.getOutputStream();) {
			outputStream.write("spring 资源接口练习".getBytes());
		}

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		InputStream inputStream = resource.getInputStream();
		int i;
		while ((i = inputStream.read()) != -1) {
			byteArrayOutputStream.write(i);
		}
		System.out.println(byteArrayOutputStream.toString("UTF-8"));
		System.out.println(writableResource.getFilename());
		System.out.println(resource.getFilename());
		System.out.println(resource.getDescription());
		System.out.println(resource.getURI().getPath());
	}
}