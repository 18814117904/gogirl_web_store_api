package com.bailun.gogirl_web_store.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.bailun.gogirl_web_store.bean.JsonResult;
import com.bailun.gogirl_web_store.service.myhttp.MyHttpGet;
import com.bailun.gogirl_web_store.service.myhttp.MyHttpPost;


@Component
public class RedirectService {

	@Autowired
    public MyHttpGet myHttpGet;
	@Autowired
    public MyHttpPost myHttpPost;
	
	
	//转发
	public JsonResult redirect(HttpServletRequest req,Map<String, Object> map,String target_url){
		JsonResult response = null;
		if(req.getMethod()!=null&&req.getMethod().equals("GET")){//转发get请求
			response = myHttpGet.httpRequest(req, target_url,map);	
		}else if(req.getMethod()!=null&&req.getMethod().equals("POST")){//转发post请求
			response = myHttpPost.httpRequest(req, target_url,map);
		}else{
			System.out.println("不是get也不是set请求");
		}
        return response;//直接返回结果集
	}
	//转发
	public JsonResult redirectJson(HttpServletRequest req,Map<String, Object> map,String target_url){
		JsonResult response = null;
		if(req.getMethod()!=null&&req.getMethod().equals("GET")){//转发get请求
			response = myHttpGet.httpRequestJson(req, target_url,map);	
		}else if(req.getMethod()!=null&&req.getMethod().equals("POST")){//转发post请求
			response = myHttpPost.httpRequestJson(req, target_url,map);
		}else{
			System.out.println("不是get也不是set请求");
		}
        return response;//直接返回结果集
	}
	//转发
	public String redirectReturnString(HttpServletRequest req,Map<String, Object> map,String target_url){
		String response = null;
		if(req.getMethod()!=null&&req.getMethod().equals("GET")){//转发get请求
			response = myHttpGet.httpRequestString(req, target_url,map);	
		}else if(req.getMethod()!=null&&req.getMethod().equals("POST")){//转发post请求
			response = myHttpPost.httpRequestString(req, target_url,map);
		}else{
			System.out.println("不是get也不是set请求");
		}
        return response;//直接返回结果集
	}
	//转发
	public String redirectJsonReturnString(HttpServletRequest req,Map<String, Object> map,String target_url){
		String response = null;
		if(req.getMethod()!=null&&req.getMethod().equals("GET")){//转发get请求
			response = myHttpGet.httpJsonRequestString(req, target_url,map);	
		}else if(req.getMethod()!=null&&req.getMethod().equals("POST")){//转发post请求
			response = myHttpPost.httpJsonRequestString(req, target_url,map);
		}else{
			System.out.println("不是get也不是set请求");
		}
        return response;//直接返回结果集
	}
	public Object redirectReturnMap(HttpServletRequest req,Map<String, Object> map,String target_url){
		Object response = null;
		if(req.getMethod()!=null&&req.getMethod().equals("GET")){//转发get请求
			response = myHttpGet.httpRequestMap(req, target_url,map);	
		}else if(req.getMethod()!=null&&req.getMethod().equals("POST")){//转发post请求
			response = myHttpPost.httpRequestMap(req, target_url,map);
		}else{
			System.out.println("不是get也不是set请求");
		}
        return response;//直接返回结果集
	}
	public Object redirectFile(HttpServletRequest req,Map<String, Object> map,String target_url){
		Object response = null;
		if(req.getMethod()!=null&&req.getMethod().equals("GET")){//转发get请求
			response = myHttpGet.httpRequestFile(req, target_url,map);	
		}else if(req.getMethod()!=null&&req.getMethod().equals("POST")){//转发post请求
			response = myHttpPost.httpRequestFile(req, target_url,map);
		}else{
			System.out.println("不是get也不是set请求");
		}
        return response;//直接返回结果集
	}
}
