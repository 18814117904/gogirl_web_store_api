package com.bailun.gogirl_web_store.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.bailun.gogirl_web_store.bean.ImageManage;
import com.bailun.gogirl_web_store.bean.JsonResult;
import com.bailun.gogirl_web_store.config.RouteConfig;
import com.bailun.gogirl_web_store.service.RedirectService;
import com.bailun.gogirl_web_store.util.ImageUtil;

//@Controller
////@RequestMapping("/gogirl-service")
//@RequestMapping("/gogirl_xcx")
//public class ServiceController {
//	private Logger logger = LoggerFactory.getLogger(this.getClass());
//	@Value("${gogirl.url.picturePath}")
//	String picturePath;
//	@Value("${gogirl.url.picturePrefix}")
//	String picturePrefix;
//
//	String appname = "";
//	@Resource
//	public RestTemplate restTemplate;
////	String appname = "/gogirl-service";
//	@Resource
//	RedirectService redirectService;
//	@ResponseBody
//	@RequestMapping("/broadcast/*")
//	public JsonResult broadcast(HttpServletRequest request,HttpServletResponse response) {
//		System.out.println("转发请求:"+RouteConfig.GOGIRLSERVICE+request.getRequestURI().substring(17));
//		return redirectService.redirect(request,null,RouteConfig.GOGIRLSERVICE+request.getRequestURI().substring(17));
//	}
//	@ResponseBody
//	@RequestMapping("/label/*")
//	public JsonResult label(HttpServletRequest request,HttpServletResponse response) {
//		System.out.println("转发请求:"+RouteConfig.GOGIRLSERVICE+request.getRequestURI().substring(17));
//		return redirectService.redirect(request,null,RouteConfig.GOGIRLSERVICE+request.getRequestURI().substring(17));
//	}
//	@ResponseBody
//	@RequestMapping("/produce/*")
//	public JsonResult produce(HttpServletRequest request,HttpServletResponse response) {
//		System.out.println("转发请求:"+RouteConfig.GOGIRLSERVICE+request.getRequestURI().substring(17));
//		return redirectService.redirect(request,null,RouteConfig.GOGIRLSERVICE+request.getRequestURI().substring(17));
//	}
//	@ResponseBody
//	@RequestMapping("/serve/*")
//	public JsonResult serve(HttpServletRequest request,HttpServletResponse response) {
//		System.out.println("转发请求:"+RouteConfig.GOGIRLSERVICE+request.getRequestURI().substring(17));
//		return redirectService.redirect(request,null,RouteConfig.GOGIRLSERVICE+request.getRequestURI().substring(17));
//	}
//	@ResponseBody
//	@RequestMapping("/type/*")
//	public JsonResult type(HttpServletRequest request,HttpServletResponse response) {
//		System.out.println("转发请求:"+RouteConfig.GOGIRLSERVICE+request.getRequestURI().substring(17));
//		return redirectService.redirect(request,null,RouteConfig.GOGIRLSERVICE+request.getRequestURI().substring(17));
//	}
//	@ResponseBody
//	@RequestMapping("/image/*")
//	public Object image(HttpServletRequest request,HttpServletResponse response) {
//		System.out.println("转发请求:"+RouteConfig.GOGIRLSERVICE+request.getRequestURI().substring(17));
//		return redirectService.redirectReturnMap(request,null,RouteConfig.GOGIRLSERVICE+request.getRequestURI().substring(17));
//	}
//	
//	@ResponseBody
//	@RequestMapping("/image/addPicture")
//	public JsonResult imageAddPicture(String typeName,
//			@RequestParam(value = "files", required = false) MultipartFile [] files,
//			HttpServletRequest request,HttpServletResponse response) {
//		List<ImageManage> list = null;
//		if(files.length>0){
//			try {
//				list = ImageUtil.saveImage(picturePath, files);
//			} catch (IOException e) {
//				e.printStackTrace();
//				return new JsonResult(false,e.getMessage(),null);
//			}
//		}
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("typeName",typeName );
//		map.put("list",list );
//		return restTemplate.postForObject(RouteConfig.GOGIRLSERVICE+request.getRequestURI().substring(17)+"?typeName="+typeName, list, JsonResult.class);
//	}
//	
//	
//	@ResponseBody
//	@RequestMapping("/ueditor/*")
//	public Object ueditor(HttpServletRequest request,HttpServletResponse response) {
//		System.out.println("转发请求:"+RouteConfig.GOGIRLSERVICE+request.getRequestURI().substring(17));
//		return redirectService.redirectReturnString(request,null,RouteConfig.GOGIRLSERVICE+request.getRequestURI().substring(17));
//	}
//	@ResponseBody
//	@RequestMapping("/ueditor/exec")
//	public Object ueditorExec(HttpServletRequest request,HttpServletResponse response) {
//		System.out.println("转发请求:"+RouteConfig.GOGIRLSERVICE+request.getRequestURI().substring(17));
//        //获取所有的消息头
//		HttpHeaders headers = new HttpHeaders();
//        Enumeration<String> headerNames2 = request.getHeaderNames();
//        while(headerNames2.hasMoreElements()){
//            String nextElement = headerNames2.nextElement();
//            headers.add(nextElement, request.getHeader(nextElement));
//        }
//        MediaType type = MediaType.parseMediaType("multipart/form-data");
//        headers.setContentType(type);
////        headers.setContentType( MediaType.parseMediaType("multipart/form-data; charset=UTF-8"));;
////        headers.setContentType(MediaType.APPLICATION_JSON);
////        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
////        headers.setContentType(MediaType.parseMediaType("application/json; charset=UTF-8"));
////        headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON_UTF8);APPLICATION_PROBLEM_JSON_UTF8_VALUE
//        
//        //获取所有的参数
//        MultiValueMap<String, Object> params= new LinkedMultiValueMap<String, Object>();
//        Enumeration<String> parameterNames2 = request.getParameterNames();
//        while(parameterNames2.hasMoreElements()){
//            String nextElement = parameterNames2.nextElement();
//            params.add(nextElement, request.getParameter(nextElement));
//        }
//        //转发请求
//        HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<MultiValueMap<String, Object>>(params, headers);
//        ResponseEntity<String> entity = restTemplate.postForEntity(RouteConfig.GOGIRLSERVICE+request.getRequestURI().substring(17), httpEntity, String.class);
//		if(entity==null){
//			return null;
//		}else
//        if(entity.getStatusCodeValue()==200){
//        	String msg = entity.getBody();
//        	logger.info("msg:"+msg);
//    		return msg;
//        }else{
//        	return null;
//        }
////		return redirectService.redirectJsonReturnString(request,null,RouteConfig.GOGIRLSERVICE+request.getRequestURI().substring(17));
//	}
//	@ResponseBody
//	@RequestMapping("/user/*")
//	public JsonResult user(HttpServletRequest request,HttpServletResponse response) {
//		System.out.println("转发请求:"+RouteConfig.GOGIRLSERVICE+request.getRequestURI().substring(17));
//		return redirectService.redirect(request,null,RouteConfig.GOGIRLSERVICE+request.getRequestURI().substring(17));
//	}
////	@ResponseBody//总后台系统不需要转发
////	@RequestMapping("/user/*")
////	public JsonResult user(HttpServletRequest request,HttpServletResponse response) {
////		System.out.println("转发请求:"+RouteConfig.GOGIRLSERVICE+request.getRequestURI().substring(17));
////		return redirectService.redirect(request,null,RouteConfig.GOGIRLSERVICE+request.getRequestURI().substring(17));
////	}
//}
