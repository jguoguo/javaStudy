package com.http;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;

public class StaticHttpclientCall {

	public static void main(String[] args) throws HttpException, IOException{
		String soapRequestData = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
				+ "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\""
				+ " xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\""
				+ " xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">"
				+ " <soap12:Body>"
				+ " <GetAPACShippingPackage xmlns=\"http://shippingapi.ebay.cn/\">"
				+ " <GetAPACShippingPackageRequest>"
				+ " <TrackCode>123</TrackCode>"
				+ " <Version>123</Version>"
				+ " <APIDevUserID>123</APIDevUserID>"
				+ " <APIPassword>123</APIPassword>"
				+ " <APISellerUserID>123</APISellerUserID>"
				+ " <MessageID>123</MessageID>"
				+ " </GetAPACShippingPackageRequest>"
				+ " </GetAPACShippingPackage>" + "</soap12:Body>"
				+ " </soap12:Envelope>";
		PostMethod postMethod=new PostMethod("http://epacketws.pushauction.net/v3/orderservice.asmx?wsdl");
		//System.out.println(soapRequestData);
		//String requestData[]={"fundAccount":"20990008","password":"123123"};
		//PostMethod postMethod=new PostMethod("http://120.55.98.209/withfundservice/webservice/adminClientwebservice?wsdl");
		//然后把soap请求数据添加到PostMethod中
		byte[] b=soapRequestData.getBytes("utf-8");
		InputStream is=new ByteArrayInputStream(b,0,b.length);
		RequestEntity re=new InputStreamRequestEntity(is,b.length,"application/soap+xml;charset=utf-8");
		postMethod.setRequestEntity(re);
		//最后生成一个HttpClient对象，并发送postMethod请求
		HttpClient httpClient=new HttpClient();
		int status=httpClient.executeMethod(postMethod);
		if(status==200){
			System.out.println("调用成功");
			String soapResponseData=postMethod.getResponseBodyAsString();
			System.out.println(soapResponseData);
		}else{
			System.out.println("调用失败！错误码："+status);
		}
		
	}
}
