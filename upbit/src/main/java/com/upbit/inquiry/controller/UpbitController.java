

package com.upbit.inquiry.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.cj.xdevapi.JsonArray;
import com.upbit.inquiry.DTO.CoinRequest;
import com.upbit.inquiry.DTO.CoinResponse;
import com.upbit.inquiry.DTO.MainDTO;
import com.upbit.inquiry.service.MainService;
import com.upbit.inquiry.service.Impl.CoinServiceImpl;
import com.upbit.inquiry.service.Impl.UpbitServiceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor

public class UpbitController {

	
		private final UpbitServiceImpl upbitService;
		private final MainService mainService;
		private final CoinServiceImpl coinServiceImpl;

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
		@ResponseBody
		@PostMapping(value = "/coinRate")
		public ArrayList<JSONObject> coinRateSelect(String inputText, Model model) throws Exception {
			ArrayList<JSONObject> arrayJson = new ArrayList<JSONObject>();
			CoinRequest coinReq = new CoinRequest();
			System.out.println("난 2번이다");
			
			coinReq.setCandle_date_time_kst(inputText);
			List<CoinResponse> coinRankingList = coinServiceImpl.coinRanking2(coinReq);
			// 랭킹리스트 get 으로 빼기(for문을 이용해서 빼보기
			
			for (int i = 0; i< coinRankingList.size(); i++) {
				JSONObject jo = new JSONObject();
				String korean_name = coinRankingList.get(i).getKorean_name();
				String candle_date_time_kst = coinRankingList.get(i).getCandle_date_time_kst();
				Long candle_acc_trade_price = coinRankingList.get(i).getCandle_acc_trade_price();
				int ranking = coinRankingList.get(i).getRanking();
				BigDecimal trade_Price = coinRankingList.get(i).getTrade_price();
				jo.put("korean_name",korean_name );
				jo.put("candle_date_time_kst", candle_date_time_kst);
				jo.put("candle_acc_trade_price", candle_acc_trade_price);
				jo.put("ranking", ranking);
				jo.put("trade_Price", trade_Price);
				arrayJson.add(jo);
			}
			System.out.println(arrayJson);
			//System.out.println(coinRankingList.get(0).getKorean_name());
			
			
			return arrayJson;
		}

		
		
		
		@GetMapping(value = "/coinRate")
		public String coinRatePage(@ModelAttribute("getModel")String all,Model model) throws Exception{
			System.out.println("난1번이야");
			List<CoinResponse> coinRankingList = coinServiceImpl.coinRanking();
			System.out.println(coinRankingList);
			model.addAttribute("getModel",coinRankingList);
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

		@GetMapping(value = "v1/market/{all}")
		public String getUpbitMaretkAll(@PathVariable String all, Model model){
			model.addAttribute("model",upbitService.getUpbitMarket(all));
			return "api/search";
		}

		


	
	
	
}
