package com.bailun.gogirl_web_store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bailun.gogirl_web_store.bean.WebsiteLeaveMessage;
import com.bailun.gogirl_web_store.bean.WebsiteNews;
import com.bailun.gogirl_web_store.dao.WebsiteLeaveMessageMapper;

@Service
public class WebsiteLeaveMessageService {
	@Resource
	WebsiteLeaveMessageMapper websiteLeaveMessageMapper;
	
    public int deleteByPrimaryKey(Integer id){
    	return websiteLeaveMessageMapper.deleteByPrimaryKey(id);
    }

    public int insertSelective(WebsiteLeaveMessage record){
    	return websiteLeaveMessageMapper.insertSelective(record);
    }

    public WebsiteLeaveMessage selectByPrimaryKey(Integer id){
    	return websiteLeaveMessageMapper.selectByPrimaryKey(id);
    }
    public List<WebsiteLeaveMessage> select(WebsiteLeaveMessage record){
    	return websiteLeaveMessageMapper.select(record);
    }

    public int updateByPrimaryKeySelective(WebsiteLeaveMessage record){
    	return websiteLeaveMessageMapper.updateByPrimaryKeySelective(record);
    }
    public int countNewMassage(){
    	return websiteLeaveMessageMapper.countNewMassage();
    }
    public int setIsRead(){
    	return websiteLeaveMessageMapper.setIsRead();
    }
    

}
