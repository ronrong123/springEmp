package com.yedam.board.service;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class CommentsVO {
	private String id; //int(9자리),long(13자리) 다음에 더 큰값을 담을떄는 BigDecimal(38자리)을 씀
	private String name;
	private String content;
	private String board_id;
	private String out_msg;
	private String[] ids; //@JsonIgnore 넣으면 필드가 빠짐
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm") //날짜를 json으로 변환시키는것
	private Date wdate;
}
