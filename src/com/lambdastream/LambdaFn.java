package com.lambdastream;

import java.util.*;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class LambdaFn {
	static final Logger LOGGER = Logger.getLogger("LambdaFn");

	public List<Long> functionalProgramming(List<String> listOfIntegers) {
		// Write your code here
		Iterator<String> outputList1 = listOfIntegers.stream().filter(s ->s.equals(narcissisticNum(s)))
				.map(String::toString).iterator();
		List<Long> outputList = new ArrayList<>();
		LOGGER.log(Level.INFO, "narcissistic num list:" + outputList1);
        while(outputList1.hasNext())
        {
        	outputList.add(Long.parseLong(outputList1.next()));
        }

		return outputList;

	}

	public static String narcissisticNum(String number) {
		int sum = 0;
		int length = number.length();

		// Traversing through the string
		for (int i = 0; i < length; i++) {

			// Since ascii value of numbers
			// starts from 48 so we subtract it from sum
			sum = sum + (int) Math.pow(number.charAt(i) - '0', length);
		}

		return String.valueOf(sum);
	}

}