package com.java.concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownPractice {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch cd = new CountDownLatch(3);
		Worker1 w1 = new Worker1(cd, "Test-1");
		Worker1 w2 = new Worker1(cd, "Test-2");
		Worker1 w3 = new Worker1(cd, "Test-3");
		w1.start();
		w2.start();
		w3.start();
		cd.await();
		System.out.println(Thread.currentThread().getName() + "is executed finished");
	}
}

class Worker1 extends Thread {
	CountDownLatch cl;

	public Worker1(CountDownLatch cl, String name) {
		super(name);
		this.cl = cl;
	}

	public void run() {
		try {
			cl.countDown();
			System.out.println(Thread.currentThread().getName() + "is executed finished");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}