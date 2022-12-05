package com.upbit.inquiry.coindata;

import lombok.Data;

@Data
public class UpbitMinutesResponse {

	private String market ; // 마켓이름
	private String candleDateTimeUTC; // 캔들기준시각
	private String candleDateTimeKTC; // 캔들기준시각(KST)
	private String openingPrice; // 시가
	private String highPrice; // 고가
	private String lowPrice; // 저가
	private String tradePrice; // 종가
	private String timesramp; // 캔들에서 마지막틱이 저장된시각(Unix 타임스탬프)
	private String candleAccTradePrice; //누적거래금액
	private String candleAccTradeVoiume; // 누적거래량
	private String unit; //분 단위
}
