package com.wangdh.spring.propertyPlaceHolderConfigure;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64Util {
	/**
	 * base64编码，使用utf-8
	 * 
	 * @param source
	 * @return
	 */
	public static String encode(String source) {
		BASE64Encoder base64 = new BASE64Encoder();
		try {
			byte[] bytes = source.getBytes("utf-8");
			return base64.encode(bytes);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * base64编码，使用utf-8
	 * 
	 * @param source
	 * @return
	 */
	public static String decode(String source) {
		BASE64Decoder base64 = new BASE64Decoder();
		try {
			byte[] bytes =base64.decodeBuffer(source);
			return new String(bytes, "utf-8");
		} catch (IOException e) {
			throw new RuntimeException(e);
		} 
	}
}
