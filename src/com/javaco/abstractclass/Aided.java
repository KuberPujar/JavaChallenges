package com.javaco.abstractclass;

public class Aided extends Student{

	@Override
    public String result(String allMarks) {
		if(allMarks.contains("|"))
		{
			allMarks=allMarks.replace("|", "#");
		}
		
		String[] str=allMarks.split("#");
		String[] subJ=str[0].split(",");
		String[] ncc=str[1].split(",");
		String[] spt=str[2].split(",");
		
		double totalCreditPoints=0;
		double totolMarks=0;
		for(int i=0;i<subJ.length;i++)
		{
			String[] s=subJ[i].split(" ");
			double marks=Double.parseDouble(s[0]);
			double cp=Double.parseDouble(s[1]);
			
			if(marks<=100 && cp<=5)
			{
				totalCreditPoints+=1;
				totolMarks+=(getGradePtOfMark(marks)) * cp;
			}
		}
	
		int isNcc=Integer.parseInt(ncc[0]);
		if(isNcc==1)
		{
			double marks=Double.parseDouble(ncc[1]);
			double cp=Double.parseDouble(ncc[2]);
			if(marks<=100 && cp<=5)
			{
				totalCreditPoints+=1;
				totolMarks+=(getGradePtOfMark(marks)) * cp;
			}
		}
		
		
		int isSprt=Integer.parseInt(spt[0]);
		if(isSprt==1)
		{
			double marks=Double.parseDouble(spt[1]);
			double cp=Double.parseDouble(spt[2]);
			if(marks<=100 && cp<=5)
			{
				totalCreditPoints+=1;
				totolMarks+=(getGradePtOfMark(marks)) * cp;
			}
		}
		
		double totalCgps=0;
		if(totalCreditPoints!=0)
		{
			totalCgps=totolMarks/(totalCreditPoints*5);
		}
		String result=String.format("%.2f", totalCgps);
		return result;
		
    }
   
	public static double getGradePtOfMark(double marks)
	{
		double gp=0;
		if(marks>=75 && marks<=100)
		{
			if(marks>=75 && marks<100)
			{
				gp=9.0+Double.parseDouble(String.format("%.1f", (0.04*(marks-75))));
			}
			else if(marks==100)
			{
				gp= 10.0;
			}
		}
		else if(marks>=60 && marks<=74)
		{
			if(marks>=60 && marks<74)
			{
				gp= 8.0+Double.parseDouble(String.format("%.1f", (0.06*(marks-60))));
			}
			else if(marks==74)
			{
				gp= 8.9;
			}
		}
		else if(marks>=50 && marks<=59)
		{
			if(marks>=50 && marks<59)
			{
				gp= 7.0+Double.parseDouble(String.format("%.1f", (0.1*(marks-50))));
			}
			else if(marks==59)
			{
				gp= 7.9;
			}
		}
		else if(marks>=40 && marks<=49)
		{
			if(marks>=40 && marks<49)
			{
				gp= 6.0+Double.parseDouble(String.format("%.1f", (0.1*(marks-40))));
			}
			else if(marks==49)
			{
				gp= 6.9;
			}
		}
		else if(marks<40)
		{
			gp= 0.0;
		}
		return gp;
	}
}
