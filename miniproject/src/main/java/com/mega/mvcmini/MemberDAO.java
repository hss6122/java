package com.mega.mvcmini;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//dto�� ���ؼ� �� id,pw���� ���̹�Ƽ���� ��´�
@Component
public class MemberDAO {

	@Autowired
	SqlSessionTemplate my;
	

	public int login(MemberDTO dto) {
		int result = 0; //����.
		MemberDTO dto2 = null;
		dto2 = my.selectOne("member.check", dto);
		if (dto2 != null) {
			result = 1;
		}
		return result;
	}// login

	public int checkId(MemberDTO dto) {
		int result = 0; //����
		result = my.selectOne("member.checkId", dto);
		return result;
	}
	
	public void Insert(MemberDTO dto) {
		my.insert("member.Join", dto);
	}
	
	
	
}
