package com.yedam.emp;

import lombok.Data;

@Data
public class EmpSearchVO extends EmpVO{
	//paging과 관련된 값만 더 추가
	Integer page = 1;
	//null 체크하려면integer이 편함
	int start = 1;
	int end = 10;
}
