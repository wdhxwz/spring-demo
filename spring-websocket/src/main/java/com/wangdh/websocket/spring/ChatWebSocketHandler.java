package com.wangdh.websocket.spring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class ChatWebSocketHandler extends TextWebSocketHandler {
	private Logger logger = Logger.getLogger(this.getClass().getName());

	private final static List<WebSocketSession> sessions = Collections
			.synchronizedList(new ArrayList<WebSocketSession>());

	/**
	 * 接收文本消息，并发送出去
	 */
	@Override
	protected void handleTextMessage(WebSocketSession session,
			TextMessage message) throws Exception {
		logger.info("接收到消息:" + message);

		session.sendMessage(new TextMessage(new Date() + ""));
	}

	/**
	 * 连接建立后处理
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session)
			throws Exception {
		logger.info("connect to the websocket chat success......");
		sessions.add(session);

		session.sendMessage(new TextMessage("connect"));
		session.sendMessage(new TextMessage("new_msg"));
	}

	/**
	 * 抛出异常时处理
	 */
	@Override
	public void handleTransportError(WebSocketSession session,
			Throwable exception) throws Exception {
		if (session.isOpen()) {
			session.close();
		}
		logger.info("websocket chat connection closed......");
		sessions.remove(session);
	}

	/**
	 * 连接关闭后处理
	 */
	@Override
	public void afterConnectionClosed(WebSocketSession session,
			CloseStatus closeStatus) throws Exception {
		logger.info("websocket chat connection closed......");
		sessions.remove(session);
	}

	@Override
	public boolean supportsPartialMessages() {
		return false;
	}
}
