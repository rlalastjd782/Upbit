package com.upbit.inquiry.DTO;

import java.math.BigDecimal;

import lombok.Setter;
import lombok.ToString;



@Setter
@ToString
public class CoinRequest {
	private BigDecimal trade_price;
}
