package com.bailun.gogirl_web_store.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bailun.gogirl_web_store.bean.WebsiteNews;

@Mapper
public interface WebsiteNewsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WebsiteNews record);

    int insertSelective(WebsiteNews record);

    WebsiteNews selectByPrimaryKey(Integer id);
    List<WebsiteNews> select(WebsiteNews record);

    int updateByPrimaryKeySelective(WebsiteNews record);

    int updateByPrimaryKey(WebsiteNews record);
}