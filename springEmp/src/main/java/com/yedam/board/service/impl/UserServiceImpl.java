package com.yedam.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.board.service.UserService;
import com.yedam.board.service.UserVO;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired UserMapper dao;

	public UserVO getUser(UserVO vo) {
		return dao.getUser(vo);
	}

	public List<UserVO> getSearchUser(UserVO vo) {
		// TODO Auto-generated method stub
		return dao.getSearchUser(vo);
	}

	public int deleteUser(UserVO vo) {
		// TODO Auto-generated method stub
		return dao.deleteUser(vo);
	}

	public int updateUser(UserVO vo) {
		// TODO Auto-generated method stub
		return dao.updateUser(vo);
	}

	public void insertUser(UserVO vo) {
		dao.insertUser(vo);
	}

}
