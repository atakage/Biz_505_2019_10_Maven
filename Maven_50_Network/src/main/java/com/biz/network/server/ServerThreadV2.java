package com.biz.network.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThreadV2 implements Runnable {

	ServerSocket server = null;

	public ServerThreadV2(ServerSocket server) {
		// TODO Auto-generated constructor stub

		this.server = server;
	}

	public void run() {

		

		Socket client = null;

		try {
			
			while(true) {
				
				int id =0;
				
				client = this.server.accept(); // 클라이언트 응답 대기
				
				ServerSubThreadV1 ss = new ServerSubThreadV1(client, ++id);
				Thread tRun = new Thread(ss);
				tRun.start();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
