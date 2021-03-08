package com.yedam.emp;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeptVO {
	private Integer department_id;
	private String department_name;
	private Integer manager_id;
	private int location_id;
}
