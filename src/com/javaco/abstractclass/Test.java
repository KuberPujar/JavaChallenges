package com.javaco.abstractclass;

import java.text.DecimalFormat;

public class Test {

	 static Aided aided= new Aided();;
	 static   SelfFinance self = new SelfFinance();
	   
	public static void main(String[] args) {

		/*
		 * String allMarks="67 4,34 2,54 5,100 2|1,100,5|0,100,5"; String
		 * actual=aided.result(allMarks); System.out.println(actual); StringBuilder
		 * str=new StringBuilder("5.536"); str.delete(str.length()-1, str.length());
		 * System.out.println("double : " +str.toString().hashCode()); DecimalFormat df
		 * = new DecimalFormat("0.00"); String result = df.format(34.4959);
		 * System.out.println(result);
		 */
        String allMarks1="100 5,100 5,53 5,76 3|0,100,5";
        String actual1=self.result(allMarks1);
        System.out.println(actual1);
        String i="5.62";
        System.out.println(i.hashCode());
	}

}
