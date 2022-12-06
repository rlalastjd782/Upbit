

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
import com.upbit.inquiry.DTO.UpBitMarketAllDTO;
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
			System.out.println(upbitService.getUpbitMarket(all));
			model.addAttribute("model",upbitService.getUpbitMarket(all));
			return "api/calendar";
			
		}
		
		
		@GetMapping(value = "/coinRate")
		public String coinRatePage(String all,Model model) throws Exception{
			model.addAttribute("model",upbitService.getUpbitMarket(all));
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
