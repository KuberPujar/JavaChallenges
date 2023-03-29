package com.javaco.inheritence;

public class Sport implements FootballTeam, HockeyTeam {
	private int[] hockeyPlayers;
	private int[] footballPlayers;
	
	public Sport(int[] hockeyPlayers,int[] footballPlayers)
	{
		this.hockeyPlayers=hockeyPlayers;
		this.footballPlayers=footballPlayers;
	}

	@Override
	public int calculateHockeyScore() {
		int total=0;
		for(int i=0;i<hockeyPlayers.length;i++)
		{
			total+=hockeyPlayers[i];
		}
		return total;
	}

	@Override
	public int findHighestGoalByIndividualInHockey() {
		int max=hockeyPlayers[0];
		for(int i=0;i<hockeyPlayers.length;i++)
		{
			if(max<hockeyPlayers[i])
			{
				max=hockeyPlayers[i];
			}
		}
		return max;
	}

	@Override
	public int calculateFootballScore() {
		int total=0;
		for(int i=0;i<footballPlayers.length;i++)
		{
			total+=footballPlayers[i];
		}
		return total;
	}

	@Override
	public int findHighestGoalByIndividualInFootball() {
		int max=footballPlayers[0];
		for(int i=0;i<footballPlayers.length;i++)
		{
			if(max<footballPlayers[i])
			{
				max=footballPlayers[i];
			}
		}
		return max;
	}

}
