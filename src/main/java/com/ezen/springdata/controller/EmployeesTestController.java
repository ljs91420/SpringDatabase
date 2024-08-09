package com.ezen.springdata.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.springdata.mapper.EmployeeMapper;

import lombok.RequiredArgsConstructor;

@RequestMapping("/emp")
@RequiredArgsConstructor
@Controller
public class EmployeesTestController {
	
	private final EmployeeMapper employeesMapper;
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("empList", employeesMapper.getAll());
		return "emp/list";
	}

	@GetMapping("/detail")
	public String detail(Model model, Integer employee_id) {
		model.addAttribute("emp", employeesMapper.get(employee_id));
		
		return "emp/detail";
	}
    private static final List<Integer> VALID_DEPARTMENT_IDS = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110);

	@GetMapping("/dept/{dept_id}/")
	public String deptList(@PathVariable("dept_id") Integer department_id, Model model) {
		Integer minValue = VALID_DEPARTMENT_IDS.get(0);
		int minDif = Math.abs(department_id - minValue);
		for (Integer value : VALID_DEPARTMENT_IDS) {			
			int diff = Math.abs(department_id - value);
			
			if (diff < minDif) {
				minDif = diff;
				minValue = value;
			}
		}
		department_id = minValue;
		model.addAttribute("empList", employeesMapper.getByAllByDeptId(department_id));
		
		return "emp/list";
	}
	
	@GetMapping("/dept/{dept_id}/{emp_id}")
	public String deptEmpDetail(
					@PathVariable Integer emp_id,
					@PathVariable Integer dept_id, Model model) {
		
		model.addAttribute("emp_dept", employeesMapper.getEmpDept(emp_id));

		return "emp/dept_detail";
	}
	
	@GetMapping("/salary/under/{salary}")
	public String underSalary(
					@PathVariable Double salary,
					Model model) {
		model.addAttribute("empList", employeesMapper.getAllUnderSalary(salary));
		
		return "emp/list";
	}
	
	
}
