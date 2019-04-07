package com.bootdo.welcome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.welcome.dao.WordsDao;
import com.bootdo.welcome.domain.WordsDO;



@Service
public class WordsService {
	@Autowired
	private WordsDao wordsDao;
	
	public WordsDO get(Integer id){
		return wordsDao.get(id);
	}
	
	public List<WordsDO> list(Map<String, Object> map){
		return wordsDao.list(map);
	}
	
	public int count(Map<String, Object> map){
		return wordsDao.count(map);
	}
	
	public int save(WordsDO words){
		return wordsDao.save(words);
	}
	
	public int update(WordsDO words){
		return wordsDao.update(words);
	}
	
	public int remove(Integer id){
		return wordsDao.remove(id);
	}
	
	public int batchRemove(Integer[] ids){
		return wordsDao.batchRemove(ids);
	}
	
	public	List<WordsDO> listin(List<String> tcodes){
		return wordsDao.listin(tcodes);
	}
	
}
