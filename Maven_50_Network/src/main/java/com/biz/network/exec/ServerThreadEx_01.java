package com.biz.network.exec;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.Scanner;

import com.biz.network.server.ServerThreadV1;

public class ServerThreadEx_01 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		ServerSocket server = new ServerSocket();
		InetSocketAddress iSocket = new  InetSocketAddress(8085);
		server.bind(iSocket);
		
		ServerThreadV1 tServer =  new ServerThreadV1(server);
		Thread tRun = new Thread(tServer);

		
		tRun.start();
		
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("Server >> ");
			String strSend = scan.nextLine();
			
			System.out.println("Server: "+ strSend);
		}
	}

}
