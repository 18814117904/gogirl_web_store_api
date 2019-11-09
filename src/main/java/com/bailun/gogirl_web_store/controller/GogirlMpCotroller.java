package com.bailun.gogirl_web_store.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bailun.gogirl_web_store.bean.JsonResult;
import com.bailun.gogirl_web_store.config.RouteConfig;
import com.bailun.gogirl_web_store.service.RedirectService;

@Controller
@RequestMapping("/gogirl_mp")
public class GogirlMpCotroller {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	RedirectService redirectService;
	@ResponseBody
	@RequestMapping("/*")
	public JsonResult redirect1(HttpServletRequest request,HttpServletResponse response) {
		logger.debug("调用redirect1");
		System.out.println("转发wechat请求:"+RouteConfig.GOGIRLMP+request.getRequestURI().substring(17));
		return redirectService.redirect(request,null,RouteConfig.GOGIRLMP+request.getRequestURI().substring(17));
	}
	@ResponseBody
	@RequestMapping("/*/*")
	public JsonResult redirect2(HttpServletRequest request,HttpServletResponse response) {
		logger.debug("调用redirect2");
		System.out.println("转发wechat请求:"+RouteConfig.GOGIRLMP+request.getRequestURI().substring(17));
		return redirectService.redirect(request,null,RouteConfig.GOGIRLMP+request.getRequestURI().substring(17));
	}
	@ResponseBody
	@RequestMapping("/*/*/*")
	public JsonResult redirect3(HttpServletRequest request,HttpServletResponse response) {
		logger.debug("调用redirect2");
		System.out.println("转发wechat请求:"+RouteConfig.GOGIRLMP+request.getRequestURI().substring(17));
		return redirectService.redirect(request,null,RouteConfig.GOGIRLMP+request.getRequestURI().substring(17));
	}
	

}
