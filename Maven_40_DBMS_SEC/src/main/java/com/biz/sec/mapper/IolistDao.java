package com.biz.sec.mapper;

import java.util.List;
import java.util.Map;

import com.biz.sec.persistence.IolistDTO;

public interface IolistDao {
	
	
	public List<Map<String, Object>> selectAllMap();		// mapper.xml에 설정된 resultMap에 각 레코드 데이터를 담고
													// resultMap의 요소를 리스트로 묶어 보냄

	public List<IolistDTO> selectAll();
}
