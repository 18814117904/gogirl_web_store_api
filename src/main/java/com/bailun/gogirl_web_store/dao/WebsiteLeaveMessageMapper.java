package com.bailun.gogirl_web_store.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bailun.gogirl_web_store.bean.WebsiteLeaveMessage;
import com.bailun.gogirl_web_store.bean.WebsiteNews;
@Mapper
public interface WebsiteLeaveMessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WebsiteLeaveMessage record);

    int insertSelective(WebsiteLeaveMessage record);

    WebsiteLeaveMessage selectByPrimaryKey(Integer id);
    List<WebsiteLeaveMessage> select(WebsiteLeaveMessage record);

    int updateByPrimaryKeySelective(WebsiteLeaveMessage record);

    int updateByPrimaryKey(WebsiteLeaveMessage record);
    int countNewMassage();
    int setIsRead();
}