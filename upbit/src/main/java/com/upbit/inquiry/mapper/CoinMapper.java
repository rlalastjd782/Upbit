package com.upbit.inquiry.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.upbit.inquiry.DTO.CoinRequest;
import com.upbit.inquiry.DTO.CoinResponse;

@Mapper
public interface CoinMapper {

	//랭킹가져오기
	List<CoinResponse> rankingSelect() throws Exception;
	
	// 오른쪽 화면
	List<CoinResponse> rankingSelect2(CoinRequest coin) throws Exception;
	// 왼쪽화면
	List<CoinResponse> rankingSelect3(CoinRequest coin) throws Exception;

	
}
