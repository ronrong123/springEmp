package com.yedam.emp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.emp.OrderMasterVO;

@Controller
public class OrderController {
	
	
	@GetMapping("/insertOrder") //주문폼
	public String insertOrder(OrderMasterVO vo) {
		System.out.println(vo);
		return "order/insertOrder";
	}
	
	@PostMapping("/insertOrder") //주문처리
	public String insertOrderProc(OrderMasterVO vo) {
		System.out.println(vo);
		//master table등록
		//detail(주문상세) list수만큼 등록
		return "redirect:/";
	}
}
