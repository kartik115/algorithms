package com.multithreading.kartikeya;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiCalls extends Thread{
	
	String url;
	ApiCalls(String url){
		this.url = url;
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName());
		try {
			apiRequest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void apiRequest() throws IOException {
		url = url.replaceAll(" ", "%20");
		URL endPoint = new URL(url);
		StringBuilder sb = null;
		int statusCode;
		HttpURLConnection connection;
		connection = (HttpURLConnection)endPoint.openConnection();
		connection.setRequestMethod("GET");
		connection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
		connection.connect();
		statusCode = connection.getResponseCode();
		BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));
		sb = new StringBuilder();
		String output;
		while ((output = br.readLine()) != null) {
			sb.append(output);
		}
		System.out.println(sb.toString());
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		long startTime = System.nanoTime();
		
		ApiCalls t3 = new ApiCalls("https://www.blinkhealth.com/api/medications/formulations?c_platform=web&c_app=rx&slug=promethazine");
		t3.apiRequest();
		ApiCalls t4 = new ApiCalls("https://www.blinkhealth.com/api/medications/formulations?c_platform=web&c_app=rx&slug=lipitor");
		t4.apiRequest();
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		
		System.out.println(totalTime);
		
		
		startTime = System.nanoTime();
		
		ApiCalls t1 = new ApiCalls("https://www.blinkhealth.com/api/medications/formulations?c_platform=web&c_app=rx&slug=aspir-low");
		t1.setName("first");
		t1.start();
		ApiCalls t2 = new ApiCalls("https://www.blinkhealth.com/api/medications/formulations?c_platform=web&c_app=rx&slug=digitek");
		t2.setName("second");
		t2.start();
		
		t1.join();
		t2.join();
	
		endTime   = System.nanoTime();
		totalTime = endTime - startTime;
		System.out.println(totalTime);
	}

}
