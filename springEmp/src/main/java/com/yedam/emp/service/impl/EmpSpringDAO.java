package com.yedam.emp.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yedam.emp.EmpVO;

@Repository
//(퍼시스턴스 레이어, DB나 파일같은 외부 I/O 작업을 처리함)
public class EmpSpringDAO {
	
	@Autowired JdbcTemplate jdbc;
	//resources안에 config/datasource-context.xml
	
	private final String INSERT_EMP="INSERT INTO EMPLOYEES(EMPLOYEE_ID, "
								+ "LAST_NAME, "
								+"EMAIL, "
								+"HIRE_DATE, "
								+"JOB_ID, "
								+"DEPARTMENT_ID) "
								+"VALUES(?, ?, ?, ?, ?, ?)"; 
	private final String UPDATE_EMP="UPDATE EMPLOYEES SET "
									+ "FIRST_NAME=?, "
									+ "LAST_NAME=?,  "
									+ "EMAIL=?,  "
									+ "HIRE_DATE=?,  "
									+ "JOB_ID=?  "
									+ "WHERE EMPLOYEE_ID=?"; 
	private final String DELETE_EMP="DELETE FROM EMPLOYEES WHERE EMPLOYEE_ID=?"; 
	private final String GET_EMP="SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID=?"; 
	private final String GET_SEARCH_EMP="SELECT * FROM EMPLOYEES"; 
	//등록
	public int insertEmp(EmpVO vo) {
		int result = 0;
		result = jdbc.update(INSERT_EMP, vo.getEmployee_id(),
				vo.getLast_name(), vo.getEmail(), vo.getHire_date(),
				vo.getJob_id(), vo.getDepartment_id());
		return result;
	}
	//수정
	public int updateEmp(EmpVO vo) {
		int result = 0 ;
		result = jdbc.update(UPDATE_EMP, vo.getFirst_name(), vo.getLast_name(),
							vo.getEmail(), vo.getHire_date(), vo.getJob_id(), vo.getEmployee_id());
		return result;
	}
	//삭제
	public int deleteEmp(EmpVO vo) {
		int result = 0;
		result = jdbc.update(DELETE_EMP, vo.getEmployee_id());
		return result;
	}
	
	//단건조회
	public EmpVO getEmp(EmpVO empVO) {
		return jdbc.queryForObject(GET_EMP, new EmpRowMapper(), empVO.getEmployee_id());
	}
	//검색조회
	public List<EmpVO> getSearchEmp(EmpVO empVO){
		return jdbc.query(GET_SEARCH_EMP, new EmpRowMapper());
	}
	//rowmapper
	class EmpRowMapper implements RowMapper<EmpVO>{

		@Override
		public EmpVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmpVO vo = new EmpVO();
			vo.setEmployee_id(rs.getString(1));
			vo.setFirst_name(rs.getString("first_name"));
			vo.setLast_name(rs.getString("last_name"));
			vo.setEmail(rs.getString("email"));
			vo.setPhone_number(rs.getString("phone_number"));
			vo.setHire_date(rs.getDate("hire_date"));
			vo.setJob_id(rs.getString("job_id"));
			vo.setSalary(rs.getInt("salary"));		
			vo.setDepartment_id(rs.getString("department_id"));
			return vo;
		}
		
	}
}
