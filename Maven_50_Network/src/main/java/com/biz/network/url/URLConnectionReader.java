package com.biz.network.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class URLConnectionReader {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String naverURL = "http://www.naver.com/";
		String encNaverURL = URLEncoder.encode(naverURL, "UTF-8");	// 일부 홈페이지는 주소를 직접 URL로 요청하면
															// 주소변환 과정등의 문제로 접속이 불가, 이때는 주소를 UTF-8로 encoding 수행해야 함
		URL naver = new URL(encNaverURL);

		URLConnection naverOpen = naver.openConnection();

		naverOpen.connect();// 실제로 사용하지 않아도 **sTREAM이 작동될 때마다 내부적으로 자동수행되는 코드

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
