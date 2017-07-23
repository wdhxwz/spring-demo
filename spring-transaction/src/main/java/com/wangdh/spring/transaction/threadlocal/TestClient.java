package com.wangdh.spring.transaction.threadlocal;

public class TestClient extends Thread {
	private SequenceNumber sequenceNumber;

	public TestClient(SequenceNumber sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println(
					"thread[" + Thread.currentThread().getName() + "] sn[" + sequenceNumber.getNextNum() + "]");
		}
	}
}
