package com.bailun.gogirl_web_store.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bailun.gogirl_web_store.service.RedirectService;

@Controller
@RequestMapping("/redirect")
public class RedirectCotroller {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	RedirectService redirectService;
	
//	@ResponseBody
//	@RequestMapping("/aaa")
//	public String test1(HttpServletRequest req,@RequestParam String name,@RequestParam int id) {
//		
//		System.out.println("转发aaa请求"+req.getMethod());
//		if(name!=null){
//			System.out.println("name!=null,name:"+name+";id:"+id);
//		}
//		return "请求进来了";
//	}
//
//	@ResponseBody
//	@RequestMapping("/*")
//	public JsonResult test(HttpServletRequest req) {
//		System.out.println("转发wechat请求");
//		return redirectService.redirect(req,null,RouteConfig.GOGIRLUSER+req.getRequestURI().substring(17));
//	}
//	
	@RequestMapping("/jspay")
	public String jspay(HttpServletRequest req) {
		logger.info("返回支付页面");
		return "jspay";
	}
	@RequestMapping("/jssdkpay")
	public String jssdkpay(HttpServletRequest req) {
		logger.info("返回支付页面");
		return "jssdkpay";
	}
	@ResponseBody
	@RequestMapping("/err")
	public String error(HttpServletRequest req) {
		logger.info("返回错误页面");
		return "err";
	}
	@ResponseBody
	@RequestMapping("/suc")
	public String login_success(HttpServletRequest req) {
		logger.info("登录成功页面");
		return "suc";
	}

}
