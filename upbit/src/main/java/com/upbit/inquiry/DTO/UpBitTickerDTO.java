package com.upbit.inquiry.DTO;

import lombok.Data;

@Data
public class UpBitTickerDTO {

	private String market; // 종목구분코드
	private String trade_date; // 최근거래일자
	private String trade_time; //최근거래시각
	private String trade_date_kst; //최근거래일자
	private String trade_time_kst; // 최근거래시각
	private String trade_timestamp; //최근거래일시
	private String opening_price; //시가
	private String high_price; //고가
	private String low_price; //저가
	private String trade_price; //종가
	private String prev_closing_price; //전일종가
	private String change;
	private String change_price;
	private String change_rate;
	private String signed_change_price;
	private String signed_change_rate;
	private String trade_volume;
	private String acc_trade_price;
	private String acc_trade_price_24h;
	private String acc_trade_volume; 
	private String acc_trade_volume_24h;
	private String highest_52_week_price;
	private String highest_52_week_date;
	private String lowest_52_week_price;
	private String lowest_52_week_date;
	private String timestamp;

	
	
	
}
