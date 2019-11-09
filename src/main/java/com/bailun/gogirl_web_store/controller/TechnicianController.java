package com.bailun.gogirl_web_store.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bailun.gogirl_web_store.bean.JsonResult;
import com.bailun.gogirl_web_store.config.RouteConfig;
import com.bailun.gogirl_web_store.service.RedirectService;


//@Controller
////@RequestMapping("/gogirl-technician")
//@RequestMapping("/gogirl_xcx")
//public class TechnicianController {
//	private Logger logger = LoggerFactory.getLogger(this.getClass());
//	String appname = "";
////	String appname = "/gogirl-technician";
//	@Resource
//	RedirectService redirectService;
//	@ResponseBody
//	@RequestMapping("/*/*")
//	public JsonResult ordercomment(HttpServletRequest request,HttpServletResponse response) {
//		System.out.println("转发请求:"+RouteConfig.GOGIRLORDER+appname+request.getRequestURI().substring(17));
//		return redirectService.redirect(request,null,RouteConfig.GOGIRLTECHNICIAN+appname+request.getRequestURI().substring(17));
//	}
//
//}
