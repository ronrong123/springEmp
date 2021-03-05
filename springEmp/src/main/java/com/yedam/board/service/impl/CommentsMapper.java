package com.yedam.board.service.impl;

import java.util.List;

import com.yedam.board.service.CommentsVO;

public interface CommentsMapper {
	//등록
	public void insertComments(CommentsVO vo);
	//수정
	public int deleteComments(CommentsVO vo);
	//단건조회
	public CommentsVO getComments(CommentsVO vo);
	//전체조회
	public List<CommentsVO> getSearchComments(CommentsVO vo);
}
