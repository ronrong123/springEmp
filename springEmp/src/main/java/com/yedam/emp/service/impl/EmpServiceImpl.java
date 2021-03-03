package com.yedam.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.emp.EmpVO;
import com.yedam.emp.service.EmpService;

@Service
//(서비스 레이어, 내부에서 자바 로직을 처리함)
public class EmpServiceImpl implements EmpService{
	//@Autowired EmpSpringDAO dao;
	//@Autowired EmpMybatisDAO dao;
	@Autowired EmpMapper dao;
	
	public int insertEmp(EmpVO vo) {
		// TODO Auto-generated method stub
		return dao.insertEmp(vo);
	}

	public int updateEmp(EmpVO vo) {
		// TODO Auto-generated method stub
		return dao.updateEmp(vo);
	}

	public int deleteEmp(EmpVO vo) {
		// TODO Auto-generated method stub
		return dao.deleteEmp(vo);
	}

	public EmpVO getEmp(EmpVO vo) {
		// TODO Auto-generated method stub
		return dao.getEmp(vo);
	}

	public List<EmpVO> getSearchEmp(EmpVO vo) {
		// TODO Auto-generated method stub
		return dao.getSearchEmp(vo);
	}
}
