package com.biz.network.exec;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.Scanner;

import com.biz.network.server.ServerThreadV2;

public class ServerThreadEx_02 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		ServerSocket server = new ServerSocket();
		InetSocketAddress iSocket = new  InetSocketAddress(8085);
		server.bind(iSocket);
		
		ServerThreadV2 tServer = new ServerThreadV2(server);
		
		Thread tRun = new Thread(tServer);
		
		
		tRun.start();
		
		Scanner scan = new Scanner(System.in);
		while(true) {
			
			System.out.println(">> ");
			String strSend = scan.nextLine();
			
		}

	}

}
