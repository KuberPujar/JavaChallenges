package com.collection;

import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

public class Hashset {
	public static String getOut(int numberOfMatches, String squads, int squad1, int squad2) {
		// write your code here
		String[] str = squads.split("#");
		Map<Integer, HashSet<String>> map = new HashMap<>();
		for (int i = 0; i < str.length; i++) {
			if (map.containsKey(i)) {
				HashSet<String> s = map.get(i);
				String[] p = str[i].split(" ");
				for (int j = 0; j < p.length; j++) {
					s.add(p[j]);
				}

			} else {
				HashSet<String> n = new HashSet<>();
				String[] p = str[i].split(" ");
				for (int j = 0; j < p.length; j++) {
					n.add(p[j]);
				}
				map.put(i, n);
			}
		}
		
		

		HashSet<String> ht = new HashSet<>();
		HashSet<String> o = new HashSet<>();
		for (int i = 0; i < map.size(); i++) {

			if (i == 0) {
				Iterator<String> h = map.get(i).iterator();
				while (h.hasNext()) {
					String[] t = h.next().split(" ");
					for (String g : t) {
						ht.add(g);
					}
				}
			} else {
				HashSet<String> p = map.get(i);
				ht.retainAll(p);
				
			}

		}
		o.addAll(ht);
		Iterator<String> yy = o.iterator();
		StringBuilder st = new StringBuilder();
		while (yy.hasNext()) {
			String d = yy.next();
			st.append(d + " ");
		}

		HashSet<String> stR = new HashSet<>();
		HashSet<String> stR1 = new HashSet<>();
		for (int i = 0; i < map.size(); i++) {
			if (i == squad1-1) {
				Iterator<String> ss = map.get(i).iterator();
				while (ss.hasNext()) {
					stR.add(ss.next());
				}
			}

			if (i == squad2-1) {
				Iterator<String> ss = map.get(i).iterator();
				while (ss.hasNext()) {
					stR1.add(ss.next());
				}
			}

		}
		
		

		stR.retainAll(stR1);
		stR1.removeAll(stR);
		stR1.removeAll(o);
		st.append(", ");
		stR1.stream().forEach(e -> st.append(e + " "));
		return st.toString();
	}

	public static void main(String[] args) throws IOException {
		int squad1 = 1, squad2 = 2;
		String squads = "Messi Saravia Tagliafico Pezzella Saravia Lamela Nehuen Gurpreet Rahul Golui Sunil Karanjit Anirudh Jeje Vishal Saravia Tagliafico Pezzella Saravia Lamela Nehuen Gurpreet Rahul Golui Sunil Karanjit Gurpreet Rahul Golui Sunil Karanjit Anirudh Jeje Vishal#Messi Jeje Sunil Karanjit Vishal Raynier Nikhil Casco Mercado Borges Amarjit Fernandes Manvir Dessai Udanta Messi Jeje Sunil Karanjit Vishal Raynier Nikhil Casco Mercado Borges Amarjit Fernandes#Sunil Karanjit Chhangte Dessai Udanta Anirudh Borges Amarjit Jeje Vishal Lamela Nehuen Marcos Leandro Celso Chhangte Dessai Udanta Anirudh Borges Amarjit Jeje Vishal Lamela Nehuen Marcos Leandro Celso";
		String[] str = squads.split("#");
		Map<Integer, HashSet<String>> map = new HashMap<>();
		for (int i = 0; i < str.length; i++) {
			if (map.containsKey(i)) {
				HashSet<String> s = map.get(i);
				String[] p = str[i].split(" ");
				for (int j = 0; j < p.length; j++) {
					s.add(p[j]);
				}

			} else {
				HashSet<String> n = new HashSet<>();
				String[] p = str[i].split(" ");
				for (int j = 0; j < p.length; j++) {
					n.add(p[j]);
				}
				map.put(i, n);
			}
		}
		
		
Set<Entry<Integer, HashSet<String>>> oo=map.entrySet();
Iterator<Entry<Integer, HashSet<String>>> bb=oo.iterator();
while(bb.hasNext())
{
	System.out.println(bb.next());
}
		HashSet<String> ht = new HashSet<>();
		HashSet<String> o = new HashSet<>();
		for (int i = 0; i < map.size(); i++) {

			if (i == 0) {
				Iterator<String> h = map.get(i).iterator();
				while (h.hasNext()) {
					String[] t = h.next().split(" ");
					for (String g : t) {
						ht.add(g);
					}
				}
			} else {
				HashSet<String> p = map.get(i);
				ht.retainAll(p);
				
			}

		}
		o.addAll(ht);
		Iterator<String> yy = o.iterator();
		StringBuilder st = new StringBuilder();
		while (yy.hasNext()) {
			String d = yy.next();
			st.append(d + " ");
		}

		HashSet<String> stR = new HashSet<>();
		HashSet<String> stR1 = new HashSet<>();
		for (int i = 0; i < map.size(); i++) {
			if (i == squad1-1) {
				Iterator<String> ss = map.get(i).iterator();
				while (ss.hasNext()) {
					stR.add(ss.next());
				}
			}

			if (i == squad2-1) {
				Iterator<String> ss = map.get(i).iterator();
				while (ss.hasNext()) {
					stR1.add(ss.next());
				}
			}

		}
		
		

		stR.retainAll(stR1);
		stR1.removeAll(stR);
		stR1.removeAll(o);
		st.delete(st.length()-1, st.length());
		st.append(", ");
		stR1.stream().forEach(e -> st.append(e + " "));
		st.delete(st.length()-1, st.length());
		System.out.println(st.toString());
		 String[] stringArray = st.toString().split(", ");
	        String actual = sortItOut(stringArray[0])+sortItOut(stringArray[1]);
	        System.out.println(actual.hashCode());
	        
	        String str1="Jeje Sunil Karanjit Vishal, Borges Dessai Nikhil Manvir Mercado Raynier Udanta Fernandes Amarjit Casco";
	        String[] stringArray1 = str1.toString().split(", ");
	        String actual1 = sortItOut(stringArray1[0])+sortItOut(stringArray1[1]);
	        System.out.println(actual1.hashCode());
	}
	
	
	
	 static  HSPresent hsp = new HSPresent();
    public static String sortItOut(String hash) throws IOException
    {
        String[] string = hash.split(" ");
        Arrays.sort(string);
        String str = "";
        for(String s : string)
        {
           str += s+" ";
        }
        if(hsp.isHSPresent())
        {
            return str;
        }
        return null;
    }
    
    
}
