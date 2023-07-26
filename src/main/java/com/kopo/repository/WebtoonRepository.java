package com.kopo.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.kopo.controller.WebtoonController;
import com.kopo.domain.Webtoon;


public interface WebtoonRepository {


	List<Webtoon> getAllWebtoonList(); // 리스트형태로 반환하는 메서드 생성 
	
	List<Webtoon> getWebtoonListByGenre(String genre);
	
	Set<Webtoon> getWebtoonListByFilter(Map<String,List<String>>filter); // set으로 반환하는 이유 : 중복을 제거하여 저장하고 반환하기 위함  

	Webtoon getWebtoonByName(String name);
	
	void setNewWebtoon(Webtoon webtoon);
	//void setNewWebtoon(Webtoon webtoon, String filename);
}
