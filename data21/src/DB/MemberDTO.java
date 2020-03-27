package DB;

public class MemberDTO {
	String id; // 매소드를 통해서 접근하도록.
	String pw;
	String name;
	String tel;
	
//	---------------------------------------------
	public String getId() { //가져올때
		return id;
	}
	public void setId(String id) { //쓸때.
		this.id = id;
	}
//	-------------------------------------------
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
//	--------------------------------------
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	----------------------------------------
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override//덮어쓰기
	public String toString() {
		return "MemberDTO [id=" + id + ", pw=" + pw + ", name=" + name + ", tel=" + tel + "]";
	}
	
	

}
