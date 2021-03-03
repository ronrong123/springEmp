package com.yedam.emp.service.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yedam.emp.EmpVO;

@Repository
public class EmpMybatisDAO {
	@Autowired SqlSessionTemplate sqlSession;
	
	public int insertEmp(EmpVO vo) {
		return sqlSession.insert("com.yedam.emp.service.impl.EmpMapper.insertEmp", vo);
	}
	public int updateEmp(EmpVO vo) {
		return sqlSession.update("com.yedam.emp.service.impl.EmpMapper.updateEmp", vo);
	}
	public int deleteEmp(EmpVO vo) {
		return sqlSession.delete("com.yedam.emp.service.impl.EmpMapper.deleteEmp", vo);
	}
	public EmpVO getEmp(EmpVO vo) {
		return sqlSession.selectOne("com.yedam.emp.service.impl.EmpMapper.getEmp", vo);
	}
	public List<EmpVO> getSearchEmp(EmpVO empVO) {
		System.out.println("mybatis list");
		return sqlSession.selectList("com.yedam.emp.service.impl.EmpMapper.getSearchEmp",empVO);
	}
}
