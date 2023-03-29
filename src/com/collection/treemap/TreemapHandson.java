package com.collection.treemap;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TreemapHandson {

	public TreeMap<Integer, String> createPlayerPositionMap(String cricketDataset) {
		TreeMap<Integer, String> playerPositionMap = new TreeMap<>();
		if (cricketDataset.contains("|")) {
			cricketDataset = cricketDataset.replace("|", "#");
		}
		String[] players = cricketDataset.split("#");
		for (int i = 0; i < players.length; i++) {
			String[] player = players[i].split(",");
			int playerPos = Integer.parseInt(player[0]);
			String playerName = player[1];
			if (playerPositionMap.containsKey(playerPos)) {
				String p = playerPositionMap.get(playerPos);
				playerPositionMap.put(playerPos, p);
			} else {
				playerPositionMap.put(playerPos, playerName);
			}
		}
		return playerPositionMap;

	}

	public TreeMap<String, Integer> createPlayerScoreMap(String cricketDataset) {

		TreeMap<String, Integer> playerScoreMap = new TreeMap<>();
		if (cricketDataset.contains("|")) {
			cricketDataset = cricketDataset.replace("|", "#");
		}
		String[] players = cricketDataset.split("#");
		for (int i = 0; i < players.length; i++) {
			String[] player = players[i].split(",");
			String playerName = player[1];
			int playerScore = Integer.parseInt(player[2]);
			if (playerScoreMap.containsKey(playerName)) {
				int p = playerScoreMap.get(playerName);
				playerScoreMap.put(playerName, p);
			} else {
				playerScoreMap.put(playerName, playerScore);
			}
		}
		return playerScoreMap;

	}

	public SortedMap<String, MatchScore> createMatchesMap(String cricketDataset) {
		TreeMap<String, MatchScore> matchScoreMap = new TreeMap<>();
		if (cricketDataset.contains("\n")) {
			cricketDataset = cricketDataset.replace("\n", "#");
		}

		String[] matches = cricketDataset.split("#");
		for (int i = 0; i < matches.length; i++) {
			if (matches[i].contains("|")) {
				matches[i] = matches[i].replace("|", "#");
			}
			String[] match = matches[i].split("#");
			for (int j = 0; j < match.length; j++) {
				String[] p = match[j].split(",");
				int pos=Integer.parseInt(p[0]);
				String pName = p[1];
				int pScore = Integer.parseInt(p[2]);
				if (matchScoreMap.containsKey(pName)) {
					MatchScore m = matchScoreMap.get(pName);
					int revisedCount = m.getMatchCount() + 1;
					int revisedScore = m.getScore() + pScore;
					int revisedPlayedCnt=m.getFirstPlayedCnt();
					
					if(pos==1 || pos==2)
					{
						revisedPlayedCnt=m.getFirstPlayedCnt()+1;
					}
					m.setMatchCount(revisedCount);
					m.setScore(revisedScore);
					m.setFirstPlayedCnt(revisedPlayedCnt);
					matchScoreMap.put(pName, m);
				} else {
					if(pos==1 || pos==2)
					{
						matchScoreMap.put(pName, new MatchScore(1, pScore,1));
					}
					else
					{
						matchScoreMap.put(pName, new MatchScore(1, pScore,0));
					}
					
				}
			}
		}

		return matchScoreMap;
	}

	public String getQuery(String cricketDataset, String query) {
		String output = "";
		String c = null;
		int start = 0, end = 0;
		if (query.trim().length() > 1) {
			String[] str = query.split(" ");
			if (str.length == 3) {
				c = str[0];
				start = Integer.parseInt(str[1]);
				end = Integer.parseInt(str[2]);
			} else if (str.length == 2) {
				c = str[0];
			}
		} else {
			c = query.trim();
		}
		if (c != null) {
			switch (c) {
			case "1":
				TreeMap<Integer, String> positionMap = createPlayerPositionMap(cricketDataset);
				SortedMap<Integer, String> m = positionMap.subMap(start, end + 1);
				List<Entry<Integer, String>> s = m.entrySet().stream().collect(Collectors.toList());
				Iterator<Entry<Integer, String>> h = s.iterator();
				String str = "";
				while (h.hasNext()) {
					Entry<Integer, String> e = h.next();
					str += e.getKey() + " " + e.getValue() + "\n";
				}
				output = str;
				break;
			case "2":
				TreeMap<Integer, String> positionMap1 = createPlayerPositionMap(cricketDataset);
				SortedMap<String, Integer> scoreMap = createPlayerScoreMap(cricketDataset);
				String[] rrr = query.split(" ");
				int sthreshold = Integer.parseInt(rrr[1]);
				Set<Entry<String, Integer>> ll = scoreMap.entrySet().stream().filter(t -> t.getValue() > sthreshold)
						.collect(Collectors.toSet());
				String str2 = "";
				List<String> st = ll.stream().map(t -> t.getKey()).collect(Collectors.toList());
				for (String l : st) {
					str2 += l + " ";
				}
				String pla = "";
				Iterator<Entry<Integer, String>> u = positionMap1.entrySet().iterator();
				while (u.hasNext()) {
					Entry<Integer, String> b = u.next();
					int key = b.getKey();
					String value = b.getValue();
					if (str2.trim().contains(value)) {
						pla += key + " " + value + "\n";
					}
				}
				output = pla;
				break;
			case "3":
				SortedMap<String, MatchScore> yy = createMatchesMap(cricketDataset);
				Comparator<MatchScore> comparator = (MatchScore m1, MatchScore m2) -> {
					if (m1.getMatchCount() > m2.getMatchCount() || m1.getFirstPlayedCnt() > m2.getFirstPlayedCnt()) {
						return 0;
					}
					else {
						return -1;	
					}
				};
				
				Stream<Entry<String, MatchScore>> z = yy.entrySet().stream()
						.sorted(Map.Entry.comparingByValue(comparator.reversed())).limit(3);
				Iterator<Entry<String, MatchScore>> a = z.iterator();
				SortedMap<Double, String> bestOpenerMap = new TreeMap<>();
				while (a.hasNext()) {
					Entry<String, MatchScore> f = a.next();
					String player = f.getKey();
					MatchScore w = f.getValue();
					bestOpenerMap.put((double) (w.getScore() / w.getMatchCount()), player);
				}

				Entry<Double, String> q = bestOpenerMap.entrySet().stream()
						.sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).findFirst().get();
				output="The Efficient Opener is "+q.getValue();
				break;
			}
		}
		return output;
	}

}

class MatchScore{
	private int matchCount;
	private int score;
    private int firstPlayedCnt;
	MatchScore() {

	}

	MatchScore(int matchCount, int score,int firstPlayedCnt) {
		this.matchCount = matchCount;
		this.score = score;
		this.firstPlayedCnt=firstPlayedCnt;
	}

	/**
	 * @return the matchCount
	 */
	public int getMatchCount() {
		return matchCount;
	}

	/**
	 * @param matchCount the matchCount to set
	 */
	public void setMatchCount(int matchCount) {
		this.matchCount = matchCount;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @return the firstPlayedCnt
	 */
	public int getFirstPlayedCnt() {
		return firstPlayedCnt;
	}

	/**
	 * @param firstPlayedCnt the firstPlayedCnt to set
	 */
	public void setFirstPlayedCnt(int firstPlayedCnt) {
		this.firstPlayedCnt = firstPlayedCnt;
	}


}