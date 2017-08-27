package com.wangdh.spring.cache;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wangdh.spring.cache.config.RedisCacheConfig;
import com.wangdh.spring.cache.service.UserService;

/**
 * Spring Cache + Redis + Spring-Data-Redis
 * 
 * @author wdhcxx
 *
 */
public class RedisCacheApp {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RedisCacheConfig.class);

		UserService userService = context.getBean(UserService.class);
		// for (int i = 0; i < 100; i++) {
		// Thread thread = new Thread(new Runnable() {
		// @Override
		// public void run() {
		// System.out.println(userService.getUser("1").toString());
		// try {
		// Thread.sleep(1000);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// }
		// });
		// thread.setName("Thread" + i);
		// thread.start();
		// System.out.println("Thread" + i);
		// }

		for(int j = 0;j<10;j++){
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					int i = 0;
					while (true) {
						System.out.println(userService.getUser(i + "").toString());
						i++;
						if (i > 1000) {
							i = 0;
						}
					}

				}
			});
			thread.start();
		}
		
		// System.out.println(userService.getUser("1").toString());
		// System.out.println(userService.getUser("2").toString());
		// System.out.println(userService.getUser("1").toString());
		// System.out.println(userService.getUser("2").toString());

		// System.out.println("OK");
		//
		//
		// context.close();
		// try {
		// System.in.read();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
	}
}
