package com.xlj.email;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�ռ��˵�������
		String to ="2532649841@qq.com";
		//�����˵�������
		String from ="xielijiang@huobi.com";
		//ָ�������ʼ�������
		String host="smtp.exmail.qq.com";
		//��ȡϵͳ����
		Properties proterties=System.getProperties();
		
		//�����ʼ�������
		proterties.setProperty("mail.smtp.host", host);
		proterties.setProperty("mail.smtp.auth", "true");  
		//proterties.setProperty("mail.debug", "true");  
		
		//��ȡĬ�ϵ�session����
		Session session = Session.getDefaultInstance(proterties, new Authenticator(){  
            protected PasswordAuthentication getPasswordAuthentication(){  
                return new PasswordAuthentication("xielijiang@huobi.com","Asdf-12345");  
            }  
        });
		
		try {
			
			//����Ĭ�ϵ�MimeMessage����
			MimeMessage message=new MimeMessage(session);
			//Set From :ͷ��ͷ�ֶ�
			message.setFrom(new InternetAddress(from));
			//Set To :ͷ��ͷ�ֶ�
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			//Set Subject:ͷ��ͷ�ֶ�
			message.setSubject("This is the Subject Line!");
			//������Ϣ��
			message.setText("This is actual message");
			
			Transport.send(message);
			System.out.println("Sent message successfully...");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
