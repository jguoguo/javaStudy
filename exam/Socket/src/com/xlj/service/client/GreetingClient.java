/**
 * 
 */
package com.xlj.service.client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 
 */
public class GreetingClient {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("请输入地址和端口号（address，port）：");
		BufferedReader br=null;
		br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		String[] courseArray=s.split(",");//用=号将输入分开
		String serverName=courseArray[0];
		int port=Integer.parseInt(courseArray[1]);
		System.out.println("Connecting to "+serverName+"on prot"+port);
		try {
			Socket client=new Socket(serverName,port);
			System.out.println("Just connected to "+client.getRemoteSocketAddress());
			OutputStream outToServer=client.getOutputStream();
			DataOutputStream out=new DataOutputStream(outToServer);
			out.writeUTF("Hello from" + client.getLocalSocketAddress());
			InputStream inFromServer = client.getInputStream();
			DataInputStream in=new DataInputStream(inFromServer);
			System.out.println("Server says "+in.readUTF());
			client.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
