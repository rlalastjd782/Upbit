

package com.upbit.inquiry.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
		
		@PostMapping("/coinRate")
		public String coinRateSelect(CoinRequest coinParam) {
			CoinResponse coin = new CoinResponse();
			coin.setTrade_price(coinParam.getTrade_price());
			System.out.println(coin.toString());
			return "api/coinRate";
		}
		
		
		
		@GetMapping(value = "/coinRate")
		public String coinRatePage(String all,Model model) throws Exception{
			List<CoinResponse> coinRankingList = coinServiceImpl.coinRanking();
			model.addAttribute("model",coinRankingList);
			
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
