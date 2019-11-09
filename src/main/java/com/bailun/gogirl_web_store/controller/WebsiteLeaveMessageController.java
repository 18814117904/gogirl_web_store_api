package com.bailun.gogirl_web_store.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bailun.gogirl_web_store.bean.JsonResult;
import com.bailun.gogirl_web_store.bean.WebsiteLeaveMessage;
import com.bailun.gogirl_web_store.service.WebsiteLeaveMessageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/websiteLeaveMessage")
public class WebsiteLeaveMessageController {
	@Resource
	WebsiteLeaveMessageService websiteLeaveMessageService;
	
	@ResponseBody
	@RequestMapping("/delete")
	JsonResult deleteByPrimaryKey(Integer id){
		return new JsonResult(true,JsonResult.APP_DEFINE_SUC,websiteLeaveMessageService.deleteByPrimaryKey(id));
    }

	@ResponseBody
	@RequestMapping("/insert")
	JsonResult insertSelective(WebsiteLeaveMessage record){
		return new JsonResult(true,JsonResult.APP_DEFINE_SUC,websiteLeaveMessageService.insertSelective(record));
    }

	@ResponseBody
	@RequestMapping("/selectByPrimaryKey")
	JsonResult selectByPrimaryKey(Integer id){
		return new JsonResult(true,JsonResult.APP_DEFINE_SUC, websiteLeaveMessageService.selectByPrimaryKey(id));
    }
	@ResponseBody
	@RequestMapping("/select")
	JsonResult select(WebsiteLeaveMessage record,Integer pageNum,Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
		List<WebsiteLeaveMessage> list=websiteLeaveMessageService.select(record);
		PageInfo<WebsiteLeaveMessage> pageInfo = new PageInfo<WebsiteLeaveMessage>(list);
		return new JsonResult(true,JsonResult.APP_DEFINE_SUC,pageInfo);
    }

	@ResponseBody
	@RequestMapping("/update")
	JsonResult updateByPrimaryKeySelective(WebsiteLeaveMessage record){
		return new JsonResult(true,JsonResult.APP_DEFINE_SUC, websiteLeaveMessageService.updateByPrimaryKeySelective(record));
    }
	@ResponseBody
	@RequestMapping("/countNewMassage")
	JsonResult countNewMassage(){
		return new JsonResult(true,JsonResult.APP_DEFINE_SUC, websiteLeaveMessageService.countNewMassage());
    }
	@ResponseBody
	@RequestMapping("/setIsRead")
	JsonResult setIsRead(){
		return new JsonResult(true,JsonResult.APP_DEFINE_SUC, websiteLeaveMessageService.setIsRead());
    }
	
	
}
