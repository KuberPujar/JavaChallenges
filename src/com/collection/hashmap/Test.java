package com.collection.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.Map.Entry;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String st = "125,C programming,Brian W. Kernighan|564,C++ programming,Bjarne Stroustrup|546,Java programming,James Gosling|897,Data Structure,Adam Drozdek|785,System Programming,Johnson M|265,Data Structure,Adam Drozdek|469,Data Structure,Adam Drozdek|968,Advanced Java,James Gosling";
		if (st.contains("|")) {
			st = st.replace("|", "#");
		}

		String[] r = st.split("#");
		for (String s : r) {
			System.out.println(s);
		}
	}

	String bookName;
	String author;

	Test() {
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 83 * hash + Objects.hashCode(this.bookName);
		hash = 83 * hash + Objects.hashCode(this.author);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Library other = (Library) obj;
		if (!Objects.equals(this.bookName, other.bookName)) {
			return false;
		}
		if (!Objects.equals(this.author, other.author)) {
			return false;
		}
		return true;
	}

	Test(String bookName, String author) {
		this.bookName = bookName;
		this.author = author;
	}

	public HashMap<Integer, Library> createLibraryMap(String booksInLibrary) {
		int bookId = 0;
		String bookName = null, author = null;
		System.out.println(booksInLibrary);
		System.out.println();
		StringBuilder sb = new StringBuilder(booksInLibrary);
		System.out.println(sb.toString());
		HashMap<Integer, Library> library = new HashMap<>();
		String[] lib = sb.toString().trim().split("|");
		for (String a : lib) {
			System.out.println(a.trim());
			System.out.println();
		}
		for (int i = 0; i < lib.length; i++) {
			String[] books = lib[i].split(",");
			bookId = Integer.parseInt(books[0]);
			bookName = books[1];
			author = books[2];

			if (library.containsKey(bookId)) {
				Library s = library.get(bookId);
				library.put(bookId, s);
			} else {
				Library l = new Library(bookName, author);
				library.put(bookId, l);
			}
		}
		return library;
	}

	public HashMap<Integer, Integer> createUserMap(String borrowedUsers) {
		int bookId = 0, userId = 0;
		HashMap<Integer, Integer> borrowers = new HashMap<>();
		String us[] = borrowedUsers.split("|");
		for (int i = 0; i < us.length; i++) {
			String[] b = us[i].split(",");
			bookId = Integer.parseInt(b[0]);
			userId = Integer.parseInt(b[1]);
			if (borrowers.containsKey(bookId)) {
				int u = borrowers.get(bookId);
				borrowers.put(bookId, u);
			} else {
				borrowers.put(bookId, userId);
			}
		}

		return borrowers;
	}

	public String getQuery(String booksInLibrary, String borrowedUsers, String query) {
		String outPutStr = "";
		HashMap<Integer, Library> booksMap = createLibraryMap(booksInLibrary);
		HashMap<Integer, Integer> userMap = createUserMap(borrowedUsers);

		String[] qS = query.split(",");
		int key = Integer.parseInt(qS[0]);
		int id = Integer.parseInt(qS[1]);
		switch (key) {
		case 1: {
			if (booksMap.containsKey(id)) {
				Iterator<Entry<Integer, Library>> us = booksMap.entrySet().iterator();
				while (us.hasNext()) {
					if (id == us.next().getKey()) {
						outPutStr = "It is available\nAuthor is " + us.next().getValue().author + "\n";
					}
				}
			} else {
				if (userMap.containsKey(id)) {
					Iterator<Entry<Integer, Integer>> us = userMap.entrySet().iterator();
					while (us.hasNext()) {
						if (id == us.next().getKey()) {
							outPutStr = "No Stock\nIt is owned by " + us.next().getValue() + "\n";
						}
					}
				}
			}
		}
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;

		}
		return outPutStr;
	}
}
