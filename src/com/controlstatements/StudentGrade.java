package com.controlstatements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StudentGrade {

	public static void main(String[] args) throws IOException {
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
        String outputPath="D:\\ChallengeResults\\st.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputPath));

        int students_marksRows = Integer.parseInt(sc.next().trim());
        int students_marksColumns = Integer.parseInt(sc.next().trim());
		
		
		int[][] students_marks = new int[students_marksRows][students_marksColumns];
		for(int i = 0; i < students_marksRows; i++)
        {
			for(int j = 0; j < students_marksColumns; j++)
			{
				students_marks[i][j] = Integer.parseInt(sc.next().trim());	
			}
        }

	
		 String[] result = Result.calculateGrade(students_marks);
		  
		  for(int i = 0; i < result.length; i++) { System.out.println(result[i]);
		  bufferedWriter.write(result[i]+"\n"); }
	
        bufferedWriter.close();
    }
	
}
