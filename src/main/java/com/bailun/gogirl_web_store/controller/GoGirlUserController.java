package com.bailun.gogirl_web_store.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.bailun.gogirl_web_store.bean.Customer;
import com.bailun.gogirl_web_store.bean.CustomerDetail;
import com.bailun.gogirl_web_store.bean.ImageManage;
import com.bailun.gogirl_web_store.bean.JsonResult;
import com.bailun.gogirl_web_store.config.RouteConfig;
import com.bailun.gogirl_web_store.service.RedirectService;
import com.bailun.gogirl_web_store.util.ImageUtil;

//@Controller
////@RequestMapping("/gogirl_user")
//@RequestMapping("/gogirl_xcx")
//public class GoGirlUserController {
//	private Logger logger = LoggerFactory.getLogger(this.getClass());
//	@Resource
//	RedirectService redirectService;
//	@Resource
//	public RestTemplate restTemplate;
//	@Value("${gogirl.url.picturePath}")
//	String picturePath;
////	@ResponseBody
////	@RequestMapping("/getUserInfo")
////	public JsonResult getUserInfo(HttpServletRequest request,HttpServletResponse response) {
////		logger.debug("调用getUserInfo");
////		//入参校验无
////		HttpSession session = request.getSession();
////		Object object = session.getAttribute("customer");
////		Customer customer ;
////		if(object==null){
////			return new JsonResult(false,JsonResult.APP_DEFINE_LOGIN_ERR,null);
////		}
////		customer =(Customer) object;
////		return redirectService.redirect(request,null,RouteConfig.GOGIRLUSER+"gogirl_user/getCustomerByPrimaryKey/"+customer.getId());
////	}
////	
////	@ResponseBody
////	@RequestMapping("/deleteCustomer")
////	public JsonResult deleteCustomer(HttpServletRequest request,HttpServletResponse response,@RequestParam(required=false) String id) {
////		logger.debug("调用deleteCustomer");
////		if(id==null||id.isEmpty()){
////			JsonResult result = new JsonResult(false,String.format(JsonResult.APP_DEFINE_PARAM_ERR,"id"),null);
////			return result;
////		}
////
////		JsonResult responseEntity = redirectService.redirect(request,null,RouteConfig.GOGIRLUSER+"gogirl_user/deleteCustomerByPrimaryKey/"+id);
////		System.out.println(responseEntity.toString());
////		return responseEntity;
////	}
////	
////	
//	
//	@ResponseBody
//	@RequestMapping("/insertOrUpdateCustomerDetail")
//	public JsonResult updateCustomerDetail(String age,@RequestParam(value = "formData", required = false) MultipartFile [] formData,
//			@RequestParam(value = "updatePic", required = false) String [] updatePic,HttpServletRequest request) {
////		if(formData.length == 0){
////            return new JsonResult(false,JsonResult.APP_DEFINE_NULL_FILE_ERR,null);
////        }
//		List<ImageManage> list;
//		try {
//			list = ImageUtil.saveImage(picturePath, formData);
//		} catch (IOException e) {
//			e.printStackTrace();
//			return new JsonResult(false,e.getMessage(),null);
//		}
//		String urls = ImageUtil.imageManageListToString(list);
////		record.setQuestionnaireImgUrl(urls);
//		Map<String, Object> map = new HashMap<String, Object>();
//		if(updatePic!=null){
//			for(int i = 0;i<updatePic.length;i++){
//				int index = updatePic[i].lastIndexOf("/");
//				urls+=",";
//				urls+=updatePic[i].substring(index + 1,updatePic[i].length());
//			}
//			if(urls.startsWith(",")){
//				urls = urls.substring(1);
//			}
//		}
//		map.put("questionnaireImgUrl",urls );
//		if(age!=null&&!age.trim().isEmpty()&&!age.trim().equals("null")){
//			Integer age_tem = null;
//			try {
//				age_tem = Integer.parseInt(age);
//			} catch (Exception e) {
//				return new JsonResult(false,String.format(JsonResult.APP_DEFINE_PARAM_ERR,"年龄"),null);
//			}
//			map.put("age",String.valueOf(age_tem) );
//		}else{
//			map.put("age",null );
//		}
//		return redirectService.redirect(request,map,RouteConfig.GOGIRLUSER+request.getRequestURI().substring(17));
////		return restTemplate.postForObject(RouteConfig.GOGIRLUSER+request.getRequestURI().substring(17), list, JsonResult.class);
//	}
//	@ResponseBody
//	@RequestMapping("/*")
//	public JsonResult redirect1(HttpServletRequest request,HttpServletResponse response) {
//		logger.debug("调用redirect1");
//		System.out.println("转发wechat请求:"+RouteConfig.GOGIRLUSER+request.getRequestURI().substring(17));
//		return redirectService.redirect(request,null,RouteConfig.GOGIRLUSER+request.getRequestURI().substring(17));
//	}
//	@ResponseBody
//	@RequestMapping("/*/*")
//	public JsonResult redirect2(HttpServletRequest request,HttpServletResponse response) {
//		logger.debug("调用redirect2");
//		System.out.println("转发wechat请求:"+RouteConfig.GOGIRLUSER+request.getRequestURI().substring(17));
//		return redirectService.redirect(request,null,RouteConfig.GOGIRLUSER+request.getRequestURI().substring(17));
//	}
//	
//}
