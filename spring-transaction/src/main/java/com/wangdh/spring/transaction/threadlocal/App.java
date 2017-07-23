package com.wangdh.spring.transaction.threadlocal;

public class App {

	public static void main(String[] args) {
		SequenceNumber sequenceNumber = new SequenceNumber();
		TestClient client1 = new TestClient(sequenceNumber);
		TestClient client2 = new TestClient(sequenceNumber);
		TestClient client3 = new TestClient(sequenceNumber);
		client1.start();
		client2.start();
		client3.start();
	}
}
