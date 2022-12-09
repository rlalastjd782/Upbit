package com.upbit.inquiry.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upbit.inquiry.DTO.CoinResponse;
import com.upbit.inquiry.mapper.CoinMapper;
import com.upbit.inquiry.service.CoinService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CoinServiceImpl implements CoinService {

		@Autowired
		private  CoinMapper coinMapper;
		
		@Override
		public List<CoinResponse> coinRanking() throws Exception {
			List<CoinResponse> coinDTOList = coinMapper.rankingSelect();
			return coinDTOList;
		}
	
}
