package com.collections.learning.kartikeya;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
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
		System.out.println("hash map (does not mentain insertion order) : "+m1);
		Set<Integer> s = m1.keySet();
		System.out.println("keys of above hash map : " + s);
		s.remove(null);
		System.out.println("hash map after removing null: "+ m1);
		Collection<String> val = m1.values();
		System.out.println("values in hashmap : "+ val);
		val.remove("Ishan");
		System.out.println("after removing two elements : "+ m1);
		
		m2.put(2012116, "Kartikeya");
		m2.put(2012116, "Kenam" );
		//m2.put(null, "Shefali");
		m2.put(2012106, "Ishan");
		m2.put(2012115, "Kartikeya");
		m2.put(2012117, "Kartikeya");
		System.out.println("\ntree map (mentain insertion order): " + m2);
		Set<Integer> keys = m2.keySet();
		System.out.println("keys of tree map : "+keys);
		keys.remove(2012106);
		System.out.println("after removal of one key : "+ m2);
		Collection<String> values = m1.values();
		System.out.println("treemap values (gives unique values): "+values);
		
		m3.add(2012115);
		m3.addAll(keys);
		m3.add(null);
		m3.add(2012108);
		System.out.println("\nhashset does not mentain order : "+m3);
		
		m4.add("Ishan");
		m4.addAll(values);
		m4.add("Hemant");
		m4.add("Kumar");
		System.out.println("\ntree map does not mentail order :"+m4);
		
		for(Map.Entry<Integer, String> hm:m2.entrySet()) {
			System.out.println(hm.getKey() +" - "+ hm.getValue());
		}
		
		Iterator<String> it = m4.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
