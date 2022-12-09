package com.upbit.inquiry.service;

import java.util.List;

import com.upbit.inquiry.DTO.CoinDTO;

public interface CoinService {
	
	
	List<CoinDTO> coinRanking() throws Exception;
	
}
