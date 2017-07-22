package com.wangdh.spring.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * Spring SpEL : Spring 动态表达式语言
 * 
 * @author wdhcxx
 *
 */
public class SpelHello {
	public static void main(String[] args) {
		long begin = 0;
		long end = 0;
		
		// SpEL表达式解析器
		ExpressionParser parser = new SpelExpressionParser();

		// 解析成表达式:文本解析
		Expression expression = parser.parseExpression("'Hello '+' World'");
		begin = System.currentTimeMillis();
		String message = expression.getValue(String.class);
		end = System.currentTimeMillis();
		System.out.println(message);
		System.out.println(end - begin);

		// 调用字符串的concat()函数
		begin = System.currentTimeMillis();
		expression = parser.parseExpression("'Hello World'.concat('!')");
		end = System.currentTimeMillis();
		System.out.println(expression.getValue());
		System.out.println(end - begin);

		// 实例对象的属性求值：对象属性解析，内部使用反射，会进行缓存
		User user = new User();
		user.setUserName("wangdh");
		user.setCredit(100);

		// 求值上下文：xx.yy.zz
		EvaluationContext context = new StandardEvaluationContext(user);
		begin = System.currentTimeMillis();
		String userName = parser.parseExpression("userName").getValue(context, String.class);
		end = System.currentTimeMillis();
		System.out.println(userName);
		System.out.println(end - begin);
		begin = System.currentTimeMillis();
		userName = parser.parseExpression("userName").getValue(context, String.class);
		end = System.currentTimeMillis();
		System.out.println(end - begin);

	}
}