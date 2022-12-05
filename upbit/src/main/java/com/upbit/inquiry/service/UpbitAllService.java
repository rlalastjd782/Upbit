package com.upbit.inquiry.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.upbit.inquiry.DTO.UpBitMarketAllDTO;

@FeignClient(name = "UpbitAll", url = "https://api.upbit.com/v1/market/all")
public interface UpbitAllService {
	@RequestMapping(method = RequestMethod.GET)
	List<UpBitMarketAllDTO> getUpBitMarketAll(@RequestParam(value="market")String result2);
}
