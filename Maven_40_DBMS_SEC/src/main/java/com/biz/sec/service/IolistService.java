package com.biz.sec.service;

import java.util.List;
import java.util.Map;

import com.biz.sec.config.DBConnectionSEC;
import com.biz.sec.mapper.IolistDao;

public class IolistService {
	
	protected IolistDao iolistDao;
	{
		iolistDao = DBConnectionSEC.getSqlSessionFactory().openSession(true).getMapper(IolistDao.class);	// 인스턴스 생성자로
				// IolistService의 생성자보다 먼저 실행되고 생성자 method에 관계없이 자동으로 실행되는 코드들의 묶음
		
		
		/*
		 * static{}, {} : 초기화 블록
		 * static{} : 스태틱 블록
		 * {} : 인스턴스 블록
		 * 
		 * 
		 * 아래와 같이 생성자가 여러 개 일 때
		 * 각 생성자마다 필드변수를 초기화하는 코드를 넣어주어야 하는데 간혹 생략했을 때 NullPointException이 발생할 수 있음
		 * 
		 * 
		 * IolistService is = new IolistService()
		 * IolistService is = new IolistService("aaa");
		 * 
		 * 
		 * 
		 * 이러한 경ㅇ
		 * 공통으로 초기화, 생성하는 코드들을 인스턴스 생성자에 작성해주면 생성자 method에 관계 없이 자동으로 실행하도록 할 수 있음
		 */
	}
	
	
	
	public IolistService() {
		// TODO Auto-generated constructor stub
		
	}
	
	
	public void viewIoList() {
		
		List<Map<String, Object>> iolist = iolistDao.selectAllMap();
		
		for(Map<String, Object> io : iolist) {
			
			System.out.println(io.get("IO_SEQ")+"\t");
			System.out.println(io.get("IO_DATE")+"\t");
			System.out.println(io.get("IO_INOUT")+"\t");
			System.out.println(io.get("IO_QTY")+"\t");
			System.out.println(io.get("IO_PRICE")+"\t");
			System.out.println(io.get("IO_TOTAL")+"\t");
			System.out.println(io.get("IO_PCODE")+"\t");
			System.out.println(io.get("IO_DCODE")+"\t");
			
		}
	}

}
