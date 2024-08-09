package com.ezen.springdata.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;


@Data
public class EmployeeDTO {
	// DTO의 필드명과 DB의 컬럼명이 일치해야 정상적으로 작동한다.
	private Integer employee_id;
	private String first_name;
	private String last_name;
	private String email;
	private String phone_number;
	private Date hire_date;
	private String job_id;
	private Double salary;
	private Double commission_pct;
	private Integer manager_id;
	private Integer department_id;
}
