package com.wangdh.spring.mvc.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * 文件控制器
 * 
 * @author wdhcxx
 *
 */
@Controller
@RequestMapping("/file")
public class FileController {
	private static Logger logger = LoggerFactory.getLogger(FileController.class);

	/**
	 * 参数名称必须一致，才能绑定成功
	 * 
	 * @param file
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping("/upload")
	@ResponseBody
	public String upload(@RequestParam("file") CommonsMultipartFile file) throws IllegalStateException, IOException {
		if (file != null && !file.isEmpty()) {
			file.transferTo(new File("D:\\temp\\" + System.currentTimeMillis() + file.getOriginalFilename()));
		}

		return "success";
	}

	@RequestMapping("/upload2")
	@ResponseBody
	public String upload2(MultipartFile file) throws IllegalStateException, IOException {
		if (file != null && !file.isEmpty()) {
			try {
				OutputStream outputStream = new FileOutputStream(
						"D:\\temp\\" + System.currentTimeMillis() + file.getOriginalFilename());
				InputStream inputStream = file.getInputStream();
				int temp;
				while ((temp = inputStream.read()) != -1) {
					outputStream.write(temp);
				}
				outputStream.flush();
				outputStream.close();
				inputStream.close();
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}

		return "success2";
	}

	@RequestMapping("/upload3")
	@ResponseBody
	public String upload3(HttpServletRequest request) throws IllegalStateException, IOException {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		if (multipartRequest != null) {
			Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
			for (Entry<String, MultipartFile> entry : fileMap.entrySet()) {
				MultipartFile file = entry.getValue();
				file.transferTo(new File("D:\\temp\\" + System.currentTimeMillis() + file.getOriginalFilename()));
			}
		}

		return "success3";
	}
}
