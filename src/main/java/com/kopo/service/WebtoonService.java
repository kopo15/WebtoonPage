package com.kopo.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.kopo.domain.Webtoon;

public interface WebtoonService {

	List<Webtoon>getAllWebtoonList(); //메서드를 생성하라는 인터페이스 만들기

	List<Webtoon> getWebtoonListByGenre(String genre);

	Set<Webtoon> getWebtoonListByFilter(Map<String, List<String>>filter);


	Webtoon getWebtoonByName(String name);
	
	void setNewWebtoon(Webtoon webtoon);
	//void setNewWebtoon(Webtoon webtoon,String filename);
}
