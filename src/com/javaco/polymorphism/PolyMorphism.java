package com.javaco.polymorphism;

import java.util.Scanner;

public class PolyMorphism {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in);)
		{
			int startElement = Integer.parseInt(sc.next().trim());
			int endElement = Integer.parseInt(sc.next().trim());
			ChildOne one = new ChildOne(startElement, endElement);
			System.out.println(one.filter());
			ChildTwo two = new ChildTwo(startElement, endElement);
			System.out.println(two.filter());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

}

class Parent {
	public int startElement;
	public int endElement;

	Parent(int startElement, int endElement) {
		this.startElement = startElement;
		this.endElement = endElement;
	}

	String filter() {
		return null;
	}
}

class ChildOne extends Parent {
	ChildOne(int startElement, int endElement) {
		super(startElement, endElement);
	}

	@Override
	String filter() {
		StringBuilder str = new StringBuilder();
		int count;
		for (int i = startElement; i <= endElement; i++) {
			count = 0;
			for (int j = 1; j <= i; j++) {
				if (i % j == 0) {
					count = count + 1;
				}
			}
			if (count == 2) {
				str.append(i);
				str.append(" ");
			}
		}
		return str.toString();
	}
}

class ChildTwo extends Parent {
	ChildTwo(int startElement, int endElement) {
		super(startElement, endElement);
	}

	@Override
	String filter() {
		StringBuilder str = new StringBuilder();
		for (int i = startElement; i <= endElement; i++) {
			int result = i;
			// Happy number always ends with 1 and
			// unhappy number ends in a cycle of repeating numbers which contains 4
			while (result != 1 && result != 4) {
				result = isHappyNumber(result);
			}

			if (result == 1)
				str.append(i + " ");
		}

		return str.toString();
	}

	public static int isHappyNumber(int num) {
		int rem = 0, sum = 0;
		while (num > 0) {
			rem = num % 10;
			sum = sum + (rem * rem);
			num = num / 10;
		}
		return sum;
	}
}