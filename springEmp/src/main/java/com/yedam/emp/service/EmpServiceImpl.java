package com.yedam.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.emp.EmpSearchVO;
import com.yedam.emp.EmpVO;
import com.yedam.emp.service.impl.EmpMapper;

@Service
//(서비스 레이어, 내부에서 자바 로직을 처리함)
public class EmpServiceImpl implements EmpService{
	//@Autowired EmpSpringDAO dao;
	//@Autowired EmpMybatisDAO dao;
	@Autowired EmpMapper dao;
	
	   //@Transactional //에러가 나면 둘 다 롤백됨
	public int insertEmp(EmpVO vo) {
		dao.insertEmp(vo); //자동커밋
		return dao.insertEmp(vo); //uk 에러 발생
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

	public List<EmpVO> getSearchEmp(EmpSearchVO vo) {
		// TODO Auto-generated method stub
		return dao.getSearchEmp(vo);
	}

	@Override
	public int getCount(EmpSearchVO vo) {
		// TODO Auto-generated method stub
		return dao.getCount(vo);
	}
}
