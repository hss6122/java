package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;



public class MemberDAO {
	String url="jdbc:mysql://localhost:3400/test"; //DB연결
	String user="root"; //DB id pw 설정
	String password="1234";
	String Driver = "com.mysql.jdbc.Driver";
	// 각 기능마다. 들어가는 절차를 줄일 수 있는 걸 줄인다.
	
	//▼전역 변수로 처리하여. 코드를 줄일 수 있다
	Connection con;  // 데이버베이스와 연결하는 객체
	PreparedStatement ps;//Statement 를 상속받는 인터페이스로 SQL구문을 실행시키는 객체
	ResultSet rs;
	// execteQuery 로 명령하면 ResultSet이라는 객체 를 돌려줌
	// 퀄리로 DB에 명령하면 ResultSet는 명령에 대한 반환값
//	1.회원가입
	public void insert(MemberDTO dto) {
			//▲ 입력창에서 가져온 값이 dto를 거쳐 온다.
		try {
			//1.1 DB 커넥터 설정.
			Class.forName(Driver);
			System.out.println("1.커넥터 설정 ok..");
			//1.2 DB연결 // 사전 빌드패스를 통해 외부 연결 부품이 탑재 선행.
			con = DriverManager.getConnection(url, user, password);
			System.out.println("2.DB연결 ok.....");
			//1.3 sql문 결정
			System.out.println("3.sql문 결정ok");
			String sql = "insert into signup values(?,?,?,?,?,?)";
			//▲ 삽입할 sql문. 
			 ps = con.prepareStatement(sql);
			// 위 메소드는  객체 생성시 지정된 sql명령어만 실행가능.
			ps.setString(1, dto.getId()); //1번 ?에 대입 
			ps.setString(2, dto.getPw());//2번 ?에 대립
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getEmail());
			ps.setString(5, dto.getTel());
			ps.setString(6, dto.getAdress());
			//1.4 sql문 전송
			ps.executeUpdate();// C,U,D
			System.out.println("4.sql문 전송");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {// 예외중에서도 꼭 실행해주세요
			try {//우리가 프로그래밍 하는 것은 memory에서 제어 하는 것임.
				// file은 hdd에 존재하는 것이므로 외부에 있는 자원이고 이 자원으 쓰려면 외부 자원 open해서 
				//메모리로 가지고 와야 하며 다 사용하고 나면 다시 연결을 해제 (close)를 해줘야함.
				//마찬가지로 Connection,ResultSet,PreparedStatement 도 외부 자원이므로 close해야함.
				con.close();
				ps.close();
				rs.close();
			} catch (Exception e2) {
			}
			}
			}
//	2.로그인
	public MemberDTO login(MemberDTO dto) {//리턴값이 있어야함
		MemberDTO dto2 = null;//가방을 비우는 초기화 후 메소드 시작.:
		try {
			//1.커낵터 설정
			Class.forName(Driver);
			System.out.println("login 메소드 실행");
			System.out.println("1.커넥터 설정 ok..");
			//2.DB연결
			con = DriverManager.getConnection(url, user, password);
			System.out.println("2.DB연결 ok.....");
			//3.sql문결정
			System.out.println("3.sql문 결정ok");
			String sql = "select id, pw from signup where id =? and pw =? ";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());// 물음표 1번 자리에 dto id값을 보낸다.
			ps.setString(2, dto.getPw());
			//4.sql문전송
			rs = ps.executeQuery();// rs 또한 DB에서 가져오는 DTO가 될 수 있음.
			System.out.println("4.sql문 전송");
			if (rs.next()) {// 검색결과가 있는지 ,체크if 있을때만 공간을 생성해주기.
				System.out.println("검색결과 있음.");
				dto2 = new MemberDTO();
				 String id = rs.getString(1);// id컬럼에서 검색
				 String pw = rs.getString(2);// pw컬럼에서 검색
				dto2.setId(id); // DTO에 값을 보낸다.
				dto2.setPw(pw);
			}
		} catch (Exception e) {
			e.printStackTrace();//예외값 프린트
		}finally {
			try {
			con.close();
			ps.close();
			rs.close();
			} catch (Exception e2) {
			}
			}
		return dto2;// 인스턴스된 DTO2로
			}
//	3. id중복확인
	public MemberDTO loginCheak(MemberDTO dto) {
		// △ 반환은 DTO에 한다. 입력값은 DTO클래스이다.
		MemberDTO dto2 = null;//가방을 비우는 초기화 후 메소드 시작.://쓰레기 값 초기화
		try {// Exception 발생시 괄호안은 무시하고 절차에 따라 실행한다
			//1.커낵터 설정
			Class.forName(Driver);
			System.out.println("1.커넥터 설정 ok..");
			//2.DB연결
			con = DriverManager.getConnection(url, user, password);
			System.out.println("2.DB연결 ok.....");
			//3.sql문결정
			System.out.println("3.sql문 결정ok");
			String sql = "select id from signup where id =? ";// signup 테이블에 id칼럼에  입력값 id를 검색하라
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			//4.sql문전송
			rs = ps.executeQuery();// rs 또한 DB에서 가져오는 DTO가 될 수 있음.
			System.out.println("4.sql문 전송");
			if (rs.next()) {// 해당 row가 있는지 체크
				System.out.println("검색결과 있음.");
				dto2 = new MemberDTO();// if 있을때만 공간을 생성해주기.
				 String id = rs.getString(1);
				dto2.setId(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				ps.close();
				rs.close();
			} catch (Exception e2) {
			}
			}
		return dto2;// 인스턴스된 DTO2로
			}
//	4.회원정보검색
	public MemberDTO CheckIf(MemberDTO dto) {// 패키지에 접근 가능 어래이 리스트 타입으로 가방은DTO 
		MemberDTO dto2 = null;
		//1.커낵터 설정
		//2 db연결
		//3 sql문 설정
		//4 sql 문 전송
		
		try {
			// 1 커넥터 설정
			System.out.println("회원정보검색 CheckIf DAO문 실행");
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1.커넥터 설정 ok..");
			// 2  DB연결
			 con = DriverManager.getConnection(url, user, password);
			System.out.println("2.DB연결 ok.....");
			// 3 sql문 결정
			String sql = "select * from signup where id =? ";
			 ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			System.out.println("3.sql문 결정 ok");
			// 4 sql문 전송
			 rs = ps.executeQuery();// CRUD R만 쿼리
			System.out.println("4.sql문 전송");
			while (rs.next()) {// 하나의 레코드 검색  결과가 있는지 체크해주는 메서드.
				// row의 위치를 나타내는 커서를 아래로 옮기면서 
				// 그 해당 row가 있는지 체크해주는 메소드
				// 있으면 true, 없으면 false!
				 String id = rs.getString(1);//id // db안.
				 String pw = rs.getString(2);//pw 컬럼
				 String name = rs.getString(3);// name컴럼
				 String email = rs.getString(4);
				 String tel = rs.getString(5);
				 String adress = rs.getString(6);
				 dto2 = new MemberDTO();//있을때만 공간을 생성해주기.
				 dto2.setId(id);
				 dto2.setPw(pw);
				 dto2.setName(name);
				 dto2.setEmail(email);
				 dto2.setTel(tel);
				 dto2.setAdress(adress);
			}
		} catch (Exception e) {//예외.  
			e.printStackTrace();
		}finally {
			try {
				con.close();
				ps.close();
				rs.close();
			} catch (Exception e2) {
			}
			}
		return dto2;
			}
	
//	5.회원탈퇴
	public int delete(MemberDTO dto) {//<
		System.out.println("회원탈퇴 처리하다.");
		int result = 0; //회원탈되  안된 경우
		try {// 
			// 1 커넥터 설정
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1.커넥터 설정 ok..");
			// 2  DB연결
			 con = DriverManager.getConnection(url, user, password);
			System.out.println("2.DB연결 ok.....");
			// 3 sql문 결정
			String sql = "delete from signup where id = ? && pw = ? ";
			 ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId()); //?를 받아줌.
			ps.setString(2, dto.getPw()); //?를 받아줌.
			// 전송 △
			System.out.println("3.sql문 결정 ok");
			// 4 sql문 전송
			result = ps.executeUpdate();
			System.out.println("삭제요청 결과는"+result);
			//반환값 1개는 1개의 회원정보 dto를 삭제했는지. 표기
			System.out.println("4.sql문 전송");
			if (result == 0) {
				JOptionPane.showMessageDialog(null, "비밀번호가 다릅니다");
			}else {
				JOptionPane.showMessageDialog(null, "회원탈퇴 되었습니다");
			}
		} catch (Exception e) {//예외.  
			e.printStackTrace();
		}finally {
			try {
				con.close();
				ps.close();
			} catch (Exception e2) {
			}
			}
			return result;
			}
//	6.회원정보수정
	public void Update(MemberDTO dto) {
		try {
			//DB 커넥터 설정
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1,커넥터 설정ok...");
			//DB연결
			con = DriverManager.getConnection(url, user, password);
			System.out.println("2.DB연결 ok.....");
			//sql문결정
			String sql = "update signup set pw =?, name =?,email=?,tel=?,adress=? where id =?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getPw()); //1번째 ?
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getEmail());
			ps.setString(4, dto.getTel());
			ps.setString(5, dto.getAdress());
			ps.setString(6, dto.getId()); //2번쩨?
			System.out.println("3.sql문 결정ok");
			//sql문 전송
			ps.executeUpdate();
			System.out.println("4.sql문 전송");
			
		} catch (Exception e) {
			e.printStackTrace();
			}finally {
				try {
					con.close();
					ps.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			}
}// 클레스
