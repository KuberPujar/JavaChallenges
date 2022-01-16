package com.collection;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// 25% of 4
		// fare depends on capacity n
		// <=25% of passengers then fare=n+n*0.6
		// passenger count>25% and <=50% then fare=n+n*0.3;
		// if no of passengers>50% the fare=n
		// n%2 or n%4!=0 convert it to its ceiling value.

		// inputs
		// seating capacity=n,
		// arrayList of Strings representing passengers id with - or +
		// a query q

		// Queries
		// 1
		// find out no of passengers who got on or out of the bus
		// 2
		// find out passengers who have travelled with a fare of n+n*0.6,n+n*0.3,n
		// 3 passenger id
		// find out how much particular passenger with given passenger id spent on trip
		// 4 passenger id
		// find out how many times particular passener with given id has got on bus.
		// 5 passenger id
		// find out whether the given passenger was on bus or not till the end of the
		// trip.

		// input format
		// first line=n seating capacity of bus
		// second line=x no of stops
		// third line=x strings with passenger got on bus and out of bus
		// fourth line=q (queries 3,4,5 will have comma and space separating the value)

		int capacity = 15;
		int stops = 6;
		List<String> listOfInputs = new ArrayList<>();
		listOfInputs.add("+100 +101 +102 +103 +104 +105");
		listOfInputs.add("+106 +107 +108 -101 -104 -105 -103 -102");
		listOfInputs.add("+101 +109 +110 +111 -106 -100");
		listOfInputs.add("+112 +113 -101 +114 -109 -107 -111 -110");
		listOfInputs.add("+101 -112 -113");
		listOfInputs.add("+115 +116 -101 +112");
		
		
		
		
		

		

	}

}
