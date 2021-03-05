package com.yedam.board.service;

import java.util.List;

public interface CommentsService {

	//등록
	public void insertComments(CommentsVO vo);
	//수정
	public int deleteComments(CommentsVO vo);
	//단건조회
	public CommentsVO getComments(CommentsVO vo);
	//전체조회
	public List<CommentsVO> getSearchComments(CommentsVO vo);
}
