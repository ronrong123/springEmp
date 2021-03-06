package com.yedam.emp.service;

import java.util.List;

import com.yedam.emp.DeptSearchVO;
import com.yedam.emp.DeptVO;

public interface DeptService {
	//등록
	public int insertDept(DeptVO vo);
	//수정
	public int updateDept(DeptVO vo);
	//단건조회
	public DeptVO getDept(DeptVO vo);
	//전체조회
	public List<DeptVO> getSearchDept(DeptVO vo);
	//레코드건수
	public int getCount(DeptSearchVO vo);
}
