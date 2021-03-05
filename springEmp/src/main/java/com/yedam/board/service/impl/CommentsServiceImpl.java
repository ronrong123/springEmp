package com.yedam.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.board.service.CommentsService;
import com.yedam.board.service.CommentsVO;

@Service
public class CommentsServiceImpl implements CommentsService{
	//서비스를 상속받음
	
	@Autowired CommentsMapper dao;
	//commentsMapper를 불러온다
	public void insertComments(CommentsVO vo) {
		dao.insertComments(vo);		
	}

	public int deleteComments(CommentsVO vo) {
		return dao.deleteComments(vo);
	}

	public CommentsVO getComments(CommentsVO vo) {
		return dao.getComments(vo);
	}

	public List<CommentsVO> getSearchComments(CommentsVO vo) {
		return dao.getSearchComments(vo);
	}

}
