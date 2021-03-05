package com.yedam.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.emp.DeptSearchVO;
import com.yedam.emp.DeptVO;
import com.yedam.emp.EmpSearchVO;
import com.yedam.emp.EmpVO;
import com.yedam.emp.JobVO;
import com.yedam.emp.common.Paging;
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
	public String insertEmp(EmpVO vo, Model model, DeptSearchVO dsearchVO, JobVO jobvo) {
		dsearchVO.setStart(1);
		dsearchVO.setEnd(1000);
		model.addAttribute("deptList", deptService.getSearchDept(dsearchVO));
		return "/emp/insertEmp";
	}
	@PostMapping("/insertEmp") //등록처리
	public String insertEmpProc(EmpVO vo) {
		empService.insertEmp(vo);
		return "redirect:/getSearchEmp";
	}
	@GetMapping("/updateEmp") //수정페이지로
	public String updateEmp(EmpVO vo, Model model, DeptSearchVO dsearchVO, JobVO jobvo) {
		dsearchVO.setStart(1);
		dsearchVO.setEnd(1000);
		model.addAttribute("deptList", deptService.getSearchDept(dsearchVO));
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
	@GetMapping("/getEmp") //단건조회 //PathVariable를 쓰려면 ("/getEmp/{employee_id}")로 변경해줘야함
	public String getEmp(Model model 
			//HttpServletRequest request
			//,@RequestParam(value = "id", required = false, defaultValue = "100") String employee_id //requst.getparameter와 같은것 request와 param이름이 다르면 ()안에 변수이름(parameter)을 적는다
			//, @PathVariable String employee_id //("/getEmp/{id}")이면 {id}안에 값이 들어감 
			,@ModelAttribute("employee") EmpVO vo) {
		//1. 직접 getParameter을 이용해 하는방법
		//String employee_id = request.getParameter("employee_id");
		//EmpVO vo = new EmpVO();
		
		//vo.setEmployee_id(employee_id);
		model.addAttribute("emp", empService.getEmp(vo));
		//자동으로 EmpVO를 empVO라는 변수에 담아 넘어감
		return "/emp/getEmp";
	}
	@GetMapping("/getSearchEmp") //검색조회
	public String getSearchEmp(EmpSearchVO vo, Paging paging, Model model) {
		paging.setPageUnit(5); //한페이지에 출력되는 레코드 건수
		paging.setPageSize(3); //페이지번호가 3개씩 보임
		//페이징
		if(vo.getPage() == null) {
			vo.setPage(1);
		}
		vo.setStart(paging.getFirst());
		vo.setEnd(paging.getLast());
		//전체페이지가 넘어가야 last를 구함
		paging.setTotalRecord(empService.getCount(vo));
		model.addAttribute("paging", paging);
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
	public String getSearchDept(DeptSearchVO vo,Paging paging, Model model) {
		paging.setPageUnit(5); //한페이지에 출력되는 레코드 건수
		paging.setPageSize(3); //페이지번호가 3개씩 보임
		//페이징
		if(vo.getPage() == null) {
			vo.setPage(1);
		}
		vo.setStart(paging.getFirst());
		vo.setEnd(paging.getLast());
		//전체페이지가 넘어가야 last를 구함
		paging.setTotalRecord(deptService.getCount(vo));
		model.addAttribute("paging", paging);
		model.addAttribute("list", deptService.getSearchDept(vo));
		return "/dept/getSearchDept";
	}
}
