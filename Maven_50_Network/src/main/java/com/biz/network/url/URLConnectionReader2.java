package com.biz.network.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class URLConnectionReader2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String naverURL = "http://www.naver.com/";
		String encNaverURL = URLEncoder.encode(naverURL, "UTF-8");	// 일부 홈페이지는 주소를 직접 URL로 요청하면
															// 주소변환 과정등의 문제로 접속이 불가, 이때는 주소를 UTF-8로 encoding 수행해야 함
		URL naver = new URL(naverURL);

		URLConnection naverOpen = naver.openConnection();

		//naverOpen.connect();// 실제로 사용하지 않아도 **sTREAM이 작동될 때마다 내부적으로 자동수행되는 코드
		
		naverOpen.setDoOutput(true); // URL에 설정된 url 문자열을 사용하지 말고 OutputStream으로 전송된 encoding url 문자열을 사용하여 서버에 접속
		
		OutputStreamWriter osw = new OutputStreamWriter(naverOpen.getOutputStream());	// URL Encoding의 문제가 있을 경우
																		// Encoding된 URL String을 OutputStreamWriter로 재전송
		
		osw.write(encNaverURL);
		osw.close();

		BufferedReader br = new BufferedReader(new InputStreamReader(naverOpen.getInputStream()));

		String reader = "";

		while (true) {
			reader = br.readLine();

			if (reader == null)
				break;
			System.out.println(reader);
		}
		br.close();

	}

}
