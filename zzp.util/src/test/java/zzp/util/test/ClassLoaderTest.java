package zzp.util.test;

import com.excel.util.ParseXMLUtil;
import com.util.http.MD5Util;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class ClassLoaderTest {

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        System.out.println(stringBuffer.getClass().getClassLoader());

        MD5Util md5Util = new MD5Util();
        System.out.println(md5Util.getClass().getClassLoader());

        System.out.println(ParseXMLUtil.class.getClassLoader().getResource(""));

        Queue<Integer> queue = new PriorityQueue<Integer>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(3);
        System.out.println(queue);

        Lock lock = new ReentrantLock();

        String str = "Could not read JSON: Unrecognized field \"entryDclTimeStart\" (class com.hoolinks.jg.dcl.vo.InvtHeadQuery), not marked as ignorable (21 known properties: \"size\", \"descs\", \"putrecNo\", \"invtDclTimeEnd\", \"suppliersCustomsCode\", \"companyCode\", \"invtDclTimeStart\", \"supvModecd\", \"groupUid\", \"companyUid\", \"impexpPortcd\", \"dataStat\", \"masterCuscd\", \"createrName\", \"ascs\", \"bondInvtNo\", \"entBillDocNo\", \"createTime\", \"groupName\", \"updateTime\", \"current\"])";
        String tempStr = str.substring(str.indexOf("\"") + 1);
        String tempStr2 = tempStr.substring(0, tempStr.indexOf("\""));
        System.out.println(tempStr);
        System.out.println(tempStr2);


        try {
            long startTime = System.currentTimeMillis();
            Thread.sleep(5);
            long endTime = System.currentTimeMillis();
            System.out.println("时间间隔：" + (endTime - startTime) +"毫秒");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
