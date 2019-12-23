package com.biz.network.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class BindServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		
		ServerSocket server = new ServerSocket();		
		
		
		InetSocketAddress iSocket = new InetSocketAddress(8085);		// 기다릴 포트 정보를 생성 
												// 사용중인 포트인지 검사하는 절차가 내부적으로 수행
		
		
		server.bind(iSocket);  // 서버 소켓에 포트정보를 연결
		
		System.out.println("Server Wait");
		
		Socket client = server.accept();
		
		
		InputStream is = client.getInputStream();		// java의 **Stream file, network, console 프린터 등등 입출력
												// 장치와 연동을 쉽게하기 위한 여러가지 클래스가 존재하고 각각
									// 기능별로 잘 연결만 하면 최종 사용법은 거의 비슷
		
		
		while(true) {
			
			
			byte[] msg = new byte[255];	// 한번에 처리할 메시지의 크기를 지정하는 방식
			int imgSize = is.read(msg);	// is.read()메서드는 client에서 전송된 메시지를 msg 배열변수에 담고
										// 담긴 byte 개수를 return하여 imgSize 변수에 담아준다
			
			
		String strMsg = new String(msg,0,imgSize,"UTF-8");	// String 클래스를 사용하여 byte 배열에 담긴 데이터를 
			//UTF-8 방식으로 Decoding하여 읽을 수 있는 문자열로 변환
		
		System.out.println(strMsg);
		if(strMsg.equalsIgnoreCase("-q")) break;
		}
		
		System.out.println("Good Bye");

	}

}
