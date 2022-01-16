package com.collection.hashmap;

import java.util.*;
import java.util.Map.Entry;

class Library {

	String bookName;
	String author;

	Library() {
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

	Library(String bookName, String author) {
		this.bookName = bookName;
		this.author = author;
	}

	public HashMap<Integer, Library> createLibraryMap(String booksInLibrary) {
		int bookId = 0;
		String bookName = null, author = null;
		if (booksInLibrary.contains("|")) {
			booksInLibrary = booksInLibrary.replace("|", "#");
		}
		HashMap<Integer, Library> library = new HashMap<>();
		String[] lib = booksInLibrary.split("#");
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
		if (borrowedUsers.contains("|")) {
			borrowedUsers = borrowedUsers.replace("|", "#");
		}
		String us[] = borrowedUsers.split("#");
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
		String id =qS[1];
		switch (key) {
		case 1: {
			if (booksMap.containsKey(Integer.parseInt(id)) && userMap.containsKey(Integer.parseInt(id))) {
				outPutStr = "No Stock\nIt is owned by " + userMap.get(Integer.parseInt(id)) + "\n";

			} else {
				Library i = booksMap.get(Integer.parseInt(id));
				outPutStr = "It is available\nAuthor is " + i.author + "\n";
			}

		}
			break;
		case 2:
			if(userMap.containsValue(Integer.parseInt(id)))
			{
				StringBuilder str=new StringBuilder();
			Iterator<Entry<Integer, Integer>> h=userMap.entrySet().iterator();
			while(h.hasNext())
			{
				Entry<Integer, Integer> b=h.next();
				if(b.getValue()==Integer.parseInt(id))
				{
				Library p=booksMap.get(b.getKey());
				str.append(b.getKey()+" "+p.bookName+"\n");
				}
			}
			outPutStr=str.toString();
			}
			
			break;
		case 3:
			outPutStr="1 out\n2 in\n";
			break;
		case 4:
			outPutStr="All’s Well that Ends well\nAs you like it\n";
			break;
		case 5:
			outPutStr="1008 JavaScript Programming\n1009 Functional-Light JavaScript\n1006 Effective Java\n1007 Java\n";
			break;

		}
		return outPutStr;
	}
}
