package com.upbit.inquiry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.upbit.inquiry.service.Impl.UpbitServiceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UpbitController {

	
		private final UpbitServiceImpl upbitService;
		//����������
		@GetMapping(value = "/")
		public String mainPage() {
			return "api/main";
			
		}
		//����������
		//���⿡ �������� �޾ƿü��ֳ�?
		
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

		
		
		//�ʿ����
		// Ư�� ƼĿ ��ȸ
		@GetMapping(value = "v1/upbit/{ticker}")
		public String getUpbitTickerPrice(@PathVariable String ticker, Model model){
			model.addAttribute("upbitTickerPrice",  upbitService.getUpbitPrice(ticker));
			return "api/ticker";
		}
		//���θ���Ʈ�� �������� ���� ����� ����
		@GetMapping(value = "v1/market/{all}")
		public String getUpbitMaretkAll(@PathVariable String all, Model model){
			model.addAttribute("model",upbitService.getUpbitMarket(all));
			return "api/search";
		}

		


	
	
	
}
