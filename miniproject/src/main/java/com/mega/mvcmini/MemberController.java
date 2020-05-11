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
		// �־��ٰ� dto , �������� ���� �� �Ű�����
		int result = dao.login(memberDTO);
		String page = "";
		if (result == 1) {
			session.setAttribute("id", memberDTO.getId());
			page = "okMain";// �α��� ������ ��ǰ��� �������� �̵�
		} else {
			page = "noMain";// �������� ��û�϶�� �����.
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
	
	
}// ����
