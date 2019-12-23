package com.biz.oracle.mapper;

import java.util.List;
import java.util.Map;

import javax.swing.ListModel;

public interface IolistDao {

	// resultMap 으로 설정된 형태는 Map<String,Object> 형태의 DTO가 만들어진 것으로 봄
	public List<Map<String, Object>> selectAll();
}
