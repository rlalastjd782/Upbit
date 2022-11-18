package com.upbit.inquiry.service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.upbit.inquiry.DTO.MainDTO;
@Service
public class MainService {

	private static String naverNews = "https://search.naver.com/search.naver?where=news&query=%EC%BD%94%EC%9D%B8";
	

	public List<MainDTO> getNaverNews() throws IOException {

	Logger logger = LoggerFactory.getLogger(MainService.class);
	List<MainDTO> mainResponseList = new ArrayList<>();	
    Document doc = Jsoup.connect(naverNews).get();
    Elements contents = doc.select(".news_area");
    logger.info("뉴스주소 ==={}" , contents);
    for(Element content : contents) {
    	MainDTO mainResponse =  MainDTO.builder()
    			.newsPress(content.select(".press").text())
    			.newsTitle(content.select(".news_tit").text())
    			.newsDetail(content.select(".news_dsc").text())
    			.newsLink(content.select(".news_dsc a").attr("href"))
    			.newsinfo(content.select("span").text())
    			.build();
    			
    	mainResponseList.add(mainResponse);
    }
    System.out.println(mainResponseList);
    return mainResponseList;
	}
}
