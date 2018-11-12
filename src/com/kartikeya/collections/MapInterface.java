package com.kartikeya.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class MapInterface {
	public static void main(String[] args) {
		Map<Integer, String> m1 = new HashMap<Integer, String>();
		Map<Integer, String> m2 = new TreeMap<Integer, String>();
		Set<Integer> m3 = new HashSet<Integer>();
		Set<String> m4 = new TreeSet<String>();
		m1.put(2012116, "Kartikeya");
		m1.put(2012116, "Kenam" );
		m1.put(null, "Shefali");
		m1.put(2012106, "Ishan");
		m1.put(2012115, "Kartikeya");
		System.out.println(m1);
		Set<Integer> s = m1.keySet();
		System.out.println(s);
		s.remove(null);
		System.out.println(m1);
		Collection<String> val = m1.values();
		System.out.println(val);
		val.remove("Ishan");
		System.out.println(m1);
		
		m2.put(2012116, "Kartikeya");
		m2.put(2012116, "Kenam" );
		//m2.put(null, "Shefali");
		m2.put(2012106, "Ishan");
		m2.put(2012115, "Kartikeya");
		m2.put(2012117, "Kartikeya");
		System.out.println(m2);
		Set<Integer> keys = m2.keySet();
		System.out.println(keys);
		keys.remove(2012106);
		System.out.println(m2);
		Collection<String> values = m1.values();
		System.out.println(values);
		
		m3.add(2012115);
		m3.addAll(keys);
		m3.add(null);
		System.out.println(m3);
		
		m4.add("Ishan");
		m4.addAll(values);
		m4.add("Hemant");
		m4.add("Kumar");
		System.out.println(m4);
	}
}
