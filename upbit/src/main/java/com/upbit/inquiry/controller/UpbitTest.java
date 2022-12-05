package com.upbit.inquiry.controller;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class UpbitTest {

	public static void main(String[] args) throws IOException, ParseException {
		// 날짜 지정 
		String date =  "2022-12-05T01:00:00Z";
		// 봉개수 지정
		String count = "12";
		// 마켓이름
		String marketName = "KRW-ETH";
		
		
	 	// 1. URL을 만들기 위한 StringBuilder.
        StringBuilder urlBuilder = new StringBuilder("https://api.upbit.com/v1/candles/minutes/240?market="+marketName+"&to="+date+"&count="+count); /*URL*/
        // 3. URL 객체 생성.
        URL url = new URL(urlBuilder.toString());
        // 4. 요청하고자 하는 URL과 통신하기 위한 Connection 객체 생성.
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        // 5. 통신을 위한 메소드 SET.
        conn.setRequestMethod("GET");
        // 6. 통신을 위한 Content-type SET. 
        conn.setRequestProperty("Content-type", "application/json");
        // 7. 통신 응답 코드 확인.
        System.out.println("Response code: " + conn.getResponseCode());
        // 8. 전달받은 데이터를 BufferedReader 객체로 저장.
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        // 9. 저장된 데이터를 라인별로 읽어 StringBuilder 객체로 저장.
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        // 10. 객체 해제. 
        rd.close();
        conn.disconnect();
        // 11. 전달받은 데이터 확인.
        System.out.println(sb.toString());
        
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(sb.toString());

        
        
    }
	
	
	
	
}
