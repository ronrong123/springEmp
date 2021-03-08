package com.yedam.emp.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.board.service.UserService;
import com.yedam.board.service.UserVO;

@Controller
public class LoginController {
	
	@Resource UserService userService;
	//Autowired와 같음
	
	@GetMapping("/changePw") //패스워드변경페이지이동
	public String changePw() {
		return "user/changePw";
	}
	@PostMapping("/changePw") //패스워드변경페이지이동
	public String changePwProc(HttpSession session, UserVO vo) {
		//validation 일치여부
		
		//패스워드 변경 서비스
		String id = (String)session.getAttribute("loginid"); //저장은 set 읽어내는건 get
		vo.setId(id);
		userService.updatePw(vo);
		//impl에있는 updatePw에 넣음
		return "redirect:/";
	}
	@GetMapping("/login") //로그인페이지 이동
	public String login() {
		return "user/login";
	}
	
	@PostMapping("/login") //로그인처리
	public String loginproc(UserVO vo, HttpSession session) {
		if(userService.logCheck(vo)) { //로그인 됨
			//세션에저장
			session.setAttribute("loginid", vo.getId());
			return "redirect:/";
		}else {
			return "user/login";
		}
	}
	
	@GetMapping("/logout") //로그아웃 처리
	public String logout(HttpSession session) {
		session.invalidate(); //세션무효화
		return "redirect:/";		
	}
}
