package com.yedam.board;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.board.service.CommentsVO;
import com.yedam.board.service.impl.CommentsMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/config/*-context.xml")
public class CommentsMapperClient {

	@Autowired CommentsMapper commentMapper;
	//Autowired : 각 상황의 타입에 맞는 Bean을 자동주입해주는것
	@Test
	public void delete() {
		CommentsVO vo = new CommentsVO();
		vo.setIds(new String[] {"1", "2"});
		commentMapper.deleteComments(vo);
	}
	
	//@Test
	public void insert() {
		CommentsVO vo = new CommentsVO();
		vo.setBoard_id("2");
		vo.setContent("마이바티스2");
		vo.setName("user2");
		commentMapper.insertComments(vo);
	}
}
