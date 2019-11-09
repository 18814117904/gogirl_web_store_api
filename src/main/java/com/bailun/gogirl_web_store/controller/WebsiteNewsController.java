package com.bailun.gogirl_web_store.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bailun.gogirl_web_store.bean.ImageManage;
import com.bailun.gogirl_web_store.bean.JsonResult;
import com.bailun.gogirl_web_store.bean.WebsiteLeaveMessage;
import com.bailun.gogirl_web_store.bean.WebsiteNews;
import com.bailun.gogirl_web_store.service.WebsiteNewsService;
import com.bailun.gogirl_web_store.util.ImageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/websiteNews")
public class WebsiteNewsController {
	@Resource
	WebsiteNewsService websiteNewsService;
	@Value("${gogirl.url.picturePath}")
	String picturePath;
	@Value("${gogirl.url.webDetailPath}")
	String webDetailPath;
	
	@ResponseBody
	@RequestMapping("/delete")
	JsonResult deleteByPrimaryKey(Integer id){
    	return new JsonResult(true,JsonResult.APP_DEFINE_SUC,websiteNewsService.deleteByPrimaryKey(id));
    }

	@ResponseBody
	@RequestMapping("/insert")
	JsonResult insertSelective(WebsiteNews record,@RequestParam(value = "picData", required = false) MultipartFile [] picData){
		if(record==null){
			return new JsonResult(false,"请提交内容",null);
		}
		if(record.getTitle()==null){
			return new JsonResult(false,"标题为空",null);
		}
		if(record.getTime()==null){
			return new JsonResult(false,"时间为空",null);
		}
		String urls = "";
		List<ImageManage> list=null;
		if(picData.length>0){
			try {
				list = ImageUtil.saveImage(picturePath, picData);
			} catch (IOException e) {
				e.printStackTrace();
				return new JsonResult(false,e.getMessage(),null);
			}
			urls = ImageUtil.imageManageListToString(list);
		}
		record.setPicturePath(urls);
		int id = websiteNewsService.insertSelective(record);
		//创建静态html文件，方便百度收录
		try {
			createHtml(record,webDetailPath+id+".html");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		//添加天极收录
        //String url = "http://data.zz.baidu.com/urls?appid=1634042107222494&token=4KwVwjbFe6T9PyJq&type=realtime";//网站的服务器连接  
        
		String url = "http://data.zz.baidu.com/urls?appid=1634118417185281&token=PiVDhSy0WfhVR7m1&type=realtime";//网站的服务器连接  
        String[] param = {  
                "http://www.begogirls.com/moment/"+id+".html"//需要推送的网址  
        };  
        String json = Post(url, param);//执行推送方法  
        System.out.println("结果是"+json);  //打印推送结果  
      //添加天极收录
		return new JsonResult(true,JsonResult.APP_DEFINE_SUC,id);
    }
    public void createHtml(WebsiteNews record,String dest) throws IOException{
    	Map<Integer, String> typeMap = new HashMap<>();
    	typeMap.put(1, "活动");
    	typeMap.put(2, "资讯");
    	typeMap.put(3, "款式");
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    	StringBuffer sb = new StringBuffer("<!DOCTYPE html><html><head><meta name=\"referrer\" content=\"no-referrer\" /><meta charset=\"utf-8\"><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><title>");
		 sb.append(record.getTitle());
		 sb.append("</title><meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"><meta name=\"keyword\" content=\"");
		 sb.append(record.getTitle());
		 sb.append(",gogirl, 美甲，美睫，连锁店，美甲店加盟，美甲培训，美甲图片，艺术美甲，美甲工作室，美甲店加盟，美甲沙龙\"><meta name=\"description\" content=\"");
		 sb.append(record.getSynopsis()==null?record.getTitle():record.getSynopsis());
		 sb.append("\"></head><body><div><section class=\"column-center aside\" style=\"width: 20%\"><div class=\"logo logo-box\"><img alt=\"logo\" src=\"http://qn.begogirls.com/web/public/toplogo.png\" style=\"width: 100%;\"></div><div class=\"title\"><h2 class=\"title__item\"><a href=\"http://begogirls.com/index\">首页</a></h2><h2 class=\"title__item\"><a href=\"http://begogirls.com/brand\">品牌介绍</a></h2><h2 class=\"title__item\"><a href=\"http://begogirls.com/shop\">门店分布</a></h2><h2 class=\"title__item\"><a href=\"http://begogirls.com/moment\" class=\"act-title\">最新动态</a></h2><h2 class=\"title__item\"><a href=\"http://begogirls.com/about\">关于我们</a></h2><h2 class=\"title__item\"><a href=\"http://begogirls.com/cooperation\">合作招商</a></h2><h2 class=\"title__item\"><a href=\"http://begogirls.com/contact\" rel=\"nofollow\">联系我们</a></h2><h2 class=\"title__item\"><a href=\"http://begogirls.com/recruit\" rel=\"nofollow\">诚聘英才</a></h2></div></section><section><el-header class=\"header\" style=\"height: auto;\"><a class=\"logo\" href=\"http://begogirls.com/index\"><img alt=\"logo\" src=\"http://qn.begogirls.com/web/public/toplogo.png\"></a><button         style=\"            border: none;        background: #4d7191;                padding: .4rem 1rem;        border-radius: 4px;\"><a style=\"color: #ffF;\" href=\"http://begogirls.com/moment\">返回</a></button></el-header></section><section class=\"main\"><div class=\"details\"><div class=\"flex title\"><h2>");
		 sb.append(typeMap.get(record.getType())==null?"资讯":typeMap.get(record.getType()));
		 sb.append("</h2><h2>");
		 sb.append(record.getTitle());
		 sb.append("</h2></div><div class=\"flex desc\"><p>gogirl美甲美睫沙龙</p><p>");
		 sb.append(sdf.format(record.getTime()));
		 sb.append("</p></div><div>");
		 sb.append(record.getContent());
		 sb.append("</div></div></section></div></body></html>");
		 sb.append("<style>html,body,h1,h2,h3,h4,h5,h6,ul,li,a{padding:0;margin:0}html,body{font-size:10px;width:100%}@media(max-width:1536px){html,body{font-size:8px}}@media(max-width:1024px){html{font-size:6px}}@media(max-width:414px){html{font-size:4px}}a{text-decoration:none}.flex{display:flex}.aside{position:fixed;border-right:1px solid #d2dce5;height:100%;padding-bottom:3rem}.aside::-webkit-scrollbar{display:none}.aside .logo{margin:10%}.aside .title{border-top:1px solid #d2dce5;width:100%;display:flex;flex-direction:column;align-items:center}.title__item{margin-top:11%;font-family:'bold';font-size:2.2rem;cursor:pointer}.title__item a{color:#d1d1d1}.title__item:hover{color:#4d7191}.title__item .act-title{color:#4d7191}.main{position:absolute;right:0;width:80%}.details img {max-width: 100%;}.details{padding:10rem 15rem}.details .title{padding-bottom:2rem;border-bottom:1px solid #4a7294}.details .title h2{font-size:4rem;color:#4a7294;letter-spacing:5px}.details .title h2:nth-of-type(2){color:#4a7294;font-size:3.6rem;font-weight:500;letter-spacing:2px;padding-left:2rem}.details.desc{margin:2rem 0;font-size:1.8rem;color:#666}.details.desc p{margin-right:4rem}.details .desc p:nth-of-type(2){font-size:1.2rem;padding-left:1rem}.details .text{font-size:1.6rem;color:#888;margin:4rem 0;text-indent:3rem}.header{display:none;padding:0 1.9rem}.header .logo{width:5rem}.header .logo img{width:100%}@media(max-width:1024px){.aside{display:none}.main{width:100%}.details{padding:1rem 2rem}.header{display:flex;align-items:center;justify-content:space-between}.details .title h2:nth-of-type(2){padding-left:0}}</style>");

		//需求：将数据写入到文件中
		//创建存储数据的文件
		File file =new File(dest);
		//创建一个用于操作文件的字节输出流对象。一创建就必须明确数据存储目的地。
		//输出流目的是文件，会自动创建，如果文件存在，则覆盖。
		FileOutputStream fos=new FileOutputStream(file);
		//调用父类中的write方法
		byte[] data=sb.toString().getBytes();
		fos.write(data);
		//关闭流资源
		fos.close();
    }

	@ResponseBody
	@RequestMapping("/selectByPrimaryKey")
	JsonResult selectByPrimaryKey(Integer id){
		return new JsonResult(true,JsonResult.APP_DEFINE_SUC,websiteNewsService.selectByPrimaryKey(id));
    }
	@ResponseBody
	@RequestMapping("/select")
	JsonResult select(WebsiteNews record,Integer pageNum,Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
		List<WebsiteNews> list=websiteNewsService.select(record);
		PageInfo<WebsiteNews> pageInfo = new PageInfo<WebsiteNews>(list);
		return new JsonResult(true,JsonResult.APP_DEFINE_SUC,pageInfo);
    }

	@ResponseBody
	@RequestMapping("/update")
	JsonResult updateByPrimaryKeySelective(WebsiteNews record,@RequestParam(value = "picData", required = false) MultipartFile [] picData,String []updatePic){
		String urls = "";
		List<ImageManage> list=null;
		if(picData.length>0){
			try {
				list = ImageUtil.saveImage(picturePath, picData);
			} catch (IOException e){
				e.printStackTrace();
				return new JsonResult(false,e.getMessage(),null);
			}
			urls = ImageUtil.imageManageListToString(list);
		}else{
			urls=null;
		}
//		//多张图片时使用
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

		//创建静态html文件，方便百度收录
		try {
			createHtml(record,webDetailPath+record.getId()+".html");
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		record.setPicturePath(urls);
		return new JsonResult(true,JsonResult.APP_DEFINE_SUC,websiteNewsService.updateByPrimaryKeySelective(record));
    }

    /** 
     * 百度链接实时推送 
     * @param PostUrl 
     * @param Parameters 
     * @return 
     */  
    public static String Post(String PostUrl,String[] Parameters){  
        if(null == PostUrl || null == Parameters || Parameters.length ==0){  
            return null;  
        }  
        String result="";  
        PrintWriter out=null;  
        BufferedReader in=null;  
        try {  
            //建立URL之间的连接  
            URLConnection conn=new URL(PostUrl).openConnection();  
            //设置通用的请求属性  
            conn.setRequestProperty("Host","data.zz.baidu.com");  
            conn.setRequestProperty("User-Agent", "curl/7.12.1");  
            conn.setRequestProperty("Content-Length", "83");  
            conn.setRequestProperty("Content-Type", "text/plain");  
               
            //发送POST请求必须设置如下两行  
            conn.setDoInput(true);  
            conn.setDoOutput(true);  
               
            //获取conn对应的输出流  
            out=new PrintWriter(conn.getOutputStream());  
            //发送请求参数  
            String param = "";  
            for(String s : Parameters){  
                param += s+"\n";  
            }  
            out.print(param.trim());  
            //进行输出流的缓冲  
            out.flush();  
            //通过BufferedReader输入流来读取Url的响应  
            in=new BufferedReader(new InputStreamReader(conn.getInputStream()));  
            String line;  
            while((line=in.readLine())!= null){  
                result += line;  
            }  
               
        } catch (Exception e) {  
            System.out.println("发送post请求出现异常！"+e);  
            e.printStackTrace();  
        } finally{  
            try{  
                if(out != null){  
                    out.close();  
                }  
                if(in!= null){  
                    in.close();  
                }  
                   
            }catch(IOException ex){  
                ex.printStackTrace();  
            }  
        }  
        return result;  
    }  
  
}
