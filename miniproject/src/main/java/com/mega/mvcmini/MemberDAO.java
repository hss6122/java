package com.mega.mvcmini;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//dto를 통해서 온 id,pw값을 마이바티스에 담는다
@Component
public class MemberDAO {

	@Autowired
	SqlSessionTemplate my;
	

	public int login(MemberDTO dto) {
		int result = 0; //없음.
		MemberDTO dto2 = null;
		dto2 = my.selectOne("member.check", dto);
		if (dto2 != null) {
			result = 1;
		}
		return result;
	}// login

	public int checkId(MemberDTO dto) {
		int result = 0; //없음
		result = my.selectOne("member.checkId", dto);
		return result;
	}
	
	public void Insert(MemberDTO dto) {
		my.insert("member.Join", dto);
	}
	
	
	
}
