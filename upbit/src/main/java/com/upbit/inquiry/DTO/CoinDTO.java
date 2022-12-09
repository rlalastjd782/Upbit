package com.upbit.inquiry.DTO;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CoinDTO {

	private String korean_name;
	private String candle_date_time_kst;
	private Long candle_acc_trade_price;
	private BigDecimal trade_price;
	private int ranking;
	
	
	

}
