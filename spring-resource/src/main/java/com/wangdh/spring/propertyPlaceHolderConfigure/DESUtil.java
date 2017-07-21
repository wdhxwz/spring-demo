package com.wangdh.spring.propertyPlaceHolderConfigure;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * DES加密帮助类
 * @author wdhcxx
 *
 */
public class DESUtil {
	private static Key key;
	private static String KEY_Str = "1q2w#E$R";
	
	static{
		try {
			KeyGenerator generator = KeyGenerator.getInstance("DES");
			generator.init(new SecureRandom(KEY_Str.getBytes()));
			key = generator.generateKey();
			generator = null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * DES加密,返回base64编码的字符串
	 * @param source
	 * @return
	 */
	public static String encrypt(String source){
		BASE64Encoder base64 = new BASE64Encoder();
		try {
			byte[] strBytes = source.getBytes("utf-8");
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] enctyptBytes = cipher.doFinal(strBytes);
			
			return base64.encode(enctyptBytes);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * DES解密
	 * @param source base64编码的加密字符串
	 * @return
	 */
	public static String decrypt(String source){
		BASE64Decoder base64 = new BASE64Decoder();
		try {
			byte[] strBytes = base64.decodeBuffer(source);
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] dectyptBytes = cipher.doFinal(strBytes);
			
			return new String(dectyptBytes,"UTF-8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(encrypt("1q2w#E$R"));
		System.out.println(decrypt("rmxbyoNwb/y6M7Y0HrziuQ=="));
	}
}
