package com.upbit.inquiry.service.Impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.upbit.inquiry.DTO.UpBitMarketAllDTO;
import com.upbit.inquiry.DTO.UpBitTickerDTO;
import com.upbit.inquiry.service.UpbitAllService;
import com.upbit.inquiry.service.UpbitFeignClientService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpbitServiceImpl {
	
	private static final Logger log = LoggerFactory.getLogger(UpbitServiceImpl.class);

	private final UpbitFeignClientService upbitFeignClient;
	private final UpbitAllService upbitAll;

	
	public List<UpBitTickerDTO> getUpbitPrice(String markets){
		return upbitFeignClient.getUpBitPriceList(markets);
	}
	
	public List<UpBitMarketAllDTO> getUpbitMarket(String result2){
		log.info("[START] getUpbitMarket...UpbitServiceImpl");
		System.out.println(result2);
		log.info("[END] getUpbitMarket...UpbitServiceImpl");
		return upbitAll.getUpBitMarketAll(result2);
	}
	

	
}
