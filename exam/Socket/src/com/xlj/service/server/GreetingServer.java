/**
 * 
 */
package com.xlj.service.server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 */
public class GreetingServer extends Thread{

	
	private ServerSocket serverSocket;
	public GreetingServer(int port) throws IOException{
		serverSocket=new ServerSocket(port);
		serverSocket.setSoTimeout(100000);
	}
	public void run(){
		while(true){
			System.out.println("Waiting for client on port"+serverSocket.getLocalPort()+"...");
			try {
				Socket server=serverSocket.accept();
				System.out.println("Just connected to "+server.getRemoteSocketAddress());
				DataInputStream in = new DataInputStream(server.getInputStream());
				System.out.println(in.readUTF());
				DataOutputStream out=new DataOutputStream(server.getOutputStream());
				out.writeUTF("Thank you for connecting to "+server.getLocalSocketAddress()+"\nGoodbye!");
				server.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public static void main(String[] args) throws IOException{
		
		System.out.println("请输入地址和端口号（port）：");
		BufferedReader br=null;
		br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		String[] courseArray=s.split(",");//用=号将输入分开
		int port=Integer.parseInt(courseArray[0]);
		try {
			Thread t=new GreetingServer(port);
			t.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
