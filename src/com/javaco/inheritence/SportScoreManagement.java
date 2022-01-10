package com.javaco.inheritence;

import java.util.Scanner;

public class SportScoreManagement {

	public static void main(String args[]) {
		try (Scanner sc = new Scanner(System.in);) {
			int[] hockeyPlayers = new int[11];
			int[] footballPlayers = new int[11];

			for (int i = 0; i < 11; i++) {
				hockeyPlayers[i] = sc.nextInt();
			}

			for (int i = 0; i < 11; i++) {
				footballPlayers[i] = sc.nextInt();
			}

			Sport s = new Sport(hockeyPlayers, footballPlayers);
			HockeyTeam.class.getMethod("calculateHockeyScore");
			HockeyTeam.class.getMethod("findHighestGoalByIndividualInHockey");
			FootballTeam.class.getMethod("calculateFootballScore");
			FootballTeam.class.getMethod("findHighestGoalByIndividualInFootball");

			if (s instanceof HockeyTeam && s instanceof FootballTeam) {
				System.out.println(s.calculateHockeyScore());
				System.out.println(s.calculateFootballScore());
				System.out.println(s.findHighestGoalByIndividualInHockey());
				System.out.println(s.findHighestGoalByIndividualInFootball());
			}

		} catch (Exception e) {
			e.getStackTrace();
		}

	}

}
