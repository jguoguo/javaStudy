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
		
		//��ȡĬ�ϵ�session����
		//�ڶ��������û���������ķ�����
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

			//������Ϣ����
			BodyPart messageBodyPart =new MimeBodyPart();
			//��Ϣ
			messageBodyPart.setText("This is message body");
			//����������Ϣ
			Multipart multipart=new MimeMultipart();
			//�����ı���Ϣ����
			multipart.addBodyPart(messageBodyPart);
			//��������
			messageBodyPart=new MimeBodyPart();
			String filename="file.txt";
			DataSource source=new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filename);
			multipart.addBodyPart(messageBodyPart);
			
			// ����������Ϣ
	         message.setContent(multipart );
			
			Transport.send(message);
			System.out.println("Sent message successfully...");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
