package member;

public class Member {

	private String name = "황신";
	private String id = "hss5122";
	private String pw= "1234";
	private String brday = "8월24일";
	private String gneder ="남";
	private String adress = "서울시";
	private String tel = "010-3434-5555";

public void Member1() {
	
}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getBrday() {
		return brday;
	}

	public void setBrday(String brday) {
		this.brday = brday;
	}

	public String getGneder() {
		return gneder;
	}

	public void setGneder(String gneder) {
		this.gneder = gneder;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	
	@Override
	public String toString() {
		return "Member [name=" + name + ", id=" + id + ", pw=" + pw + ", brday=" + brday + ", gneder=" + gneder
				+ ", adress=" + adress + ", tel=" + tel + "]";
	}

}
