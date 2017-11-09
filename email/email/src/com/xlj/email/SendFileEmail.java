package com.xlj.email;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendFileEmail {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//收件人电子邮箱
		String to ="2532649841@qq.com";
		//发件人电子邮箱
		String from ="xielijiang@huobi.com";
		//指定发送邮件的主机
		String host="smtp.exmail.qq.com";
		//获取系统属性
		Properties proterties=System.getProperties();
		
		//设置邮件服务器
		proterties.setProperty("mail.smtp.host", host);
		proterties.setProperty("mail.smtp.auth", "true"); 
		
		//获取默认的session对象
		//第二种设置用户名和密码的方法：
		Session session = Session.getDefaultInstance(proterties, new Authenticator(){  
            protected PasswordAuthentication getPasswordAuthentication(){  
                return new PasswordAuthentication("xielijiang@huobi.com","Asdf-12345");  
            }  
        });
		
		try {
			
			//创建默认的MimeMessage对象
			MimeMessage message=new MimeMessage(session);
			//Set From :头部头字段
			message.setFrom(new InternetAddress(from));
			//Set To :头部头字段
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			//Set Subject:头部头字段
			message.setSubject("This is the Subject Line!");

			//创建消息部分
			BodyPart messageBodyPart =new MimeBodyPart();
			//消息
			messageBodyPart.setText("This is message body");
			//创建多重消息
			Multipart multipart=new MimeMultipart();
			//设置文本消息部分
			multipart.addBodyPart(messageBodyPart);
			//附件部分
			messageBodyPart=new MimeBodyPart();
			String filename="file.txt";
			DataSource source=new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filename);
			multipart.addBodyPart(messageBodyPart);
			
			// 发送完整消息
	         message.setContent(multipart );
			
			Transport.send(message);
			System.out.println("Sent message successfully...");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
