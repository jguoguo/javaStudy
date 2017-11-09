package com.http;

public class TestSendSMS {
    public static void main(String[] args) {  
        
        String uid="12345678";  
        String title="test";  
        String content="test a content";  
        String ret=sendSms(uid ,title,content);  
        System.out.println(ret);  
  
        if(ret.indexOf("失败")<0)  
        {  
            System.out.println("成功发送sms");  
        }  
        else  
        {  
            System.out.println("失败发送");  
        }  
  
    } 
    public static String sendSms(String uid,String title,String content){
    	
    	return null;
    }
}
