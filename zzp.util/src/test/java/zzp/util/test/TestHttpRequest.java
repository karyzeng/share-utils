package zzp.util.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.houbb.opencc4j.util.ZhConverterUtil;
import com.util.http.HttpRequest;

public class TestHttpRequest {

	public static void main(String[] args) {
		
		//百度地图地址解析接口
		String address = "廣東省廣州市天河區天河客運站";
		address = ZhConverterUtil.convertToSimple(address);
		long startTime = System.currentTimeMillis();
		String address2 = "數據腐爛數據腐爛時間浪費時間浪費記錄是否";
		for (int i = 0; i < 1; i++) {
			String tempAddress2 = ZhConverterUtil.convertToSimple(address2);
			System.out.println(tempAddress2);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("繁体转换简体的时间：" + (endTime - startTime) + "毫秒");
		System.out.println(HttpRequest.sendGet("http://api.map.baidu.com/geocoder/v2/", "address=广州&output=json&ak=KaqwkA7ozlPx4KgYVXbTfbGOGUXiIp3R"));
		
		SimpleDateFormat smft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		//测试易流接口4.15 获取当前账户下的车辆信息 
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("method", "GetVehicleNoList");
//		params.put("appkey", "30914b89-262a-4832-b8b9-fe33770b4b4d");
//		params.put("timestamp", smft.format(new Date()));
//		params.put("format", "json");
//		String result = HttpRequest.sendGet("http://api.e6gps.com/public/v3/StatisticsReport/Call", "69411cff-d7be-4458-952f-2fca0267b408", params);
//		System.out.println(result);
//		
//		JSONObject jsonObject = JSONObject.parseObject(result);
//		JSONObject resultJson = jsonObject.getJSONObject("result");
//		JSONArray datas = resultJson.getJSONArray("data");
//		if (datas != null && datas.size() > 0) {
//			StringBuffer sBuffer = new StringBuffer();
//			for (int i = 0; i < datas.size(); i++) {
//				JSONObject data = datas.getJSONObject(i);
//				String vehicleNo = data.getString("VehicleNo");
//				sBuffer.append(vehicleNo + ",");
//			}
//			sBuffer.deleteCharAt(sBuffer.lastIndexOf(","));
//			System.out.println(sBuffer.toString());
//		}
		
		
		//4.2 获取车辆的最新位置信息 
		Map<String, String> params = new HashMap<String, String>();
		params.put("method", "GetVehcileInfo");
		params.put("appkey", "959452f0-5b1d-4d21-8d4f-2ba91ad51209");
		params.put("timestamp", smft.format(new Date()));
		params.put("format", "json");
		params.put("isoffsetlonlat", "2");
		params.put("sessionid", "");
		params.put("vehicle", "-1");
		String result = HttpRequest.sendGetByMD5("http://api.e6gps.com/public/v3/Inface/Call", "62e62cc3-3778-4a37-a619-218153945568", params);
		System.out.println(result);
		
		JSONObject jsonObject = JSONObject.parseObject(result);
		JSONObject resultJson = jsonObject.getJSONObject("result");
		JSONArray datas = resultJson.getJSONArray("data");
		if (datas != null && datas.size() > 0) {
			for (int i = 0; i < datas.size(); i++) {
				JSONObject data = datas.getJSONObject(i);
				String vehicle = data.getString("Vehicle");
				String gpsTime = data.getString("GPSTime");
				String placeName = data.getString("PlaceName");
				String roadName = data.getString("RoadName");
				double lon = Double.parseDouble(data.getString("Lon02"));
				double lat = Double.parseDouble(data.getString("Lat02"));
				System.out.println("车辆" + (i + 1) + "：车牌号：" + vehicle + "，gpsTime：" + gpsTime + "，区域：" + placeName + "，道路：" + roadName + "，经度：" + lat + "，纬度：" + lon);
			}
		}

		
//		//4.14查询两个地点间的预计时间和里程
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("method", "GetDriveInfoByPlaceName");
//		params.put("appkey", "30914b89-262a-4832-b8b9-fe33770b4b4d");
//		params.put("timestamp", smft.format(new Date()));
//		params.put("format", "json");
//		params.put("startplacename", "广东省广州市天河区天河客运站");
//		params.put("endplacename", "广东省广州市天河区华景新城东区华景二期粤生街98号405");
//		String result = HttpRequest.sendGet("http://api.e6gps.com/public/v3/StatisticsReport/Call", "69411cff-d7be-4458-952f-2fca0267b408", params);
//		System.out.println(result);
		
	}

}
