package com.bailun.gogirl_web_store.service.myhttp;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.bailun.gogirl_web_store.bean.JsonResult;

@Component
public abstract class MyHttp {
	@Resource
	public RestTemplate restTemplate;

	/*请求转发方法*/
	public abstract JsonResult httpRequest(HttpServletRequest req,String target_url,Map<String, Object> map);
	public abstract JsonResult httpRequestJson(HttpServletRequest req,String target_url,Map<String, Object> map);
	/*请求转发方法*/
	public abstract String httpRequestString(HttpServletRequest req,String target_url,Map<String, Object> map);
	public abstract String httpJsonRequestString(HttpServletRequest req,String target_url,Map<String, Object> map);
	/*请求转发方法*/
	public abstract Map<String, Object> httpRequestMap(HttpServletRequest req,String target_url,Map<String, Object> map);
	/*请求转发方法*/
	public abstract Map<String, Object> httpRequestFile(HttpServletRequest req,String target_url,Map<String, Object> map);
	/*请求转发方法*/
	public abstract JsonResult httpRequest(String url,Map<String, Object> map);
//	/*请求转发方法*/
//	public abstract ResponseEntity<JsonResult> httpRequestEntity(String url,Map<String, Object> map);
	
	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

}
