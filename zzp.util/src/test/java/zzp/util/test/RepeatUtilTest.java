package zzp.util.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.repeat.request.RepeatUtil;
import com.repeat.request.Request;
import com.repeat.request.RequestTypeEnum;
import com.util.http.HttpRequest;

public class RepeatUtilTest {

	public static void main(String[] args) {
		SimpleDateFormat smft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		RepeatUtil repeatUtil = new RepeatUtil();
		
		String address = "广东省广州市天河区天河客运站";
		
		//请求百度API
		String baiduResult = repeatUtil.repeatRequest(new Request() {
			
			@Override
			public String requestMethod() {
				return HttpRequest.sendGet("http://api.map.baidu.com/geocoder/v2/", "address=" + address + "&output=json&ak=KaqwkA7ozlPx4KgYVXbTfbGOGUXiIp3R");
			}
			
		}, 3, RequestTypeEnum.BD.getType());
		
		System.out.println(baiduResult);
		
		//请求易流API
		String ylResult = repeatUtil.repeatRequest(new Request() {
			
			@Override
			public String requestMethod() {
				//4.2 获取车辆的最新位置信息 
				Map<String, String> params = new HashMap<String, String>();
				params.put("method", "GetVehcileInfo");
				params.put("appkey", "30914b89-262a-4832-b8b9-fe33770b4b4d");
				params.put("timestamp", smft.format(new Date()));
				params.put("format", "json");
				params.put("isoffsetlonlat", "2");
				params.put("sessionid", "");
				params.put("vehicle", "粤BZ1291");
				return HttpRequest.sendGetByMD5("http://api.e6gps.com/public/v3/Inface/Call", "69411cff-d7be-4458-952f-2fca0267b408", params);
			}
			
		}, 3, RequestTypeEnum.YL.getType());
		
		System.out.println(ylResult);
		
	}

}
