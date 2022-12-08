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
	
	
	
	public void setTrade_price(Double trade_price) {
		if(trade_price < 100) {
			trade_price = Math.round(trade_price*100)/100.0;
		}
		if(korean_name.equals("비트토렌트")){
			trade_price = Math.round(trade_price*100000)/100000.0;
		}
		System.out.println(trade_price);
		BigDecimal test1 = new BigDecimal(trade_price);
		System.out.println(test1);
		
		
		this.trade_price = test1;
	}
	
	
	
	
	
	
	
	
}
