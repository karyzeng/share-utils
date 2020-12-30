package zzp.util.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import com.http.thread.HttpRequestThread;
import com.http.thread.ImportHttpRequestThread;

public class ImportHttpRequestThreadTest {

	public static void main(String[] args) {
		int vehicleNoMax = 50;
		String vehicleNos = "粤BAD548,粤BAN575,粤BAN596,粤BAN803,粤BAP099,粤BAP161,粤BAX162,粤BAZ700,粤BAZ701,粤BB6273,粤BB6359,粤BBC747,粤BBN288,粤BBN295,粤BBN296,粤BBN305,粤BBQ421,粤BBQ540,粤BBQ649,粤BBQ689,粤BBQ705,粤BBT477,粤BBY091,粤BBY181,粤BBY262,粤BBY327,粤BBY369,粤BBY376,粤BBY378,粤BBY385,粤BBY388,粤BBY389,粤BBY395,粤BBY575,粤BBY608,粤BBY609,粤BBY611,粤BCG067,粤BCG087,粤BCG088,粤BCG091,粤BCG746,粤BDX743,粤BDZ318,粤BDZ802,粤BEA360,粤BEG142,粤BET599,粤BFH641新,粤BFP995,粤BFS372,粤BFS372北斗,粤BFS626,粤BFS668,粤BFS688,粤BFT045,粤BFW682,粤BFW683,粤BFW683北斗,粤BGD759新,粤BGE115新,粤BGG023,粤BGK915新,粤BGK977新,粤BGK999,粤BGQ083,粤BGS126,粤BGS195,粤BGT602,粤BJ5943,粤BL0769,粤BL4263,粤BL4442,粤BM1982,粤BM2180,粤BM4468,粤BM7115北斗,粤BM7222,粤BP5091,粤BP6061,粤BR0533,粤BR2865,粤BR7665,粤BS0985,粤BS6035,粤BS8435,粤BT2096,粤BT2857,粤BT2886北斗,粤BT2982,粤BT8380,粤BT8958北斗,粤BU2775,粤BU4538,粤BU9026,粤BU9056,粤BU9059,粤BU9713,粤BV0400,粤BV0401,粤BV0528,粤BV8716,粤BW1840,粤BW1901,粤BW7298,粤BZ0152,粤BZ0153,粤BZ0166,粤BZ0168,粤BZ0169,粤BZ0170,粤BZ0171,粤BZ1278,粤BZ1291,粤BZ2437,粤BZ2683,粤BZ2689";
		String[] vehicleNoArr = vehicleNos.split(",");
		List<String> vehicleNoList = new ArrayList<String>();
		StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < vehicleNoArr.length; i++) {
			sBuffer.append(vehicleNoArr[i] + ",");
			if ((i + 1) % vehicleNoMax == 0) {
				sBuffer.deleteCharAt(sBuffer.lastIndexOf(","));
				vehicleNoList.add(sBuffer.toString());
				sBuffer = new StringBuffer();
			}
		}
		if (sBuffer.length() > 0) {
			sBuffer.deleteCharAt(sBuffer.lastIndexOf(","));
			vehicleNoList.add(sBuffer.toString());
		}
		
		CountDownLatch threadSignal = new CountDownLatch(vehicleNoList.size());//初始化countDown
		SimpleDateFormat smft = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		for (int i = 0; i < vehicleNoList.size(); i++) {
			//4.2 获取车辆的最新位置信息 
			Map<String, String> params = new HashMap<String, String>();
			params.put("method", "GetVehcileInfo");
			params.put("appkey", "30914b89-262a-4832-b8b9-fe33770b4b4d");
			params.put("timestamp", smft.format(new Date()));
			params.put("format", "json");
			params.put("isoffsetlonlat", "2");
			params.put("sessionid", "");
			params.put("vehicle", vehicleNoList.get(i));
			ImportHttpRequestThread httpRequestThread = new ImportHttpRequestThread(threadSignal, "http://api.e6gps.com/public/v3/Inface/Call", "69411cff-d7be-4458-952f-2fca0267b408", params);
			Thread thread = new Thread(httpRequestThread);
			thread.start();
		}
		try {
			threadSignal.await();//等待所有子线程执行完 
			System.out.println(Thread.currentThread().getName() + "结束.");//打印结束标记 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
