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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bailun.gogirl_web_store.bean.ImageManage;
import com.bailun.gogirl_web_store.bean.JsonResult;
import com.bailun.gogirl_web_store.config.RouteConfig;
import com.bailun.gogirl_web_store.service.RedirectService;
import com.bailun.gogirl_web_store.util.ImageUtil;

@Controller
@RequestMapping("/gogirl_purchase")
public class GogirlPurchaseCotroller {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	RedirectService redirectService;
	@Value("${gogirl.url.picturePathPurchase}")
	String picturePathPurchase;
	@ResponseBody
	@RequestMapping("/*")
	public JsonResult redirect1(HttpServletRequest request,HttpServletResponse response) {
		logger.debug("调用redirect1");
		System.out.println("转发wechat请求:"+RouteConfig.GOGIRLPURCHASE+request.getRequestURI().substring(17));
		return redirectService.redirect(request,null,RouteConfig.GOGIRLPURCHASE+request.getRequestURI().substring(17));
	}
	@ResponseBody
	@RequestMapping("/*/*")
	public JsonResult redirect2(HttpServletRequest request,HttpServletResponse response) {
		logger.debug("调用redirect2");
		System.out.println("转发wechat请求:"+RouteConfig.GOGIRLPURCHASE+request.getRequestURI().substring(17));
		return redirectService.redirect(request,null,RouteConfig.GOGIRLPURCHASE+request.getRequestURI().substring(17));
	}
	@ResponseBody
	@RequestMapping("/sku/insert")
	public JsonResult insertSelective(HttpServletRequest request,@RequestParam(value = "picData", required = false) MultipartFile [] picData){
		String urls = "";
		List<ImageManage> list=null;
		if(picData.length>0){
			try {
				list = ImageUtil.saveImage(picturePathPurchase, picData);
			} catch (IOException e) {
				e.printStackTrace();
				return new JsonResult(false,e.getMessage(),null);
			}
			urls = ImageUtil.imageManageListToString(list);
		}
		
		Map<String, Object> map  = new HashMap<String, Object>();
		map.put("picturePath", urls);
		return redirectService.redirect(request,map,RouteConfig.GOGIRLPURCHASE+"gogirl_purchase/sku/insert");
    }
	@ResponseBody
	@RequestMapping("/sku/update")
	public JsonResult updateByPrimaryKeySelective(HttpServletRequest request,@RequestParam(value = "picData", required = false) MultipartFile [] picData,String []updatePic){
		String urls = "";
		List<ImageManage> list=null;
		if(picData.length>0){
			try {
				list = ImageUtil.saveImage(picturePathPurchase, picData);
			} catch (IOException e) {
				e.printStackTrace();
				return new JsonResult(false,e.getMessage(),null);
			}
			urls = ImageUtil.imageManageListToString(list);
		}
		if(updatePic!=null){
			for(int i = 0;i<updatePic.length;i++){
				int index = updatePic[i].lastIndexOf("/");
				urls+=",";
				urls+=updatePic[i].substring(index + 1,updatePic[i].length());
			}
			if(urls.startsWith(",")){
				urls = urls.substring(1);
			}
		}
		Map<String, Object> map  = new HashMap<String, Object>();
		map.put("picturePath", urls);
		return redirectService.redirect(request,map,RouteConfig.GOGIRLPURCHASE+"gogirl_purchase/sku/update");
    }

	

}
