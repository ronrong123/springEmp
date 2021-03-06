package com.yedam.board.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yedam.board.service.UserService;
import com.yedam.board.service.UserVO;

@RestController
public class UserController {
	
	@Autowired UserService userService;
	
	@PostMapping("/insertuser")
	public ResponseEntity<Object> insertUser(UserVO vo) throws JsonProcessingException {
		 userService.insertUser(vo);
		 UserVO userVO = userService.getUser(vo);
		 if(userVO != null) {
			 ObjectMapper mapper = new ObjectMapper(); //jackson라이브러리 json으로 변환시켜주는 작업을 함 
			 return ResponseEntity.status(200).body(mapper.writeValueAsString(userVO));//자바객체를 넘겨주면 리턴값을String으로 넘겨줌
		 }else {
			 return ResponseEntity.status(500).body("insert error"); //userService.getUser(vo);			 
		 }
	}
	@PostMapping("/updateuser")
	public UserVO updateUser(UserVO vo) {
		//@RequestBody 어노테이션을 이용하면 HTTP 요청 Body를 자바 객체로 전달받을 수 있다.
		//@RequestBody : 입력값을 변경, 이게 들어가면 json방식으로 값을 넘겨줘야함
		userService.updateUser(vo);
		return vo;
	}
	@GetMapping(value="/deleteuser")
	public Map deleteuser(UserVO vo) {
		//@PathVariable : 경로의 특정 위치값이 고정되지 않고 달라질 떄 사용함
		//{템플릿 변수}를 사용할떄 @PathVariable을 이용해 {템플릿 변수}와 동일한 이름을 갖는 파라미터를 추가 
		int r = userService.deleteUser(vo);
		return Collections.singletonMap("cnt", r);
	}
	@GetMapping("/getuserlist")
	public List<UserVO> getSearchUser(UserVO vo){
		return userService.getSearchUser(vo);
	}
	@GetMapping("/getuser")
	public UserVO getUser(UserVO vo) {
		return userService.getUser(vo);
	}
}
