package com.wangdh.spring.locale;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Java内置的资源本地化
 * <资源名>_<语言代码>_<国家/地区代码>.properties
 * @author wdhcxx
 *
 */
public class App {
	public static void main(String[] args) {
//		// 获取指定地区，指定语言
//		Locale locale1 = new Locale("zh", "CN");
//		
//		// 获取指定语言，系统默认地区
//		Locale locale2 = new Locale("zh");
//		Locale locale4 = Locale.CHINESE;
//		
//		// 获取指定地区，系统默认语言
//		Locale locale3 = Locale.CHINA;
//		
//		// 获取系统默认地区和语言
//		Locale locale5 = Locale.getDefault();
		
		Locale en_US = new Locale("en", "US");
		Locale zh_CN = new Locale("zh", "CN");
		
		NumberFormat currFormat = NumberFormat.getCurrencyInstance(en_US);
		double amt = 123456.78;
		System.out.println(currFormat.format(amt));
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM,zh_CN);
		System.out.println(dateFormat.format(date));
		
		String pattern = "{0},您好！您于{1}在工商银行存入{2}元。";
		String pattern2 = "At {1,time,short} On {1,date,long},{0} paid {2,number,currency}.";
		MessageFormat messageFormat = new MessageFormat(pattern2, en_US);
		
		Object[] params = {"John",new GregorianCalendar().getTime(),1.0E3};
		
		String msg1 = MessageFormat.format(pattern, params);
		System.out.println(msg1);
		
		String msg2 = messageFormat.format(params);
		System.out.println(msg2);
		
		ResourceBundle resourceBundle = ResourceBundle.getBundle("locale/resource", en_US);
		System.out.println(MessageFormat.format(resourceBundle.getString("greeting.common"), params));
		
		resourceBundle = ResourceBundle.getBundle("locale/resource");
		System.out.println(MessageFormat.format(resourceBundle.getString("greeting.morning"), params));
		
		// 没找到指定语言的资源文件，会找系统默认的本地资源文件
		resourceBundle = ResourceBundle.getBundle("locale/resource", Locale.CANADA);
		System.out.println(MessageFormat.format(resourceBundle.getString("greeting.afternoon"), params));
	}
}