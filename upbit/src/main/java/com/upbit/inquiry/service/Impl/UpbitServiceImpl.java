package com.upbit.inquiry.service.Impl;

import java.util.List;

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
	
	private final UpbitFeignClientService upbitFeignClient;
	private final UpbitAllService upbitAll;

	
	public List<UpBitTickerDTO> getUpbitPrice(String markets){
		return upbitFeignClient.getUpBitPriceList(markets);
	}
	
	public List<UpBitMarketAllDTO> getUpbitMarket(String result2){
		return upbitAll.getUpBitMarketAll(result2);
	}
	

	
}
