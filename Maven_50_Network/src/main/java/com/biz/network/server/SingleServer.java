package com.biz.network.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 
 * Newwork 환경에서 Server 역할
 * 1. 프로세스가 시작되어 Client의 접속이 있을 때까지 무한정 기다림
 * 	-ServerSocket 생성 -> accept():접속 대기 -> Client의 접속이 오면 그에 따른 응답 수행
 * 
 */
public class SingleServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		ServerSocket server = new ServerSocket(8085);		// 현재 클래스를 서버로 사용하기 위해 네트워크 Layer의 전송계층의 접속 정보를 생성
		
		System.out.println("Server Wait....");
		
		Socket client = server.accept(); //클라이언트의 응답을 기다리기, blocking이 되면서 누군가 네트워크를 통해 접속하기를 기다림
							// 클라이언트가 접속하면 클라이언트의 정보가 담긴 또 다른 socket 객체를 return 하도록 되어 있음
		
		
		String clientAddr = client.getInetAddress().toString();
		
		String clientPort = client.getLocalPort()+"";
		
		System.out.println("Client IP:" + clientAddr);
		System.out.println("Client Port:" + clientPort);
		

	}

}
