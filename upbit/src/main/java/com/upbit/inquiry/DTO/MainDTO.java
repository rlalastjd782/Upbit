package com.upbit.inquiry.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class MainDTO {
	private String newsPress; // 언론사
	private String newsTitle;
	private String newsDetail;
	private String newsLink;
	private String newsinfo;
}
