package com.thread;

import java.util.Scanner;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;

//Write your code here

class Task1 extends Thread {

	public static int a;
	public static int beg;
	CountDownLatch latch;

	public Task1(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {

		for (int i = beg; i <= a; i++) {
			Solution.threadArray[i] = i;
		}
	}

}

class Task2 implements Runnable {

	public static int a;
	public static int beg;
	CountDownLatch latch;

	public Task2(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {

		for (int i = beg; i <= a + beg; i++) {
			Solution.threadArray[i] = i;
		}
	}

}

class Task3 implements Runnable {

	public static int a;
	public static int beg;

	@Override
	public void run() {
		for (int i = beg; i < a + beg; i++) {
			Solution.threadArray[i] = i;
		}
	}

}

public class Solution {
	public static final int[] threadArray = new int[300];
	public static volatile String i = 0 + "";
	CountDownLatch latch = new CountDownLatch(2);

	public boolean test() throws InterruptedException, BrokenBarrierException {
		Task1 task1 = new Task1(latch);
		Task2 task2 = new Task2(latch);
		Task3 task3 = new Task3();
		Thread task2Thread = new Thread(task2);
		Thread task3Thread = new Thread(task3);
		task1.start();
		task2Thread.start();
		latch.countDown();
		task1.join();
		task2Thread.join();
		task3Thread.start();
		int first = Task1.a + Task2.a;
		int containsSecondThread = Task1.a;
		String oneAndTwo = "";
		String sizeOfTask1 = "";
		for (int i = 0; i < first; i++) {
			oneAndTwo += threadArray[i] + " ";
		}
		for (int i = 0; i <= containsSecondThread; i++) {
			sizeOfTask1 += threadArray[i] + " ";
		}
		int begOfTask3 = Task3.beg;
		String checkingString = "";
		for (int i = begOfTask3; i < threadArray.length; i++) {
			checkingString += i + " ";
		}
		String task3String = "";
		for (int j = begOfTask3; j < threadArray.length; j++) {
			task3String += threadArray[j] + " ";
		}
		if ((!oneAndTwo.contains(begOfTask3 + "") && sizeOfTask1.contains(Task2.beg + ""))
				&& task3String.equals(checkingString)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
		Scanner sc = new Scanner(System.in);
		Solution solution = new Solution();
		int one = sc.nextInt();
		Task1.a = one;
		Task1.beg = 0;
		int two = sc.nextInt();
		Task2.a = two;
		Task2.beg = one;
		int three = sc.nextInt();
		Task3.a = three;
		Task3.beg = one + two;
		System.out.print(solution.test());
	}
}