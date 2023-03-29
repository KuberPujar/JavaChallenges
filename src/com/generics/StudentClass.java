package com.generics;

public class StudentClass {
	 public String getQuery(String studentData,String query){
	        String output="";
	        String[] split=query.split(",");
	        int q=Integer.parseInt(split[0]);
	        
	        switch(q)
	        {
	        case 1:
	        	String beginChar=split[1];
	        	StudentList<String> case1=new StudentList<>();
	        	String[] c1Str=studentData.split(" ");
	        	for(int i=0;i<c1Str.length;i++)
	        	{
	        		case1.addElement(c1Str[i]);
	        	}
	        	output=case1.beginsWith(beginChar);
	        	break;
	        case 2:
	        	StudentList<String> case2=new StudentList<>();
	        	String[] c2Str=studentData.split(" ");
	        	for(int i=0;i<c2Str.length;i++)
	        	{
	        		case2.addElement(c2Str[i]);
	        	}
	        	String[] c2B=split[1].split(" ");
	        	String searchBg=split[2];
	        	output=case2.bloodGroupOf(c2B, searchBg);
	        	break;
	        case 3:
	        	String threshold=split[1];
	        	StudentList<Integer> case3=new StudentList<>();
	        	String[] c3Str=studentData.split(" ");
	        	for(int i=0;i<c3Str.length;i++)
	        	{
	        		case3.addElement(Integer.parseInt(c3Str[i]));
	        	}
	        	output=case3.thresholdScore(Integer.parseInt(threshold))+" students scored "+threshold+" above";
	        	break;
	        case 4:
	        	ScoreList<Integer> case4=new ScoreList<>();
	        	String[] c4Str=studentData.split(" ");
	        	for(int i=0;i<c4Str.length;i++)
	        	{
	        		case4.addElement(Integer.parseInt(c4Str[i]));
	        	}
	            output=String.format("%.2f",case4.averageValues());
	        	break;
	        case 5:
	        	ScoreList<Double> case5=new ScoreList<>();
	        	String[] c5Str=studentData.split(" ");
	        	for(int i=0;i<c5Str.length;i++)
	        	{
	        		case5.addElement(Double.parseDouble(c5Str[i]));
	        	}
	            output=String.format("%.2f",case5.averageValues());
	        	break;
	        }
			return output;
			
	    }
}
