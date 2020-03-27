package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class MemberDAO { //메서드 단위로 만듬.
	String url="jdbc:mysql://localhost:3400/virus";
	String user="root";
	String password="1234";
	
	//4.검색을 할 예정. 
	public MemberDTO select(MemberDTO dto) {
		MemberDTO dto2 = null;// 초기화를 해줌.
		
		try {// 
			// 1 커넥터 설정
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1.커넥터 설정 ok..");
			
			// 2  DB연결
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2.DB연결 ok.....");
			
			// 3 sql문 결정
			String sql = "select * from member where id =? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());  
			// 전송 △
			System.out.println("3.sql문 결정 ok");
			
			// 4 sql문 전송
			ResultSet rs = ps.executeQuery();// CRUD R만 쿼리
			
			System.out.println("4.sql문 전송");
			if (rs.next()) {// 검색 결과가 있는지 체크해주는 메서드.
				System.out.println("검색결과 있어요!!");
				 dto2 = new MemberDTO();// if 있을때만 공간을 생성해주기에 . 효율적이고 합당함.
				 String id = rs.getString(1);//id
				 dto2.setId(id);
			}
		} catch (Exception e) {//예외.  
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto2;// 트라이 밖으로. dto2를 인식할 수 있음.
	}
	
	
	
//	0.회원정보수정
	public void update(MemberDTO dto) {
		System.out.println("회원수정 처리하다.");
		try {
			// 1 커넥터 설정
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1.커넥터 설정 ok..");
			
			// 2  DB연결
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2.DB연결 ok.....");
			
			// 3 sql문 결정
			
			String tel = JOptionPane.showInputDialog("수정할  tel");
			String id = JOptionPane.showInputDialog("대상 id>>");
			
			String sql = "update member set column3 =? where column1 =?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, tel);  // column3	DB부분만 1부터 시작하는 인덱스임. 특이사항.
			ps.setString(2, id); //column1
			// 전송 △
			System.out.println("3.sql문 결정 ok");
			
			// 4 sql문 전송
			ps.executeUpdate();
			System.out.println("4.sql문 전송");
			
			
		} catch (Exception e) {//예외.  
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
//1. 회원가입
	public void insert(MemberDTO dto) {
		//매개변수(파라메터,parameter 지역변수 
		System.out.println("회원가입처리하다.");
		try {// 
			// 1 커넥터 설정
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1.커넥터 설정 ok..");
			
			// 2  DB연결
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2.DB연결 ok.....");
			
			// 3 sql문 결정
//			String id = JOptionPane.showInputDialog("삽입할 id");
//			String pw = JOptionPane.showInputDialog("삽입할 pw");
//			String name = JOptionPane.showInputDialog("삽입할 name");
//			String tel = JOptionPane.showInputDialog("삽입할 tel");
			
			String sql = "insert into member values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());  
			ps.setString(2, dto.getId());
			ps.setString(3, dto.getPw());
			ps.setString(4, dto.get
			ps.setString(4, dto.getTel());
			// 전송 △
			System.out.println("3.sql문 결정 ok");
			
			// 4 sql문 전송
			ps.executeUpdate();
			System.out.println("4.sql문 전송");
			
			
		} catch (Exception e) {//예외.  
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
//2. DB연결
	public int idCheck(MemberDTO dto) {
		int result = 0; // 없다
	 System.out.println("로그인 처리");
	 	try {// 
				// 1 커넥터 설정
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("1.커넥터 설정 ok..");
				
				// 2  DB연결
				Connection con =DriverManager.getConnection(url, user, password);
				System.out.println("2.DB연결 ok.....");
				// 3 sql문 결정
				String sql = "select * from member where id = ? and pw = ?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, dto.getId());
				ps.setString(2, dto.getPw());
				
				// 4 sql문 전송
				ResultSet rs = ps.executeQuery();
				System.out.println("4.spl문 전송");
				
				if (rs.next()) {
					System.out.println("검색결과있음");
					result = 1;
				}
				
			} catch (Exception e) {//예외.  
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 	return result;
	}
//3. 회원탈퇴
	public int delete(MemberDTO dto) {//<
		System.out.println("회원탈퇴 처리하다.");
		int result = 0; //회원탈되  안된 경우
		try {// 
			// 1 커넥터 설정
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1.커넥터 설정 ok..");
			
			// 2  DB연결
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2.DB연결 ok.....");
			
			// 3 sql문 결정
			String sql = "delete from member where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId()); //?를 받아줌.
			
			// 전송 △
			System.out.println("3.sql문 결정 ok");
			
			// 4 sql문 전송
			result = ps.executeUpdate();
			
			System.out.println("삭제요청 결과는"+result);
			//반환값 1개는 1개의 회원정보 dto를 삭제했는지. 표기
			System.out.println("4.sql문 전송");
			
		} catch (Exception e) {//예외.  
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return result;
	}
	
}// 클래스
