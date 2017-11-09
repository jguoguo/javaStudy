package com.bjpowernode.ws;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

public class WeatherClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WeatherWebService service=new WeatherWebServiceLocator();
		try {
			WeatherWebServiceSoap_PortType serviceSoapPortType=service.getWeatherWebServiceSoap12();
			String[] provice=serviceSoapPortType.getSupportProvince();
			for(int i=0;i<provice.length;i++){
				System.out.println(provice[i]);
			}
			System.out.println("-------------------------------");
			String[] cites=serviceSoapPortType.getSupportCity("河南");
			for(int i=0;i<cites.length;i++){
				System.out.println(cites[i]);
			}
			System.out.println("-------------------------------");
			String[] wether=serviceSoapPortType.getWeatherbyCityName("北京");
			for(int i=0;i<wether.length;i++){
				System.out.println(wether[i]);
			}
			System.out.println("-------------------------------");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
