package com.controlstatements;

public class Result {
	private Result() {

	}

	public static String[] calculateGrade(int[][] students_marks) {

		double avg = 0;
		String[] grades = new String[students_marks.length];
		for (int rows = 0; rows < students_marks.length; rows++) {
			double sum = 0;
			for (int col = 0; col < students_marks[rows].length; col++) {
				sum = sum + students_marks[rows][col];
				avg = sum / students_marks[rows].length;
			}

			if (avg >= 90) {
				grades[rows] = "A+";
			} else if (avg >= 80 && avg < 90) {
				grades[rows] = "A";
			} else if (avg >= 70 && avg < 80) {
				grades[rows] = "B";
			} else if (avg >= 60 && avg < 70) {
				grades[rows] = "C";
			} else if (avg >= 50 && avg < 60) {
				grades[rows] = "D";
			} else if (avg < 50) {
				grades[rows] = "F";
			}
		}

		return grades;

	}
}
