package com.bailun.gogirl_web_store.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
////@RequestMapping("/gogirl-store")
//@RequestMapping("/gogirl_xcx")
//public class StoreController {
//	private Logger logger = LoggerFactory.getLogger(this.getClass());
//	String appname = "";
////	String appname = "/gogirl-store";
//	@Value("${gogirl.url.picturePath}")
//	String picturePath;
//	@Resource
//	RedirectService redirectService;
//	@Resource
//	public RestTemplate restTemplate;
//	@ResponseBody
//	@RequestMapping("/classes/*")
//	public JsonResult classes(HttpServletRequest request,HttpServletResponse response) {
//		System.out.println("转发请求:"+RouteConfig.GOGIRLSTORE+appname+request.getRequestURI().substring(17));
//		return redirectService.redirect(request,null,RouteConfig.GOGIRLSTORE+appname+request.getRequestURI().substring(17));
//	}
//	@ResponseBody
//	@RequestMapping("/classestechnician/*")
//	public JsonResult classestechnician(HttpServletRequest request,HttpServletResponse response) {
//		System.out.println("转发请求:"+RouteConfig.GOGIRLSTORE+appname+request.getRequestURI().substring(17));
//		return redirectService.redirect(request,null,RouteConfig.GOGIRLSTORE+appname+request.getRequestURI().substring(17));
//	}
//	@ResponseBody
//	@RequestMapping("/classestechnician/modifyTechnicianClasses")
//	public JsonResult classestechnicianModifyTechnicianClasses(@RequestBody List<Map<String, Object>> list,HttpServletRequest request,HttpServletResponse response) {
//		System.out.println("转发请求:"+RouteConfig.GOGIRLSTORE+appname+request.getRequestURI().substring(17));
////		return redirectService.redirect(request,null,RouteConfig.GOGIRLSTORE+appname+request.getRequestURI().substring(17));
//		return restTemplate.postForObject(RouteConfig.GOGIRLSTORE+request.getRequestURI().substring(17), list, JsonResult.class);
//	}
//	@ResponseBody
//	@RequestMapping("/classestechnician/addTechnicainClasses")
//	public JsonResult classestechnicianAddTechnicainClasses(@RequestBody List<Map<String, Object>> list,HttpServletRequest request,HttpServletResponse response) {
//		System.out.println("转发请求:"+RouteConfig.GOGIRLSTORE+appname+request.getRequestURI().substring(17));
////		return redirectService.redirect(request,null,RouteConfig.GOGIRLSTORE+appname+request.getRequestURI().substring(17));
//		return restTemplate.postForObject(RouteConfig.GOGIRLSTORE+request.getRequestURI().substring(17), list, JsonResult.class);
//	}
//	@ResponseBody
//	@RequestMapping("/classestechnician/addOrUpdateTechnicainClasses")
//	public JsonResult classestechnicianAddOrUpdateTechnicainClasses(@RequestBody List<Map<String, Object>> list,HttpServletRequest request,HttpServletResponse response) {
//		System.out.println("转发请求:"+RouteConfig.GOGIRLSTORE+appname+request.getRequestURI().substring(17));
////		return redirectService.redirect(request,null,RouteConfig.GOGIRLSTORE+appname+request.getRequestURI().substring(17));
//		return restTemplate.postForObject(RouteConfig.GOGIRLSTORE+request.getRequestURI().substring(17), list, JsonResult.class);
//	}
//	@ResponseBody
//	@RequestMapping("/shop/*")
//	public JsonResult shop(HttpServletRequest request,HttpServletResponse response) {
//		System.out.println("转发请求:"+RouteConfig.GOGIRLSTORE+appname+request.getRequestURI().substring(17));
//		return redirectService.redirect(request,null,RouteConfig.GOGIRLSTORE+appname+request.getRequestURI().substring(17));
//	}
//	@ResponseBody
//	@RequestMapping("/technician/*")
//	public JsonResult technician(HttpServletRequest request,HttpServletResponse response) {
//		System.out.println("转发请求:"+RouteConfig.GOGIRLSTORE+appname+request.getRequestURI().substring(17));
//		return redirectService.redirect(request,null,RouteConfig.GOGIRLSTORE+appname+request.getRequestURI().substring(17));
//	}
//	@ResponseBody
//	@RequestMapping("/user/*")
//	public JsonResult user(HttpServletRequest request,HttpServletResponse response) {
//		System.out.println("转发请求:"+RouteConfig.GOGIRLSTORE+appname+request.getRequestURI().substring(17));
//		return redirectService.redirect(request,null,RouteConfig.GOGIRLSTORE+appname+request.getRequestURI().substring(17));
//	}
//	@ResponseBody
//	@RequestMapping("/user/addUserManage")
//	public JsonResult userAddUserManage(@RequestParam(value = "formData", required = false) MultipartFile [] formData,HttpServletRequest request) {
//		String urls = "";
//		if(formData.length>0){
//			List<ImageManage> list;
//			try {
//				list = ImageUtil.saveImage(picturePath, formData);
//			} catch (IOException e) {
//				e.printStackTrace();
//				return new JsonResult(false,e.getMessage(),null);
//			}
//			urls = ImageUtil.imageManageListToString(list);
//		}
//		Map<String, Object> map = new HashMap<>();
//		map.put("picturePath", urls);
//		System.out.println("转发请求:"+RouteConfig.GOGIRLSTORE+appname+request.getRequestURI().substring(17));
//		return redirectService.redirect(request,map,RouteConfig.GOGIRLSTORE+appname+request.getRequestURI().substring(17));
//	}
//	@ResponseBody
//	@RequestMapping("/user/modifyUserManage")
//	public JsonResult userModifyUserManage(@RequestParam(value = "formData", required = false) MultipartFile [] formData,HttpServletRequest request) {
//		String urls = "";
//		if(formData.length>0){
//			List<ImageManage> list;
//			try {
//				list = ImageUtil.saveImage(picturePath, formData);
//			} catch (IOException e) {
//				e.printStackTrace();
//				return new JsonResult(false,e.getMessage(),null);
//			}
//			urls = ImageUtil.imageManageListToString(list);
//		}
//		Map<String, Object> map = new HashMap<>();
//		map.put("picturePath", urls);
//		System.out.println("转发请求:"+RouteConfig.GOGIRLSTORE+appname+request.getRequestURI().substring(17));
//		return redirectService.redirect(request,map,RouteConfig.GOGIRLSTORE+appname+request.getRequestURI().substring(17));
//	}
//	@ResponseBody
//	@RequestMapping("/user/*/*")
//	public JsonResult user2(HttpServletRequest request,HttpServletResponse response) {
//		System.out.println("转发请求:"+RouteConfig.GOGIRLSTORE+appname+request.getRequestURI().substring(17));
//		return redirectService.redirect(request,null,RouteConfig.GOGIRLSTORE+appname+request.getRequestURI().substring(17));
//	}
////	@ResponseBody
////	@RequestMapping("/user/queryUserManageForPage")
////	public JsonResult user(HttpServletRequest request,HttpServletResponse response) {
////		System.out.println("转发请求:"+RouteConfig.GOGIRLSTORE+appname+request.getRequestURI().substring(17));
////		return redirectService.redirect(request,null,RouteConfig.GOGIRLSTORE+appname+request.getRequestURI().substring(17));
////	}
//	@ResponseBody
//	@RequestMapping("/activity/*")
//	public JsonResult activity(HttpServletRequest request,HttpServletResponse response) {
//		System.out.println("转发请求:"+RouteConfig.GOGIRLSTORE+appname+request.getRequestURI().substring(17));
//		return redirectService.redirect(request,null,RouteConfig.GOGIRLSTORE+appname+request.getRequestURI().substring(17));
//	}
//	@ResponseBody
//	@RequestMapping("/activitySummary/*")
//	public JsonResult activitySummary(HttpServletRequest request,HttpServletResponse response) {
//		System.out.println("转发请求:"+RouteConfig.GOGIRLSTORE+appname+request.getRequestURI().substring(17));
//		return redirectService.redirect(request,null,RouteConfig.GOGIRLSTORE+appname+request.getRequestURI().substring(17));
//	}
//	@ResponseBody
//	@RequestMapping("/activityCustomer/*")
//	public JsonResult activityCustomer(HttpServletRequest request,HttpServletResponse response) {
//		System.out.println("转发请求:"+RouteConfig.GOGIRLSTORE+appname+request.getRequestURI().substring(17));
//		return redirectService.redirect(request,null,RouteConfig.GOGIRLSTORE+appname+request.getRequestURI().substring(17));
//	}	
//}
