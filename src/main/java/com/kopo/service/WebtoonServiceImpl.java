package com.kopo.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kopo.domain.Webtoon;
import com.kopo.repository.WebtoonRepository;


//interface로부터 상속받은 구현체
//service 의 역할 == getter setter의 역할과 같다

@Service
public class WebtoonServiceImpl implements WebtoonService {

	@Autowired //==getter,setter
	private WebtoonRepository webtoonRepository;

	@Override
	public List<Webtoon> getAllWebtoonList() {

		return webtoonRepository.getAllWebtoonList();
	}

	@Override
	public List<Webtoon> getWebtoonListByGenre(String genre) {

		List<Webtoon> webtoonByGenre =  webtoonRepository.getWebtoonListByGenre(genre);

		return webtoonByGenre;
	}

	@Override
	public Set<Webtoon> getWebtoonListByFilter(Map<String, List<String>> filter) {
		
		Set<Webtoon> webtoonByFilter =webtoonRepository.getWebtoonListByFilter(filter);
		
		return webtoonByFilter;
	}

	@Override
	public Webtoon getWebtoonByName(String name) {
	
		Webtoon webtoonByName =webtoonRepository.getWebtoonByName(name);
		return webtoonByName;
	}

	@Override
	public void setNewWebtoon(Webtoon webtoon) {
		
		//webtoonRepository.setNewWebtoon(webtoon,filename);
		
		webtoonRepository.setNewWebtoon(webtoon);
		
	}

}
