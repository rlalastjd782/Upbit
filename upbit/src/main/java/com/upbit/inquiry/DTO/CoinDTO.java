package com.upbit.inquiry.DTO;

import lombok.Data;

@Data
public class CoinDTO {

	private String korean_name;
	private String candle_date_time_kst;
	private String candle_acc_trade_price;
	private String trade_price;
	private int ranking;
}
