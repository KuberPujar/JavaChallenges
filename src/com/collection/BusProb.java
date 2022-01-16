package com.collection;

import java.util.*;
public class BusProb {
	List<String> str=new ArrayList<>();
	public String output(int capacity, int stops, List<String> listOfInputStrings, String query) {
		String outstring = "";
		String id=null;
		if(query.contains(", "))
		{
			String str[]=query.split(", ");
			query=str[0];
			 id=str[1].trim();
		}
		switch (query) {
		case "1":
			int onCount = 0;
			int outCount = 0;
			for (int i = 0; i < listOfInputStrings.size(); i++) {
				String str = listOfInputStrings.get(i);
				String[] t = str.split(" ");
				for (int j = 0; j < t.length; j++) {
					if (t[j].startsWith("+")) {
						onCount += 1;
					} else if (t[j].startsWith("-")) {
						outCount += 1;
					}
				}
			}
			outstring= onCount+" passengers got on bus and "+outCount+" passengers got out of bus";
			break;
		case "2":
			int totalNoOfpass = 0;
			int cntPayLess25 = 0;
			int cntPayGreater25 = 0;
			int countPayingN = 0;
			float val;
			for (int i = 0; i < listOfInputStrings.size(); i++) {
				String[] str = listOfInputStrings.get(i).split(" ");
				if (i == 0) {
					totalNoOfpass = str.length;
					val = (totalNoOfpass * 100.0f) / capacity;
					if (val <= 25.0) {
						cntPayLess25 = totalNoOfpass;
					} else if (val > 25.0 && val <= 50.0) {
						cntPayGreater25 = totalNoOfpass;
					} else if (val > 50.0) {
						countPayingN = totalNoOfpass;
					}
				} else {
					int inCount = 0;
					int ouCount = 0;
					for (int j = 0; j < str.length; j++) {
						if (str[j].startsWith("+")) {
							inCount += 1;
						} else if (str[j].startsWith("-")) {
							ouCount += 1;
						}
					}
					totalNoOfpass = totalNoOfpass + inCount - ouCount;
					val = (totalNoOfpass * 100.0f) / capacity;
					if (val <= 25.0) {
						cntPayLess25 += inCount;
					} else if (val > 25.0 && val <= 50.0) {
						cntPayGreater25 += inCount;
					} else if (val > 50.0) {
						countPayingN += inCount;
					}
				}

			}

			outstring= cntPayLess25 + " passengers taveled with a fare of " + (capacity + (capacity * .6)) + ","
					+ cntPayGreater25 + " passengers traveled with a fare of " + (capacity + (capacity * .3)) + " and "
					+ countPayingN + " passengers traveled with a fare of " + Double.valueOf(capacity);
			break;
		case "3":
			double fare=0;
			int totalPass=0;
			for(int i=0;i<listOfInputStrings.size();i++)
			{
			
				int inCount=0;
				int oCount=0;
				
				String[] str=listOfInputStrings.get(i).split(" ");
				
			
				for(int j=0;j<str.length;j++)
				{
					
					if(str[j].startsWith("+"))
					{
						inCount+=1;
					}
					else if(str[j].startsWith("-"))
					{
						oCount+=1;
					}
					
				}
				totalPass=totalPass+inCount-oCount;
				
				for(int j=0;j<str.length;j++)
				{
					if(str[j].contains(id) && str[j].startsWith("+"))
					{
						float per = (totalPass * 100.0f) / capacity;
						if (per <= 25.0) {
							fare+=capacity+(capacity*.6);
						} else if (per > 25.0 && per <= 50.0) {
							fare+=capacity+(capacity*.3);
						} else if (per > 50.0) {
							fare+=capacity;
						}
					}
				}
				
			}

			outstring= "Passenger "+id+" spent a total fare of "+fare;
			break;
		case "4":
			int iCount=0;
			for(int i=0;i<listOfInputStrings.size();i++)
			{
				String str[]=listOfInputStrings.get(i).split(" ");
				for(int j=0;j<str.length;j++)
				{
					if(str[j].contains(id) && str[j].startsWith("+"))
					{
						iCount+=1;
					}
				}
			}
			
			outstring= iCount+" times passenger "+id+" got on the bus";
			break;
		case "5":
			String[] sss=listOfInputStrings.get(listOfInputStrings.size()-1).split(" ");
			boolean flag=false;
			for(int i=0;i<sss.length;i++)
			{
				if(sss[i].contains(id))
				{
					flag=true;
				}
			}
			
			if(flag)
			{
				outstring= "Passenger "+id+" was inside the bus at end of the trip";
			}
			else
			{
				outstring="Passenger "+id+" was not inside the bus at end of the trip";
			}
			break;
		}	
		
		return outstring;
	}
}
