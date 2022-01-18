package com.generics;

import java.util.ArrayList;
import java.util.Iterator;

public class StudentList<T> extends ArrayList<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<Object> arr = null;

	public StudentList() {
		arr = new ArrayList<>();
	}

	public <T> void addElement(T t) {
		arr.add(t);
	}

	public <T> void removeElement(T t) {
		arr.remove(t);
	}

	public <T> Object getElement(int index) {
		return arr.get(index);
	}

	public String beginsWith(String str) {
	Iterator<Object> i=	arr.stream().iterator();
		String y = "";
		while(i.hasNext())
		{
			String strs=(String)i.next();
			if(strs.contains(str.toUpperCase()))
			{
				y += strs + "\n";
			}
		}
		
		return y;
	}

	public String bloodGroupOf(String[] s, String str) {
		String d="";
		for(int i=0;i<s.length;i++)
    	{
    		if(s[i].equals(str))
    		{
    			d+=arr.get(i)+"\n";
    		}
    	}
		return d;
	}

	public int thresholdScore(int score) {
		Iterator<Object> i=	arr.stream().iterator();
		int count =0;
		while(i.hasNext())
		{
			int strs=(Integer)i.next();
			if(strs>=score)
			{
				count+=1;
			}
		}
		
		return count;
	}
}
