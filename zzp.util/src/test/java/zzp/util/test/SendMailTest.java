package zzp.util.test;

import com.mail.util.MailSenderInfo;
import com.mail.util.SimpleMailSender;

public class SendMailTest {

	public static void main(String[] args) {
		MailSenderInfo mailInfo = new MailSenderInfo();   
	      mailInfo.setMailServerHost("mail.ttni.com.cn");   
	      mailInfo.setMailServerPort("587");   
	      mailInfo.setValidate(true);   
	      mailInfo.setUserName("ttgclogistics_service@gzcn.toyotsu.net");   
	      mailInfo.setPassword("0110@CQY8#");//您的邮箱密码   
	      mailInfo.setFromAddress("ttgclogistics_service@gzcn.toyotsu.net");   
	      mailInfo.setToAddress("354697171@qq.com");   
	      mailInfo.setSubject("你好");   
	      mailInfo.setContent("大海0044");   
	        //这个类主要来发送邮件  
	      SimpleMailSender sms = new SimpleMailSender();  
	      boolean textMail = sms.sendTextMail(mailInfo);//发送文体格式   
	      if (textMail) {
	    	  System.out.println("发送结果：" + textMail);
	      }
//	         sms.sendHtmlMail(mailInfo);//发送html格式
	}

}
