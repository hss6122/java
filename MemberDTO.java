package view;

import javax.swing.JTextField;

public class MemberDTO {
	String id; // 매소드를 통해서 접근하도록.
	String pw;
	String name;
	String tel;
	String email;
	String adress;
	
	
	public String getId() { // 가져오기
		return id;
	}
	public void setId(String id) {// 보내기
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public void setId(JTextField tf1) {
		// TODO Auto-generated method stub
		
	}

	
	

}
