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

import com.yedam.board.service.CommentsService;
import com.yedam.board.service.CommentsVO;

@RestController //(ResponseBody + controller) 모든 객체를 JSON형식으로 반환 
public class CommentsController {
	
	@Autowired CommentsService commentsService;
	//하려면 ServiceImpl에 @Service를 해야함
	
	//등록처리
	@PostMapping("/Comments") //주소
	public CommentsVO insertCommentsProc(@RequestBody CommentsVO vo) {
		commentsService.insertComments(vo);
		if(vo.getId().equals("0")) {
			return vo;
		}else {
			return commentsService.getComments(vo);			
		}
	}
	//수정
	@PutMapping("/Comments")
	public CommentsVO updateCommentsProc(@RequestBody CommentsVO vo) {
		//@RequestBody 어노테이션을 이용하면 HTTP 요청 Body를 자바 객체로 전달받을 수 있다.
		//@RequestBody : 입력값을 변경, 이게 들어가면 json방식으로 값을 넘겨줘야함
		System.out.println("수정 ====" + vo);
		return vo;
	}
	
	//삭제
	@DeleteMapping(value = "/Comments") //, method= RequestMethod.DELETE)
	public Map deleteCommentsProc(@RequestBody CommentsVO vo) {
		int r = commentsService.deleteComments(vo);
		return Collections.singletonMap("cnt", r);
	}	
	//게시글의 댓글조회
	@GetMapping("/Comments")
	//@ResponseBody //list를 json구조의 String으로 변경해달라고 요청하는것
	public List<CommentsVO> getSearchComments(CommentsVO vo) {
		return commentsService.getSearchComments(vo);
	}	
	//단건조회
	@GetMapping("/Comments/{id}")
	public CommentsVO getComments(CommentsVO vo
								 ,@PathVariable String id ) {
		vo.setId(id);
		return commentsService.getComments(vo);
	}
}
