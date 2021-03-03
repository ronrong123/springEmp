package com.yedam.emp.service.impl;

import java.util.List;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yedam.emp.DeptVO;
@Repository
public class DeptMybatisDAO {
	@Autowired SqlSessionTemplate sqlSession;
	
	public int insertDept(DeptVO vo) {
		return sqlSession.insert("com.yedam.emp.service.impl.DeptMapper.insertDept", vo);
	}
	public int updateDept(DeptVO vo) {
		return sqlSession.update("com.yedam.emp.service.impl.DeptMapper.updateDept", vo);
	}
	public DeptVO getDept(DeptVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("com.yedam.emp.service.impl.DeptMapper.getDept", vo);
	}

	public List<DeptVO> getSearchDept(DeptVO deptVO) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("com.yedam.emp.service.impl.DeptMapper.getSearchDept", deptVO);
	}
}
