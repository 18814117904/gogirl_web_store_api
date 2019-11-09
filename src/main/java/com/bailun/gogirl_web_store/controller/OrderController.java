package com.bailun.gogirl_web_store.controller;

import java.io.IOException;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.bailun.gogirl_web_store.bean.ImageManage;
import com.bailun.gogirl_web_store.bean.JsonResult;
import com.bailun.gogirl_web_store.bean.OrderManage;
import com.bailun.gogirl_web_store.bean.ScheduleManage;
import com.bailun.gogirl_web_store.config.RouteConfig;
import com.bailun.gogirl_web_store.service.RedirectService;
import com.bailun.gogirl_web_store.util.ImageUtil;

//
//@Controller
////@RequestMapping("/gogirl-order")
//@RequestMapping("/gogirl_xcx")
//public class OrderController {
//	private Logger logger = LoggerFactory.getLogger(this.getClass());
//	String appname = "";
////	String appname = "/gogirl-order";
//	@Value("${gogirl.url.picturePath}")
//	String picturePath;
//	@Resource
//	RedirectService redirectService;
//	@Resource
//	public RestTemplate restTemplate;
//	@ResponseBody
//	@RequestMapping("/*/*")
//	public JsonResult all(HttpServletRequest request,HttpServletResponse response) {
//		System.out.println("转发请求:"+RouteConfig.GOGIRLORDER+appname+request.getRequestURI().substring(17));
//		return redirectService.redirect(request,null,RouteConfig.GOGIRLORDER+appname+request.getRequestURI().substring(17));
//	}
//	@ResponseBody
//	@RequestMapping("/ordercomment/*")
//	public JsonResult ordercomment(HttpServletRequest request,HttpServletResponse response) {
//		System.out.println("转发请求:"+RouteConfig.GOGIRLORDER+appname+request.getRequestURI().substring(17));
//		return redirectService.redirect(request,null,RouteConfig.GOGIRLORDER+appname+request.getRequestURI().substring(17));
//	}
//	@ResponseBody
//	@RequestMapping("/orderlabel/*")
//	public JsonResult orderlabel(HttpServletRequest request,HttpServletResponse response) {
//		System.out.println("转发请求:"+RouteConfig.GOGIRLORDER+appname+request.getRequestURI().substring(17));
//		return redirectService.redirect(request,null,RouteConfig.GOGIRLORDER+appname+request.getRequestURI().substring(17));
//	}
//	@ResponseBody
//	@RequestMapping("/ordermanage/*")
//	public JsonResult ordermanage(HttpServletRequest request,HttpServletResponse response) {
//		System.out.println("转发请求:"+RouteConfig.GOGIRLORDER+appname+request.getRequestURI().substring(17));
//		Date startTime = new Date();
//		logger.info("startTime:"+startTime.getTime());
//		JsonResult j = redirectService.redirect(request,null,RouteConfig.GOGIRLORDER+appname+request.getRequestURI().substring(17));
//		Date endTime = new Date();
//		logger.info("endTime:"+endTime.getTime());
//		logger.info("请求用了多长时间:"+(endTime.getTime()-startTime.getTime()));
//		return j;
//	}
//	@ResponseBody
//	@RequestMapping("/ordermanage/modifyOrderStatusCancel")
//	public JsonResult modifyOrderStatusCancel(HttpServletRequest request,HttpServletResponse response,Integer id,Integer status) {
//		System.out.println("转发请求:"+RouteConfig.GOGIRLORDER+appname+request.getRequestURI().substring(7));
//		if(status==1){
//			//查优惠券id
//			String orderUrl = RouteConfig.GOGIRLORDER + "gogirl-order/ordermanage/queryOrderForDetail";
//			Map<String, Object> orderMap = new HashMap<>();
//			orderMap.put("id",String.valueOf(id));
//			logger.info("查询订单:"+orderUrl);
//			JsonResult orderResult = redirectService.myHttpPost.httpRequest(orderUrl, orderMap);
//			if(orderResult==null){
//				return new JsonResult(false,"找不到订单id："+id,null);
//			}
//			logger.info(orderResult.toString());
//			Map<String, Object> map1 = (Map<String, Object>) orderResult.getData();
//			logger.info("map:"+map1);
//			Integer couponRelevanceId = 0;
//			if(map1.get("couponRelevanceId")==null){
//			}else{
//				couponRelevanceId = Integer.parseInt(map1.get("couponRelevanceId").toString());
//			}
//			//撤回收款需要改余额
//			Map<String, Object> map = new HashMap<>();
//			map.put("orderId", String.valueOf(id));
//			map.put("couponRelevanceId", String.valueOf(couponRelevanceId));
//			System.out.println("转发请求:"+RouteConfig.GOGIRLUSER+"gogirl_user/withdrawBalance");
//			redirectService.redirect(request,map,RouteConfig.GOGIRLUSER+"gogirl_user/withdrawBalance");
//		}
//		return redirectService.redirect(request,null,RouteConfig.GOGIRLORDER+appname+request.getRequestURI().substring(17));
//	}
//	@ResponseBody
//	@RequestMapping("/ordermanage/modifyOrderServe")
//	public JsonResult ordermanageModifyOrderServe(@RequestBody OrderManage orderManage ,HttpServletRequest request,HttpServletResponse response) {
//		System.out.println("转发请求:"+RouteConfig.GOGIRLORDER+appname+request.getRequestURI().substring(17));
////		return redirectService.redirect(request,null,RouteConfig.GOGIRLORDER+appname+request.getRequestURI().substring(17));
//		return restTemplate.postForObject(RouteConfig.GOGIRLORDER+request.getRequestURI().substring(17), orderManage, JsonResult.class);
//	}
//	@ResponseBody
//	@RequestMapping("/ordermanage/addOrderManageByUser")
//	public JsonResult ordermanageAddOrderManageByUser(@RequestBody OrderManage orderManage ,HttpServletRequest request,HttpServletResponse response) {
//		System.out.println("转发请求:"+RouteConfig.GOGIRLORDER+appname+request.getRequestURI().substring(17));
////		return redirectService.redirect(request,null,RouteConfig.GOGIRLORDER+appname+request.getRequestURI().substring(17));
//		return restTemplate.postForObject(RouteConfig.GOGIRLORDER+request.getRequestURI().substring(17), orderManage, JsonResult.class);
//	}
//	@ResponseBody
//	@RequestMapping("/schedule/*")
//	public JsonResult schedule(HttpServletRequest request,HttpServletResponse response) {
//		System.out.println("转发请求:"+RouteConfig.GOGIRLORDER+appname+request.getRequestURI().substring(17));
//		return redirectService.redirect(request,null,RouteConfig.GOGIRLORDER+appname+request.getRequestURI().substring(17));
//	}
//	@ResponseBody
//	@RequestMapping("schedule/addScheduleWithServeByStore")
//	public JsonResult scheduleAddScheduleWithServeByStore(@RequestBody ScheduleManage scheduleManage ,HttpServletRequest request,HttpServletResponse response) {
//		System.out.println("转发请求:"+RouteConfig.GOGIRLORDER+appname+request.getRequestURI().substring(17));
////		return redirectService.redirectJson(request,null,RouteConfig.GOGIRLORDER+appname+request.getRequestURI().substring(17));
//		return restTemplate.postForObject(RouteConfig.GOGIRLORDER+request.getRequestURI().substring(17), scheduleManage, JsonResult.class);
//	}
//	@ResponseBody
//	@RequestMapping("/scheduleserve/*")
//	public JsonResult scheduleserve(HttpServletRequest request,HttpServletResponse response) {
//		System.out.println("转发请求:"+RouteConfig.GOGIRLORDER+appname+request.getRequestURI().substring(17));
//		return redirectService.redirect(request,null,RouteConfig.GOGIRLORDER+appname+request.getRequestURI().substring(17));
//	}
//	@ResponseBody
//	@RequestMapping("/scheduleserve/modifyScheduleServe")
//	public JsonResult scheduleserveModifyScheduleServe(@RequestBody ScheduleManage scheduleManage ,HttpServletRequest request,HttpServletResponse response) {
//		System.out.println("转发请求:"+RouteConfig.GOGIRLORDER+appname+request.getRequestURI().substring(17));
////		return redirectService.redirect(request,null,RouteConfig.GOGIRLORDER+appname+request.getRequestURI().substring(17));
//		return restTemplate.postForObject(RouteConfig.GOGIRLORDER+request.getRequestURI().substring(17), scheduleManage, JsonResult.class);
//	}
//	@ResponseBody
//	@RequestMapping("/orderrecord/*")
//	public JsonResult orderrecord(HttpServletRequest request) {
//		System.out.println("转发请求:"+RouteConfig.GOGIRLORDER+appname+request.getRequestURI().substring(17));
//		return redirectService.redirect(request,null,RouteConfig.GOGIRLORDER+appname+request.getRequestURI().substring(17));
////		return restTemplate.postForObject(RouteConfig.GOGIRLORDER+request.getRequestURI().substring(17), null, JsonResult.class);
//	}
//	@ResponseBody
//	@RequestMapping("/orderExport/*")
//	public JsonResult orderExport(HttpServletRequest request) {
//		System.out.println("转发请求:"+RouteConfig.GOGIRLORDER+appname+request.getRequestURI().substring(17));
//		return redirectService.redirect(request,null,RouteConfig.GOGIRLORDER+appname+request.getRequestURI().substring(17));
////		return restTemplate.postForObject(RouteConfig.GOGIRLORDER+request.getRequestURI().substring(17), null, JsonResult.class);
//	}
//	@ResponseBody
//	@RequestMapping("/orderrecord/addOrUpdateOrderRecord")
//	public JsonResult orderrecordAddOrderRecord(@RequestParam(value = "updatePic", required = false) String [] updatePic,
//			@RequestParam(value = "orderId", required = false) Integer  orderId,
//			@RequestParam(value = "orderServeId", required = false) Integer  orderServeId,
//			@RequestParam(value = "serveType", required = false) String  serveType,
//			@RequestParam(value = "formData", required = false) MultipartFile [] formData,HttpServletRequest request,Integer pickNum) {
//		String urls = "";
//		
//		List<ImageManage> list=null;
//		if(formData.length>0){
//			try {
//				list = ImageUtil.saveImage(picturePath, formData);
//			} catch (IOException e) {
//				e.printStackTrace();
//				return new JsonResult(false,e.getMessage(),null);
//			}
//			urls = ImageUtil.imageManageListToString(list);
//		}
//		Map<String, Object> map = new HashMap<>();
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
//		int isGuestPhoto = 0;
//		if(pickNum!=null&&pickNum!=0){
//			
//			pickNum--;
//			String picturePath = null;
//			if(updatePic!=null){
//				if(updatePic.length>pickNum){
//					int index = updatePic[pickNum].lastIndexOf("/");
//					picturePath=updatePic[pickNum].substring(index + 1,updatePic[pickNum].length());
//				}else{
//					pickNum-=updatePic.length;
//				}
//			}
//			if(picturePath==null&&list!=null){
//				if(list.size()>pickNum){
//					picturePath = list.get(pickNum).getUrl();
//				}
//			}
//			if(picturePath!=null){
//				//修改url顺序
//				int indexPicture = urls.indexOf(picturePath);
//				if(indexPicture>0){
//					urls = urls.substring(indexPicture)+","+urls.substring(0,indexPicture-1);
//				}
//				
//				//提交客照
//				logger.info("增加客照orderServeId:"+orderServeId+";    picturePath:"+picturePath);
//				Map<String, Object> photoMap= new HashMap<>();
//				photoMap.put("orderId", String.valueOf(orderId));
//				photoMap.put("serviceId", String.valueOf(orderServeId));
//				photoMap.put("serveType", String.valueOf(serveType));
//				photoMap.put("picturePath", picturePath);
//				redirectService.redirect(request,photoMap,RouteConfig.GOGIRLUSER+"gogirl_user/photo/insertOrUpdateSelective");
//				isGuestPhoto=1;
//			}else{
//				Map<String, Object> photoMap= new HashMap<>();
//				photoMap.put("serviceId", String.valueOf(orderServeId));
//				redirectService.redirect(request,photoMap,RouteConfig.GOGIRLUSER+"gogirl_user/photo/delete");
//				isGuestPhoto=0;
//			}
//		}
//		map.put("picturePath", urls);
//		map.put("isGuestPhoto", String.valueOf(isGuestPhoto));
//		System.out.println("转发请求:"+RouteConfig.GOGIRLORDER+appname+request.getRequestURI().substring(17));
//		return redirectService.redirect(request,map,RouteConfig.GOGIRLORDER+appname+request.getRequestURI().substring(17));
////		return restTemplate.postForObject(RouteConfig.GOGIRLORDER+request.getRequestURI().substring(17), map, JsonResult.class);
//	}
//	@ResponseBody
//	@RequestMapping("/orderrecord/modifyOrderRecord")
//	public JsonResult orderrecordModifyOrderRecord(@RequestParam(value = "formData", required = false) MultipartFile [] formData,
//			@RequestParam(value = "updatePic", required = false) String [] updatePic,HttpServletRequest request) {
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
//		System.out.println("转发请求:"+RouteConfig.GOGIRLORDER+appname+request.getRequestURI().substring(17));
//		return redirectService.redirect(request,map,RouteConfig.GOGIRLORDER+appname+request.getRequestURI().substring(17));
////		return restTemplate.postForObject(RouteConfig.GOGIRLORDER+request.getRequestURI().substring(17), map, JsonResult.class);
//	}
//	
//}
