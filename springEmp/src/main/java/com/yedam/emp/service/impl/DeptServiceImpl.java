package com.yedam.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.emp.DeptSearchVO;
import com.yedam.emp.DeptVO;
import com.yedam.emp.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {
//	@Autowired DeptSpringDAO dao;
	@Autowired DeptMapper dao;
	
	public int insertDept(DeptVO vo) {
		// TODO Auto-generated method stub
		return dao.insertDept(vo);
	}

	public int updateDept(DeptVO vo) {
		// TODO Auto-generated method stub
		return dao.updateDept(vo);
	}

	public DeptVO getDept(DeptVO vo) {
		// TODO Auto-generated method stub
		return dao.getDept(vo);
	}

	public List<DeptVO> getSearchDept(DeptVO vo) {
		// TODO Auto-generated method stub
		return dao.getSearchDept(vo);
	}

	public int getCount(DeptSearchVO vo) {
		// TODO Auto-generated method stub
		return dao.getCount(vo);
	}

}
