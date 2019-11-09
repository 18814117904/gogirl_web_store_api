package com.bailun.gogirl_web_store.config;

import java.nio.charset.StandardCharsets;

import javax.annotation.Resource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
@ConfigurationProperties(prefix = "gogirl.url")
public class RouteConfig {
	
	public static String NGINX;
	public static String GOGIRLUSER;
	public static String GOGIRLSTORE;
	public static String GOGIRLSERVICE;
	public static String GOGIRLTECHNICIAN;
	public static String GOGIRLORDER;
	public static String GOGIRLPAYMENT;
	public static String picturePath;
	public static String picturePrefix;
	public static String GOGIRLMP;
	public static String GOGIRLPURCHASE;
	//错误页面
	public static String ERROR_PAGE;

	@Bean
	public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        return restTemplate;
	}

	public static String getGOGIRLUSER() {
		return GOGIRLUSER;
	}

	public void setGOGIRLUSER(String gOGIRLUSER) {
		GOGIRLUSER = gOGIRLUSER;
	}


	public static String getGOGIRLSTORE() {
		return GOGIRLSTORE;
	}

	public void setGOGIRLSTORE(String gOGIRLSTORE) {
		GOGIRLSTORE = gOGIRLSTORE;
	}

	public static String getGOGIRLSERVICE() {
		return GOGIRLSERVICE;
	}

	public void setGOGIRLSERVICE(String gOGIRLSERVICE) {
		GOGIRLSERVICE = gOGIRLSERVICE;
	}

	public static String getGOGIRLTECHNICIAN() {
		return GOGIRLTECHNICIAN;
	}

	public void setGOGIRLTECHNICIAN(String gOGIRLTECHNICIAN) {
		GOGIRLTECHNICIAN = gOGIRLTECHNICIAN;
	}

	public static String getGOGIRLORDER() {
		return GOGIRLORDER;
	}

	public void setGOGIRLORDER(String gOGIRLORDER) {
		GOGIRLORDER = gOGIRLORDER;
	}

	public static String getERROR_PAGE() {
		return ERROR_PAGE;
	}

	public void setERROR_PAGE(String eRROR_PAGE) {
		ERROR_PAGE = eRROR_PAGE;
	}

	public static String getNGINX() {
		return NGINX;
	}

	public void setNGINX(String nGINX) {
		NGINX = nGINX;
	}

	public static String getGOGIRLPAYMENT() {
		return GOGIRLPAYMENT;
	}

	public void setGOGIRLPAYMENT(String gOGIRLPAYMENT) {
		GOGIRLPAYMENT = gOGIRLPAYMENT;
	}

	public static String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		RouteConfig.picturePath = picturePath;
	}

	public static String getPicturePrefix() {
		return picturePrefix;
	}

	public void setPicturePrefix(String picturePrefix) {
		RouteConfig.picturePrefix = picturePrefix;
	}

	public static String getGOGIRLMP() {
		return GOGIRLMP;
	}

	public void setGOGIRLMP(String gOGIRLMP) {
		GOGIRLMP = gOGIRLMP;
	}

	public static String getGOGIRLPURCHASE() {
		return GOGIRLPURCHASE;
	}

	public void setGOGIRLPURCHASE(String gOGIRLPURCHASE) {
		GOGIRLPURCHASE = gOGIRLPURCHASE;
	}
	
}
