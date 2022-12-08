package com.upbit.inquiry.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.upbit.inquiry.DTO.CoinDTO;
import com.upbit.inquiry.mapper.CoinMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CoinServiceImpl {

		private final CoinMapper coinMapper;
		
		
		public List<CoinDTO> coinRanking() {
			return coinMapper.rankingSelect();
				
		}
	
}
