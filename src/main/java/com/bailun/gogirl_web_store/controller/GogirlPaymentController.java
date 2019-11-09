package com.bailun.gogirl_web_store.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bailun.gogirl_web_store.bean.Customer;
import com.bailun.gogirl_web_store.bean.JsonResult;
import com.bailun.gogirl_web_store.config.RouteConfig;
import com.bailun.gogirl_web_store.config.WxConsts.PayType;
import com.bailun.gogirl_web_store.service.RedirectService;
import com.bailun.gogirl_web_store.service.myhttp.MyHttpPost;

@Controller
@RequestMapping("/gogirl_payment")
public class GogirlPaymentController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	RedirectService redirectService;
	@Autowired
    public MyHttpPost myHttpPost;
	
	
//	@ResponseBody
//	@RequestMapping("/unifiedorderGetJsAPIConfig")
//	public JsonResult unifiedorderGetJsAPIConfig(int amount,String attach,HttpServletRequest request,HttpServletResponse response) {
//		logger.debug("调用unifiedorderGetJsAPIConfig");
//		HttpSession session = request.getSession();
//		Object o = session.getAttribute("customer");
//		
////		//测试专用
////		Customer cus = new Customer();
////		cus.setId(3);
////		cus.setOpenid("o7112vw4LDcZl_n-WKz25HWtMde8");
////		o = cus;
////		//测试专用
//		if(o!=null&&o instanceof Customer){
//			Customer customer = (Customer)o;
//			logger.info("用户："+customer);
//			if(customer.getOpenid()!=null&&!customer.getOpenid().isEmpty()){
//				Map<String, Object> map = new HashMap<>();
//				map.put("openId", customer.getOpenid());
//				if(attach!=null&&attach.equals(PayType.CHARGE)){
//					Map<String, Object> orderParam = new HashMap<>();
//					orderParam.put("orderUser", String.valueOf(customer.getId()));
//					orderParam.put("totelPrice", String.valueOf(amount*0.01));
//					orderParam.put("discountPrice", String.valueOf(amount*0.01));
//					orderParam.put("remark", "remark");
//					JsonResult jsonResult = myHttpPost.httpRequest(RouteConfig.GOGIRLORDER+"gogirl-order/ordermanage/addRechargeOrder", orderParam);
//					if(!jsonResult.getSuccess()){
//						return new JsonResult(false,JsonResult.APP_DEFINE_ADDORDER_ERR,null);
//					}
//					Object o2=jsonResult.getData();
//					if(!(o2 instanceof Map)||((Map)o2).get("orderNo")==null){
//						return new JsonResult(false,JsonResult.APP_DEFINE_ADDORDER_ERR,null); 
//					}
//					map.put("orderId", String.valueOf(((Map)o2).get("orderNo")));
//				}
//				System.out.println("转发wechat请求:"+RouteConfig.GOGIRLPAYMENT+request.getRequestURI().substring(7));
//				return redirectService.redirect(request,map,RouteConfig.GOGIRLPAYMENT+request.getRequestURI().substring(7));
//			}else if(customer.getPhone()!=null&&!customer.getPhone().isEmpty()){
//				return new JsonResult(false,JsonResult.APP_DEFINE_PHONE_PAY,null);
//			}else{
//				return new JsonResult(false,JsonResult.APP_DEFINE_CUSTOMER_INFO_ERR,null);
//			}
//		}else{
//			return new JsonResult(false,JsonResult.APP_DEFINE_LOGIN_ERR,null);
//		}
//	}
//	@ResponseBody
//	@RequestMapping("/*")
//	public JsonResult redirect1(HttpServletRequest request,HttpServletResponse response) {
//		logger.debug("调用redirect1");
//		HttpSession session = request.getSession();
//		Object o = session.getAttribute("customer");
//		if(o!=null&&o instanceof Customer){
//			Customer customer = (Customer)o;
//			logger.info("用户："+customer);
//			if(customer.getOpenid()!=null&&!customer.getOpenid().isEmpty()){
//				Map<String, Object> map = new HashMap<>();
//				map.put("openId", customer.getOpenid());
//				System.out.println("转发wechat请求:"+RouteConfig.GOGIRLPAYMENT+request.getRequestURI().substring(7));
//				return redirectService.redirect(request,map,RouteConfig.GOGIRLPAYMENT+request.getRequestURI().substring(7));
//			}else if(customer.getPhone()!=null&&!customer.getPhone().isEmpty()){
//				return new JsonResult(false,JsonResult.APP_DEFINE_PHONE_PAY,null);
//			}else{
//				return new JsonResult(false,JsonResult.APP_DEFINE_CUSTOMER_INFO_ERR,null);
//			}
//		}else{
//			return new JsonResult(false,JsonResult.APP_DEFINE_LOGIN_ERR,null);
//		}
//	}
//	@ResponseBody
//	@RequestMapping("/*/*")
//	public JsonResult redirect2(HttpServletRequest request,HttpServletResponse response) {
//		logger.debug("调用redirect2");
//		System.out.println("转发wechat请求:"+RouteConfig.GOGIRLPAYMENT+request.getRequestURI().substring(7));
//		return redirectService.redirect(request,null,RouteConfig.GOGIRLPAYMENT+request.getRequestURI().substring(7));
//	}
//	@RequestMapping("/jspay")
//	public String jspay(HttpServletRequest req) {
//		logger.info("返回支付页面");
//		return "jspay";
//	}

	
	@ResponseBody
	@RequestMapping("/*")
	public JsonResult redirect1(HttpServletRequest request,HttpServletResponse response) {
		logger.debug("调用redirect1");
		Map<String, Object> map = new HashMap<>();
		System.out.println("转发wechat请求:"+RouteConfig.GOGIRLPAYMENT+request.getRequestURI().substring(17));
		return redirectService.redirect(request,map,RouteConfig.GOGIRLPAYMENT+request.getRequestURI().substring(17));

	}

}
