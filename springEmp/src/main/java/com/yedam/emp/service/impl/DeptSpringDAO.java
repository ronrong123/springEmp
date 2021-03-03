package com.yedam.emp.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yedam.emp.DeptVO;

@Repository
public class DeptSpringDAO {
	@Autowired JdbcTemplate jdbc;
	
	private final String INSERT_DEPT="INSERT INTO DEPARTMENTS(DEPARTMENT_ID,"
									+ "DEPARTMENT_NAME, "
									+ "LOCATION_ID) "
									+ "VALUES(?,?,?)";
	private final String UPDATE_DEPT = "UPDATE DEPARTMENTS SET "
										+ "DEPARTMENT_NAME=?, "
										+ "MANAGER_ID =?, "
										+ "LOCATION_ID=?"
										+ " WHERE DEPARTMENT_ID=?";
	private final String GET_DEPT="SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID=?";
	private final String GET_SEARCH_DEPT="SELECT * FROM DEPARTMENTS";
	//등록
	public int insertDept(DeptVO vo) {
		int result = 0;
		result = jdbc.update(INSERT_DEPT, vo.getDepartmentId(), vo.getDepartmentName(), vo.getLocationId());
		return result;
	}
	//수정
	public int updateDept(DeptVO vo) {
		int result = 0;
		result = jdbc.update(UPDATE_DEPT, vo.getDepartmentName(), vo.getManagerId(),vo.getLocationId(),vo.getDepartmentId());
		return result;
	}
	//단건조회
	public DeptVO getDept(DeptVO vo) {
		return jdbc.queryForObject(GET_DEPT,new DeptRowMapper(), vo.getDepartmentId());
	}
	//전체조회
	public List<DeptVO> getSearchDept(DeptVO vo){
		return jdbc.query(GET_SEARCH_DEPT, new DeptRowMapper());
	}
	
	class DeptRowMapper implements RowMapper<DeptVO>{

		@Override
		public DeptVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			DeptVO vo = new DeptVO();
			vo.setDepartmentId(rs.getInt("department_id"));
			vo.setDepartmentName(rs.getString("department_name"));
			vo.setManagerId(rs.getInt("manager_id"));
			vo.setLocationId(rs.getInt("location_id"));
			return vo;
		}
		
	}
}
