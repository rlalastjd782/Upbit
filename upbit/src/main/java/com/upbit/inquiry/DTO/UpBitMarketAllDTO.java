package com.upbit.inquiry.DTO;

import lombok.Data;

@Data
public class UpBitMarketAllDTO {

	private String market; // 업비트에서 제공중인 시장 정보
	private String korean_name; // 거래 대상 암호화폐 한글명
	private String english_name; // 거래 대상 암호화폐 영문명
	private String market_warning; // 유의 종목 여부 NONE (해당 사항 없음), CAUTION(투자유의)
	
}
