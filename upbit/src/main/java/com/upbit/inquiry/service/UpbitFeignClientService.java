package com.upbit.inquiry.service;


import java.util.List;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.upbit.inquiry.DTO.UpBitTickerDTO;

@FeignClient(name = "UpbitFeignClient", url = "https://api.upbit.com/v1/ticker")
public interface UpbitFeignClientService {

	@RequestMapping(method = RequestMethod.GET)
	List<UpBitTickerDTO> getUpBitPriceList(@RequestParam(value="markets")String markets);
	
}
