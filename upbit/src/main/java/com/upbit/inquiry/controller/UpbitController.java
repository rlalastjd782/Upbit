

package com.upbit.inquiry.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.upbit.inquiry.DTO.MainDTO;
import com.upbit.inquiry.service.MainService;
import com.upbit.inquiry.service.Impl.UpbitServiceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UpbitController {

	
		private final UpbitServiceImpl upbitService;
		private final MainService mainService;

		@GetMapping(value = "/")
		public String mainPage(String news, Model model) throws IOException {
		  List<MainDTO> mainResponse = mainService.getNaverNews();
		  System.out.println(mainResponse);
		  model.addAttribute("news", mainResponse);
		  return "api/main";
			
		}
		
		
		@GetMapping(value = "/calendar")
		public String calendarPage(String all,Model model) {
			model.addAttribute("model",upbitService.getUpbitMarket(all));
			return "api/calendar";
			
		}
		
		
		@GetMapping(value = "/coinRate")
		public String coinRatePage(String all,Model model) throws IOException, ParseException {
			// 일자 없으면 빈값 지정 해서 사용
			
			System.out.println(upbitService.getUpbitMarket(all).get(0).getMarket());
			String date =  "2022-12-05T01:00:00Z";
			// 봉개수 지정
			String count = "2";
			// 마켓이름 <- 해당하는것은 리스트로 저장하여 for 문 돌려 리스트로 저장하기
			
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
			model.addAttribute("model",upbitService.getUpbitMarket(all));
			model.addAttribute("jsonArray", jsonArray) ;
			return "api/coinRate";
			
		}
		
		@GetMapping(value = "/whale")
		public String whalePage(String all,Model model) {
			model.addAttribute("model",upbitService.getUpbitMarket(all));
			return "api/whale";
			
		}
		
		
		@GetMapping(value = "/grayscale")
		public String grayscalePage(String all,Model model) {
			model.addAttribute("model",upbitService.getUpbitMarket(all));
			return "api/grayscale";
			
		}
		
	
		
		@GetMapping(value = "/graph")
		public String graphPage(String all,Model model) {
			model.addAttribute("model",upbitService.getUpbitMarket(all));
			return "api/graph";
			
		}
		
		@GetMapping(value = "/analysis")
		public String analysisPage(String all,Model model) {
			model.addAttribute("model",upbitService.getUpbitMarket(all));
			return "api/analysis";
			
		}
		@GetMapping(value = "/ticker")
		public String ticker(String all,Model model) {
			model.addAttribute("model",upbitService.getUpbitMarket(all));
			return "api/ticker";
			
		}

		@GetMapping(value = "/tick")
		public String tick(String all,Model model) {
			model.addAttribute("model",upbitService.getUpbitMarket(all));
			return "api/tick";
			
		}

		//���θ���Ʈ�� �������� ���� ����� ����
		@GetMapping(value = "v1/market/{all}")
		public String getUpbitMaretkAll(@PathVariable String all, Model model){
			model.addAttribute("model",upbitService.getUpbitMarket(all));
			return "api/search";
		}

		


	
	
	
}
