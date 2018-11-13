package com.collections.learning.kartikeya;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class StockPriceByTime {
	Double stockPrice;
	String timeStamp;
	
	public StockPriceByTime (Double price, String ts) {
		this.stockPrice = price;
		this.timeStamp = ts;
	}

	/**
	 * @return the stockPrice
	 */
	public Double getStockPrice() {
		return stockPrice;
	}

	/**
	 * @return the timeStamp
	 */
	public String getTimeStamp() {
		return timeStamp;
	}
	
}

class Assignment {
	
	/** 
	 * creating these two as static as I have assumed that multiple data can be put into stream
	 * static member are shared by all objects of the class 
	 */
	static HashMap<String, StockPriceByTime> hm = new HashMap<String, StockPriceByTime>();
	static List<StockPriceByTime> sortedPrices = new ArrayList<StockPriceByTime>();
	
	
	public double findStockPriceAtGivenTimeStamp(String timeStamp) {
		StockPriceByTime sp = hm.get(timeStamp);
		return (sp == null) ? -1 : sp.stockPrice;
	}
	
	public double deleteAndGetMinimumStockPriceForToday() {
		if (sortedPrices.size() == 0) {
			return -1;
		}
		StockPriceByTime sp = sortedPrices.remove(0);
		hm.remove(sp.timeStamp);
		return sp.stockPrice;
	}
	
	
	public static void main(String[] args) {
		/**
		 * Assuming input to be in following format, where `p` denotes price and `ts` denotes timestamp
		 * First line Input format (enter stream of numbers): p1 ts1, p2 ts2, p3 ts3, p4 ts4
		 * Second line Input format (timestamp to get stock value) : ts
		 * Input: 
		 * 50  2017-11-02 01:59:30.274, 30  2017-11-02 01:59:30.275, 87  2017-11-02 01:59:30.276
		 * 2017-11-02 01:59:30.275
		 */
		
		System.out.println("Enter your input String and timestamp to search value :"
							+ "{ Stock Price & timestamp are separted by space "
							+ "and multiple records are separated by comma(,) }");
		
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String ts = sc.nextLine();
		String[] input = s.split(",");
		int size = input.length;
		for (int i=0; i<size; i++) {
			input[i] = input[i].trim();
			String[] arr = input[i].split("\\s+", 2);
			Double price = Double.parseDouble(arr[0]);
			String timeStamp = arr[1];
			StockPriceByTime sp = new StockPriceByTime(price, timeStamp);
			hm.put(timeStamp, sp);
		}
		
		// sorting stock prices of entire day
		sortedPrices = new ArrayList<>(hm.values());
		Collections.sort(sortedPrices, Comparator.comparing(StockPriceByTime::getStockPrice));
		
		/*
		System.out.println("sorted map: ");
		for (StockPriceByTime sp : sortedPrices) {
		    System.out.println(sp.getStockPrice() + "\t" + sp.getTimeStamp());
		}
		*/
		
		Assignment t = new Assignment();
		System.out.print("stock price at time " + ts + " is : ");
		System.out.println(t.findStockPriceAtGivenTimeStamp(ts));
		System.out.println("get & delete minimum price for today : " + t.deleteAndGetMinimumStockPriceForToday());
		
		// verify deletion if size of new map is less than by 1
		System.out.println("\nverification through map");
		Iterator<Map.Entry<String, StockPriceByTime>> itr = hm.entrySet().iterator();
		while (itr.hasNext()) {
			Map.Entry<String, StockPriceByTime> entry = itr.next();
			System.out.println("timestamp = " + entry.getKey() + ", stock value = " + entry.getValue().stockPrice);
		}
		
	}
}
