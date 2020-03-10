package view;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.locks.Condition;

import javax.swing.JOptionPane;

public class ControlBox {//메서드 단위
	//1. Db에 주소값 id pw를 넣어 연결한다.
	String url="jdbc:mysql://localhost:3400/test";
	String user="root";
	String password="1234";
	
	
	//startview 시작화면. (로그인 , 시작화면에서 팝업으로 회원가입)
	public void login(String id, String pw)  {
		System.out.println("시작화면");
		//트라이 캐치  및 연결
					try {
						//1 커넥터 설정 // DB상태 체크, java 경로문 체크
						Class.forName("com.mysql.jdbc.Driver");
						System.out.println("1.커넥터 설정 ok");
						
						//2.DB연결
						Connection con = DriverManager.getConnection(url, user, password);
						System.out.println("2.DB연결 ok....");
						
						//3.sql문 결정 // and 연산자 사용
						String sql ="select * from signup where id = ? and pw = ? ";
						PreparedStatement ps = con.prepareStatement(sql);
						ps.setString(1, id);//DB인덱스는  1부터임 ?를 받아줌.
						ps.setString(2, pw);
							
						System.out.println("3.sql문 결정ok");
						
						//4.sql문 전송
						ps.executeQuery();
						// select 쿼리를 날릴 때는  executeQuery()함수를 사용
						// 왜냐하면 결과 값을 받아와야 하기 때문에.
//					executeUpdate(); <<-insert,update,delete 쿼리를 날릴때 쓰는 함수
						System.out.println("4.sql문 전송");
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				
			} //보이드 login
			
		
	// signup 회원가입.
	public void insert(String id,String pw,String name,String email,String tel,String adress) {
		// 넣을 타입과 값 기입.
		try {
			System.out.println("회원가입처리ok");
			//1 커넥터 설정
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1.커넥터 설정 ok..");
			//2 DB에 연결
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2.DB연결 ok.....");
			//3 sql문 결정
			String sql = "insert into signup values(?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);  // DB부분만 1부터 시작하는 인덱스임. 특이사항.
			ps.setString(2, pw);
			ps.setString(3, name);
			ps.setString(4, email);
			ps.setString(5, tel);
			ps.setString(6, adress);
			System.out.println("3.sql문 결정 ok");
			//4 sql문 전송
			ps.executeUpdate();
			System.out.println("4.sql문 전송");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	
	
	
	
	

		}//클래스
	

	
	
	//memberif회원정보수정
	
	

