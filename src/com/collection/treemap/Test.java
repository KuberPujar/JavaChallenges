package com.collection.treemap;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
	static TreemapHandson t = new TreemapHandson();

	public static void main(String[] args) {
		// "1 4 6";
		TreeMap<Integer, String> map = t
				.createPlayerPositionMap("3,Dhoni,120|1,Virat,103|5,Jadeja,90|2,Rohit,70|4,Pandya,30|6,Rahul,150");
		SortedMap<Integer, String> m = map.subMap(4, 7);
		List<Entry<Integer, String>> s = m.entrySet().stream().collect(Collectors.toList());
		Iterator<Entry<Integer, String>> h = s.iterator();
		StringBuilder bf = new StringBuilder();
		String str = "";
		while (h.hasNext()) {
			Entry<Integer, String> e = h.next();
			str += e.getKey() + " " + e.getValue() + "\n";
		}
		System.out.println(str);
		System.out.println("*****************************");
		SortedMap<String, Integer> map1 = t
				.createPlayerScoreMap("3,Dhoni,120|1,Virat,103|5,Jadeja,90|2,Rohit,70|4,Pandya,30|6,Rahul,150");
		Set<Entry<String, Integer>> ll = map1.entrySet().stream().filter(t -> t.getValue() > 50)
				.collect(Collectors.toSet());
		String str2 = "";
		List<String> st = ll.stream().map(t -> t.getKey()).collect(Collectors.toList());
		for (String l : st) {
			str2 += l + " ";
		}
		System.out.println(str2);
		String pla = "";
		Iterator<Entry<Integer, String>> u = map.entrySet().iterator();
		while (u.hasNext()) {
			Entry<Integer, String> b = u.next();
			int key = b.getKey();
			String value = b.getValue();
			if (str2.trim().contains(value)) {
				pla += key + " " + value + "\n";
			}
		}
		System.out.println(pla);
		System.out.println("**************************************");
		Comparator<MatchScore> comparator = (MatchScore m1, MatchScore m2) -> {
			if (m1.getMatchCount() > m2.getMatchCount() || m1.getFirstPlayedCnt() > m2.getFirstPlayedCnt()) {
				return 0;
			}
			else {
				return -1;	
			}
		};
		
		SortedMap<String, MatchScore> yy = t.createMatchesMap(
				"3,Rohit,100|2,Virat,56|1,Dhoni,150\n3,Rahul,90|2,Virat,100|1,Rohit,99\n1,Rahul,50|2,Virat,64|3,Rohit,78\n1,Dhoni,95|2,Virat,30|3,Rohit,45\n1,Jadeja,43|2,Virat,54|3,Rohit,78|4,Dhoni,59\n1,Rahul,60|2,Virat,56|3,Rohit,69");
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
		System.out.println(q.getValue());
	}

}
