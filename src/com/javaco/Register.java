package com.javaco;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Register {
	private static Register instance;

	private Register() {

	}

	static {
		try {
			instance = new Register();
		} catch (Exception e) {
			throw new RuntimeException("Exception occured while creating Singleton instace of Class Register");
		}
	}

	public static Register getInstance() {
		return instance;
	}

	/*
	 * Complete the 'getTotalBill' function below.
	 *
	 * The function is expected to return a STRING. The function accepts MAP
	 * itemDetails as parameter.
	 */

	public String getTotalBill(Map<String, Integer> itemDetails) {

		// Write your code here

		Set<Entry<String, Integer>> str = itemDetails.entrySet();
		Iterator<Entry<String, Integer>> itr = str.iterator();
		double sum = 0;
		while (itr.hasNext()) {
			Entry<String, Integer> entry = itr.next();
			if(entry.getKey().equalsIgnoreCase("apple"))
			{
				sum=sum+(entry.getValue()*2);
			}else if(entry.getKey().equalsIgnoreCase("orange"))
			{
				sum=sum+(entry.getValue()*1.5);
			}
			else if(entry.getKey().equalsIgnoreCase("mango"))
			{
				sum=sum+(entry.getValue()*1.2);
			}else if(entry.getKey().equalsIgnoreCase("grape"))
			{
				sum=sum+(entry.getValue()*1);
			}
		}
		return String.valueOf(sum);

	}
}
