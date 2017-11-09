package com.xlj.web;

import java.io.IOException;
import java.util.Map;


import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

public class TestApi {
	public static Map getUserMap(String url) throws IOException{
		HttpClient client=new HttpClient();
		String sign="fundAccount="+"20990008"+"&password="+"123123";
		
		PostMethod postMethod = new PostMethod("http://120.55.98.209/withfundservice/webservice/"+url);
		client.executeMethod(postMethod);
		System.out.println(postMethod.getStatusLine());
		return null;
		
	}
}
