package com.mega.mvcmini;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

	@Autowired
	MemberDAO dao;

	@RequestMapping("check.do")
	public String login(MemberDTO memberDTO, Model model, HttpSession session) {
		// 넣어줄값 dto , 리턴으로 들어올 모델 매개변수
		int result = dao.login(memberDTO);
		String page = "";
		if (result == 1) {
			session.setAttribute("id", memberDTO.getId());
			page = "okMain";// 로그인 성공시 제품등록 페이지로 이동
		} else {
			page = "noMain";// 브라우저에 요청하라고 명령함.
		}
		return page;
	}

	@RequestMapping("checkId.do")
	public void checkId(MemberDTO memberDTO, Model model) {
		int result = dao.checkId(memberDTO);
		System.out.println(result);
		System.out.println(memberDTO);
		model.addAttribute("result", result);
	}

	@RequestMapping("Join2.do")
	public void insert(MemberDTO memberDTO) {
		dao.Insert(memberDTO);
	}
	
	
}// 메인
