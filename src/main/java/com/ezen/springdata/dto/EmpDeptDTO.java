package com.ezen.springdata.dto;

import lombok.Data;

@Data
public class EmpDeptDTO {
	private Integer employee_id;
	private String first_name;
	private String last_name;
	private Integer department_id;
	private String department_name;
}
