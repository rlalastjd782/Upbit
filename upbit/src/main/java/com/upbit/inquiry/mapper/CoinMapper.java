package com.upbit.inquiry.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.upbit.inquiry.DTO.CoinDTO;

@Mapper
public interface CoinMapper {

	//랭킹가져오기
	List<CoinDTO> rankingSelect();
	
	
	
}
