package gogirl_web_store;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

public class Test {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//        String accessKey = "MHRIqINwea8MnhFHXhARWofsKzF6WTqPzOp92VHy";
//        String secretKey = "TjZPPnshhkysa40VOjyzdCUJBn4E-QUD0kBoEQwk";
//        String bucket = "zhishang";
//        Auth auth = Auth.create(accessKey, secretKey);
//        String upToken = auth.uploadToken(bucket);
//        System.out.println(upToken);
		
		
		Test t = new Test();
		List<String> pics = new ArrayList<>() ;
		pics.add("E://LOGO颜色-07.jpg");//LOGO颜色-07.jpg
//		pics.add("E:/grouppic/[}(X{ZBP3LSAMXTRJBZH$)U.png");
//		pics.add("E:/grouppic/009d9546-5687-4aee-8295-9a7f05b1f23e.jpg");

		for(int l = 0;l<pics.size();l++){
			t.qiniuUpload(pics.get(l));
		}
//		String tet = "E://gogirlPic/picture/grouppic/12.24LOG0-80.jpg";
//		System.out.println(tet.substring(tet.lastIndexOf("/")+1));
        
	}
	public  static String qiniuUpload(String pic) {
	      //构造一个带指定Zone对象的配置类
      Configuration cfg = new Configuration(Zone.zone2());
      //...其他参数参考类注释
      UploadManager uploadManager = new UploadManager(cfg);
      //...生成上传凭证，然后准备上传
      //公司七牛
      String accessKey = "RWQXlbVA7oe3BxnPuFtqkAJocQZkWTwrwYyldklr";
      String secretKey = "tS2gxsQO26mGoFZJI-x8WSH9X5aPgYMJcyoJdak5";
      String bucket = "begogirls";
      //个人七牛
//      String accessKey = "MHRIqINwea8MnhFHXhARWofsKzF6WTqPzOp92VHy";
//      String secretKey = "TjZPPnshhkysa40VOjyzdCUJBn4E-QUD0kBoEQwk";
//      String bucket = "zhishang";
      //如果是Windows情况下，格式是 D:\\qiniu\\test.png
//      String localFilePath = "E://test.jpg";
      //默认不指定key的情况下，以文件内容的hash值作为文件名
      String key = null;
      Auth auth = Auth.create(accessKey, secretKey);
      String upToken = auth.uploadToken(bucket);
      try {
          Response response = uploadManager.put(pic, key, upToken);
          //解析上传成功的结果
          DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
          
          System.out.println(pic.substring(pic.lastIndexOf("/")+1)+","+putRet.key);
          return putRet.key;
      } catch (QiniuException ex) {
          Response r = ex.response;
          System.err.println(r.toString());
          try {
              System.err.println(r.bodyString());
          } catch (QiniuException ex2) {
              //ignore
          }
          return null;
      }
				
	}
}
