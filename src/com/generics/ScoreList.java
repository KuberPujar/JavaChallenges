package com.generics;

import java.util.ArrayList;
import java.util.Iterator;

public class ScoreList<T> extends ArrayList<Number> {

	/**
	 * 
	 */
	ArrayList<Object> arr = null;
	private static final long serialVersionUID = 1L;

	public ScoreList() {
		arr = new ArrayList<>();
	}

	public <T> void addElement(T t) {
		arr.add(t);
	}

	public <T> void removeElement(T t) {
		arr.remove(t);
	}

	public <T> Object getElement(int index) {
		return arr.get(index);
	}

	public double averageValues() {
		Iterator<Object> s = arr.stream().iterator();
		double sum = 0;
		while (s.hasNext()) {
			Number t = (Number) s.next();
			sum += t.doubleValue();
		}
		return sum / arr.size();
	}

}
