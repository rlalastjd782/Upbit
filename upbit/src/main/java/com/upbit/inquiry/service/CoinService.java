package com.upbit.inquiry.service;

import java.util.List;

import com.upbit.inquiry.DTO.CoinRequest;
import com.upbit.inquiry.DTO.CoinResponse;

public interface CoinService {
	List<CoinResponse> coinRanking() throws Exception;
	
	List<CoinResponse> coinRanking2(CoinRequest coin) throws Exception;


}
