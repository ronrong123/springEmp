package com.yedam.board.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.board.service.UserService;
import com.yedam.board.service.UserVO;

@RestController
public class UserController {
	
	@Autowired UserService userService;
	
	@PostMapping("/User")
	public UserVO insertUser(@RequestBody UserVO vo) {
		 userService.insertUser(vo);
		 return userService.getUser(vo);
	}
	@PutMapping("/User")
	public UserVO updateUser(@RequestBody UserVO vo) {
		//@RequestBody 어노테이션을 이용하면 HTTP 요청 Body를 자바 객체로 전달받을 수 있다.
		//@RequestBody : 입력값을 변경, 이게 들어가면 json방식으로 값을 넘겨줘야함
		userService.updateUser(vo);
		return vo;
	}
	@DeleteMapping(value="/User/{id}")
	public Map deleteUserProc(UserVO vo, @PathVariable String id) {
		//@PathVariable : 경로의 특정 위치값이 고정되지 않고 달라질 떄 사용함
		//{템플릿 변수}를 사용할떄 @PathVariable을 이용해 {템플릿 변수}와 동일한 이름을 갖는 파라미터를 추가 
		vo.setId(id);
		int r = userService.deleteUser(vo);
		return Collections.singletonMap("cnt", r);
	}
	@GetMapping("/User")
	public List<UserVO> getSearchUser(UserVO vo){
		return userService.getSearchUser(vo);
	}
	@GetMapping("/User/{id}")
	public UserVO getUser(UserVO vo, @PathVariable String id) {
		vo.setId(id);
		return userService.getUser(vo);
	}
}
