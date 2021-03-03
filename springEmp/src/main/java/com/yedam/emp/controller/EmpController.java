package com.yedam.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.emp.DeptVO;
import com.yedam.emp.EmpVO;
import com.yedam.emp.service.DeptService;
import com.yedam.emp.service.EmpService;

@Controller
//(프레젠테이션 레이어, 웹 요청과 응답을 처리함)
public class EmpController {
	
	@Autowired EmpService empService;
	@Autowired DeptService deptService;
	
	@RequestMapping("/") 
	public String main() {
		return "main";
	}
	//emp
	@GetMapping("/insertEmp") //등록페이지로
	public String insertEmp(EmpVO vo) {
		return "/emp/insertEmp";
	}
	@PostMapping("/insertEmp") //등록처리
	public String insertEmpProc(EmpVO vo) {
		empService.insertEmp(vo);
		return "redirect:/getSearchEmp";
	}
	@GetMapping("/updateEmp") //수정페이지로
	public String updateEmp(EmpVO vo, Model model) {
		model.addAttribute("empVO", empService.getEmp(vo));
		return "/emp/updateEmp";
	}
	@PostMapping("/updateEmp") //수정처리
	public String updateEmpProc(EmpVO vo) {
		empService.updateEmp(vo);
		return "redirect:/getSearchEmp";
	}
	@RequestMapping("/deleteEmp") //삭제
	public String deleteEmp(EmpVO vo) {
		empService.deleteEmp(vo);
		return "redirect:/getSearchEmp";
	}
	@GetMapping("/getEmp") //단건조회
	public String getEmp(EmpVO vo, Model model) {
		model.addAttribute("emp", empService.getEmp(vo));
		return "/emp/getEmp";
	}
	@GetMapping("/getSearchEmp") //검색조회
	public String getSearchEmp(EmpVO vo, Model model) {
		model.addAttribute("list", empService.getSearchEmp(vo));
		return "/emp/getSearchEmp";
	}
	
	//dept
	@GetMapping("/insertDept")
	public String insertDept(DeptVO vo) {
		return "/dept/insertDept";
	}
	@PostMapping("/insertDept")
	public String insertDeptProc(DeptVO vo) {
		deptService.insertDept(vo);
		return "redirect:/getSearchDept";
	}
	
	@GetMapping("/updateDept")
	public String updateDept(DeptVO vo, Model model) {
		model.addAttribute("deptVO", deptService.getDept(vo));
		return "/dept/updateDept";
	}
	@PostMapping("/updateDept")
	public String updateDeptProc(DeptVO vo) {
		deptService.updateDept(vo);
		return "redirect:/getSearchDept";
	}
	@GetMapping("/getDept")
	public String getDept(DeptVO vo, Model model) {
		model.addAttribute("dept", deptService.getDept(vo));
		return "/dept/getDept";	
	}
	@GetMapping("/getSearchDept")
	public String getSearchDept(DeptVO vo, Model model) {
		model.addAttribute("list", deptService.getSearchDept(vo));
		return "/dept/getSearchDept";
	}
}
