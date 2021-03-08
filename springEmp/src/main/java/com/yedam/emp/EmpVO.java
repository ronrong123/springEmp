package com.yedam.emp;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//getter,setter만들어줌
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpVO {
	@NotEmpty
	private String employee_id;
	@NotEmpty
	private String first_name;
	@NotEmpty(message ="last_name 필수입니다")
	private String last_name;
	@NotEmpty
	private String email;
	private String phone_number;
	@NotNull //date는 notnull로해야함
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date hire_date;
	private String job_id;
	private Integer salary;
	private String commission_pct;
	private String manager_id;
	private String department_id;
	private String department_name;
	private String job_title;
}
