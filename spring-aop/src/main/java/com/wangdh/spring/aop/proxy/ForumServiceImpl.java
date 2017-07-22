package com.wangdh.spring.aop.proxy;

public class ForumServiceImpl implements ForumService {

	@Override
	public void removeTopic(String topicId) {
		System.out.println("模拟删除Topic记录：" + topicId);
		try {
			Thread.sleep(20);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void removeForum(String forumId) {
		System.out.println("模拟删除Forum记录：" + forumId);
		try {
			Thread.sleep(40);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}