package com.generics;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ScoreList<String> s1 = new ScoreList<>();
		s1.addElement(10);
		s1.addElement(20);
		s1.addElement(30);
		System.out.println(s1.averageValues());
		
		ScoreList<String> s5 = new ScoreList<>();
		s5.addElement(10);
		s5.addElement(20);
		s5.addElement(30);
		System.out.println(s5.averageValues());
		
		ScoreList<String> s4 = new ScoreList<>();
		s4.addElement(10);
		s4.addElement(20);
		System.out.println(s4.getElement(0));
		StudentList<String> s = new StudentList<>();
//Ram Vijay Vinay Rahul Arun

//System.out.println(s.get(0));
		//System.out.println(s.beginsWith("v"));
//B- AB- B- O+ B-
		
				s.addElement("B- Ram");
				s.addElement("AB- Vijay");
				s.addElement("B- Vinay");
				s.addElement("O+ Rahul");
				s.addElement("B- Arun");
				//System.out.println(s.get(0));
			Iterator<String> g=	s.stream().iterator();
			String dd="";
			while(g.hasNext())
			{
				String v=g.next();
				System.out.println(v);
				if(v.contains("B-"))
				{
					String[] j=v.split(" ");
					dd+=j[1]+"\n";
				}
			}
			System.out.println(dd);
	}

}
