package com.http;

public class TestSendSMS {
    public static void main(String[] args) {  
        
        String uid="12345678";  
        String title="test";  
        String content="test a content";  
        String ret=sendSms(uid ,title,content);  
        System.out.println(ret);  
  
        if(ret.indexOf("ʧ��")<0)  
        {  
            System.out.println("�ɹ�����sms");  
        }  
        else  
        {  
            System.out.println("ʧ�ܷ���");  
        }  
  
    } 
    public static String sendSms(String uid,String title,String content){
    	
    	return null;
    }
}
