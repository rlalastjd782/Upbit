package com.upbit.inquiry.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.upbit.inquiry.DTO.CoinRequest;
import com.upbit.inquiry.DTO.CoinResponse;

@Mapper
public interface CoinMapper {

	//랭킹가져오기
	List<CoinResponse> rankingSelect() throws Exception;
	
	
	void select(CoinRequest coin);
}
