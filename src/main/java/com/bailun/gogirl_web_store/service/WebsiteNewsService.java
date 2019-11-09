package com.bailun.gogirl_web_store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bailun.gogirl_web_store.bean.WebsiteNews;
import com.bailun.gogirl_web_store.dao.WebsiteNewsMapper;

@Service
public class WebsiteNewsService {
	@Resource
	WebsiteNewsMapper websiteNewsMapper;
	
    public int deleteByPrimaryKey(Integer id){
    	return websiteNewsMapper.deleteByPrimaryKey(id);
    }

    public int insertSelective(WebsiteNews record){
    	websiteNewsMapper.insertSelective(record);
    	return record.getId();
    }

    public WebsiteNews selectByPrimaryKey(Integer id){
    	return websiteNewsMapper.selectByPrimaryKey(id);
    }
    public List<WebsiteNews> select(WebsiteNews record){
    	return websiteNewsMapper.select(record);
    }

    public int updateByPrimaryKeySelective(WebsiteNews record){
    	return websiteNewsMapper.updateByPrimaryKeySelective(record);
    }


}
