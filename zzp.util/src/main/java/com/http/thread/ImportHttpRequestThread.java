package com.http.thread;

import java.util.Map;
import java.util.concurrent.CountDownLatch;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.util.http.HttpRequest;


/**
 * 请求http线程
 * 
 * @author karyzeng
 * @since 2018.08.29
 *
 */
public class ImportHttpRequestThread implements Runnable{

	private CountDownLatch threadsSignal;
	
	private String url;
	
	private String appsecret;
	
	private Map<String, String> params;
	
	public ImportHttpRequestThread(CountDownLatch threadsSignal, String url, String appsecret, Map<String, String> params) {
		this.threadsSignal = threadsSignal;
		this.url = url;
		this.appsecret = appsecret;
		this.params = params;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "开始...");
		String result = HttpRequest.sendGetByMD5(url, appsecret, params);
		System.out.println(Thread.currentThread() + "：" + result);
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
				System.out.println("车牌号：" + vehicle + "，gpsTime：" + gpsTime + "，区域：" + placeName + "，道路：" + roadName + "，经度：" + lat + "，纬度：" + lon);
			}
		}
		threadsSignal.countDown();//线程结束时计数器减1
		System.out.println(Thread.currentThread().getName() + "结束. 还有" + threadsSignal.getCount() + " 个线程");
	}
	
}
