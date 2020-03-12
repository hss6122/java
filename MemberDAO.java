package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
	String url="jdbc:mysql://localhost:3400/test"; //DB연결
	String user="root"; //DB id pw 설정
	String password="1234";
	String Driver = "com.mysql.jdbc.Driver";
	// 각 기능마다. 들어가는 절차를 줄일 수 있는 걸 줄인다.
	
			//DB에 사용할 기능 선언 CRUD
	
			//1. C 생성 회원가입
	public void insert(MemberDTO dto) {
			//▲ 입력창에서 가져온 값이 dto를 거쳐 온다.
			//  아래 절차를 거쳐. DB에 입력된다.
		try {
			//1.1 DB 커넥터 설정.
			Class.forName(Driver);
			System.out.println("1.커넥터 설정 ok..");
			//1.2 DB연결 // 사전 빌드패스를 통해 외부 연결 부품이 탑ㄴ재 선행.
			
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2.DB연결 ok.....");
			//1.3 sql문 결정
			
			System.out.println("3.sql문 결정ok");
			String sql = "insert into signup values(?,?,?,?,?,?)";
			//▲ 삽입할 sql문. 
			PreparedStatement ps = con.prepareStatement(sql);
			// 위 메소드는  객체 생성시 지정된 sql명령어만 실행가능.
			ps.setString(1, dto.getId());  
			ps.setString(2, dto.getPw());
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getEmail());
			ps.setString(5, dto.getTel());
			ps.setString(6, dto.getAdress());
			
			//1.4 sql문 전송
			ps.executeUpdate();
			System.out.println("4.sql문 전송");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	//2. r 읽기 로그인
	public MemberDTO login(MemberDTO dto) {
		MemberDTO dto2 = null;//가방을 비우는 초기화 후 메소드 시작.:
		try {
			//1.커낵터 설정
			Class.forName(Driver);
			System.out.println("1.커넥터 설정 ok..");
			//2.DB연결
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2.DB연결 ok.....");
			//3.sql문결정
			System.out.println("3.sql문 결정ok");
			
			String sql = "select id, pw from signup where id =? and pw =? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPw());
			
			//4.sql문전송
			ResultSet rs = ps.executeQuery();// rs 또한 DB에서 가져오는 DTO가 될 수 있음.
			System.out.println("4.sql문 전송");
			if (rs.next()) {// 검색결과가 있는지 체크
				System.out.println("검색결과 있음.");
				dto2 = new MemberDTO();// if 있을때만 공간을 생성해주기.
				 String id = rs.getString(1);
				 String pw = rs.getString(2);
				dto2.setId(id);
				dto2.setPw(pw);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto2;// 인스턴스된 DTO2로
	}
	
	
	//3.signup id중복확인
	public MemberDTO loginCheak(MemberDTO dto) {
		MemberDTO dto2 = null;//가방을 비우는 초기화 후 메소드 시작.:
		try {
			//1.커낵터 설정
			Class.forName(Driver);
			System.out.println("1.커넥터 설정 ok..");
			//2.DB연결
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2.DB연결 ok.....");
			//3.sql문결정
			System.out.println("3.sql문 결정ok");
			String sql = "select id, pw from signup where id =? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			//4.sql문전송
			ResultSet rs = ps.executeQuery();// rs 또한 DB에서 가져오는 DTO가 될 수 있음.
			System.out.println("4.sql문 전송");
			if (rs.next()) {// 해당 row가 있는지 체크
				System.out.println("검색결과 있음.");
				dto2 = new MemberDTO();// if 있을때만 공간을 생성해주기.
				 String id = rs.getString(1);
				dto2.setId(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto2;// 인스턴스된 DTO2로
	}
	
	
	
	
	
	//3. u 회원정보수정
	//4. d 회원정보삭제
}
