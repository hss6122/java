package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class MemberDAO { //메서드 단위로 만듬.
	Connection con;
	DBConnectionMgr mgr;
	public MemberDAO() {
		 mgr = DBConnectionMgr.getInstance();
	}
	public ArrayList<String> seatcheck() {
		ArrayList<String> list = new ArrayList<String>();
		try { 
			con = mgr.getConnection();
			// 3 sql문 결정
			String sql = "select * from place ";
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("3.sql문 결정 ok");
			
			// 4 sql문 전송
			ResultSet rs = ps.executeQuery();// CRUD R만 쿼리
			
			System.out.println("4.sql문 전송");
			if (rs.next()) {// 검색 결과가 있는지 체크해주는 메서드.
				 String date = rs.getString(1);//id
				 String num1 = rs.getString(2);//id
				 String num2 = rs.getString(3);//id
				 String num3 = rs.getString(4);//id
				 String num4 = rs.getString(5);//id
				 String num5 = rs.getString(6);//id
				 String num6 = rs.getString(7);//id
				 String num7 = rs.getString(8);//id
				 String num8 = rs.getString(9);//id
				 String num9 = rs.getString(10);//id
				 String num10 = rs.getString(11);//id
				 String num11 = rs.getString(12);//id
				 String num12 = rs.getString(13);//id
				 String num13 = rs.getString(14);//id
				 String num14 = rs.getString(15);//id
				 String num15 = rs.getString(16);//id
				 String num16 = rs.getString(17);//id
				 String num17 = rs.getString(18);//id
				 String num18 = rs.getString(19);//id
				 String num19 = rs.getString(20);//id
				 String num20 = rs.getString(21);//id
				 list.add(date+"#"+num1+"#"+num2+"#"+num3+"#"+num4+"#"+num5+"#"+num6
						 +"#"+num7+"#"+num8+"#"+num9+"#"+num10+"#"+
						 num11+"#"+num12+"#"+num13+"#"+num14+"#"+num15+"#"+num16
						 +"#"+num17+"#"+num18+"#"+num19+"#"+num20);
						 
				 
				 System.out.println("검색결과 있어요!!");
			
			}
			mgr.freeConnection(con, ps);
			
		} catch (Exception e) {//예외.  
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	

	//전체검색을 할 예정 테스트 
	public ArrayList< PlaceMemberDTO2_test> list1() {
	ArrayList<PlaceMemberDTO2_test> list = new ArrayList<PlaceMemberDTO2_test>();
		try {// 
			con = mgr.getConnection();
			
			// 3 sql문 결정
			String sql = "select * from place_1";
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("3.sql문 결정 ok");
			
			// 4 sql문 전송
			ResultSet rs = ps.executeQuery();// CRUD R만 쿼리
			System.out.println("4.sql문 전송");
			
			while (rs.next()) {// 검색 결과가 있는지 체크해주는 메서드.
				System.out.println("검색결과 있어요!!");
				 String id = rs.getString(1);
				 String seatnum = rs.getString(2);
				 String seatnumber = rs.getString(3);
				 PlaceMemberDTO2_test dto = new PlaceMemberDTO2_test();
				 dto.setId(id);
				 dto.setSeatnum(seatnum);
				 dto.setSeatnumber(seatnumber);
				 list.add(dto);
			}
			mgr.freeConnection(con, ps, rs);
		} catch (Exception e) {//예외.  
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;// 트라이 밖으로. list를 인식할 수 있음.
		
	}
	
	
	
	
	
	//전체검색을 할 예정. 
	public ArrayList<PlaceMemberDTO2_test> list() {
		//(결과값은 멤머 dto가들어간 어래이 리스트이다)
		ArrayList<PlaceMemberDTO2_test> list = new ArrayList<PlaceMemberDTO2_test>();
		PlaceMemberDTO2_test dto2 = null;// 초기화를 해줌.
		try {// 
			con = mgr.getConnection();
			
			// 3 sql문 결정
			String sql = "select * from place_1";
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("3.sql문 결정 ok");
			
			// 4 sql문 전송
			ResultSet rs = ps.executeQuery();// CRUD R만 쿼리
			System.out.println("4.sql문 전송");
			
			while (rs.next()) {// 검색 결과가 있는지 체크해주는 메서드.
				System.out.println("검색결과 있어요!!");
				 String id = rs.getString(1);//id
				 String seatnum = rs.getString(2);//id
				 dto2 = new PlaceMemberDTO2_test();// if 있을때만 공간을 생성해주기에 . 효율적이고 합당함.
				 dto2.setId(id);
				 dto2.setSeatnum(seatnum);
				 list.add(dto2);
			}
			mgr.freeConnection(con, ps, rs);
		} catch (Exception e) {//예외.  
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;// 트라이 밖으로. list를 인식할 수 있음.
		
	}
	
	
	
	
	public int sellplacecheck( String id) {//id중복체크
		int result = 0; // 없다
	 System.out.println("member테이블에 sellplace를 검색");
	 	try {// 
	 		con = mgr.getConnection();
				// 3 sql문 결정
				String sql = "select sellplace from member where id = ?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, id);
				
				// 4 sql문 전송
				ResultSet rs = ps.executeQuery();
				System.out.println("4.spl문 전송");
				
				if (rs.next()) {
					System.out.println("검색결과있음");
					result = 1;
				}
				mgr.freeConnection(con, ps, rs);
			} catch (Exception e) {//예외.  
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 	return result;
	}
	
	
	//4.검색을 할 예정. 
	public PlaceMemberDTO select(PlaceMemberDTO dto) {
		PlaceMemberDTO dto2 = null;// 초기화를 해줌.
		
		try { 
			con = mgr.getConnection();
			// 3 sql문 결정
			String sql = "select * from place where id =? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());  
			System.out.println("3.sql문 결정 ok");
			
			
			// 4 sql문 전송
			ResultSet rs = ps.executeQuery();// CRUD R만 쿼리
			
			System.out.println("4.sql문 전송");
			if (rs.next()) {// 검색 결과가 있는지 체크해주는 메서드.
				 dto2 = new PlaceMemberDTO();// if 있을때만 공간을 생성해주기에 . 효율적이고 합당함.
				 String id = rs.getString(1);//id
				 String seatdayno = rs.getString(2);//id
				 String title = rs.getString(3);//id
				 String category = rs.getString(4);//id
				 String price = rs.getString(5);//id
				 String contents = rs.getString(6);//id
				 String photo = rs.getString(7);//id
				 String sale = rs.getString(8);//id
				 String itemnum = rs.getString(9);//id
				 String itemcode = rs.getString(10);//id
				 dto2.setId(id);
				 dto2.setSeatdayno(seatdayno);
				 dto2.setTitle(title);
				 dto2.setCategory(category);
				 dto2.setPrice(price);
				 dto2.setContents(contents);
				 dto2.setPhoto(photo);
				 dto2.setSale(sale);
				 dto2.setItemnum(itemnum);
				 dto2.setItemcode(itemcode);
				 System.out.println("검색결과 있어요!!");
			
			}
			mgr.freeConnection(con, ps);
			
		} catch (Exception e) {//예외.  
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto2;// 트라이 밖으로. dto2를 인식할 수 있음.
	}
	
	
	
//	0.회원정보수정
	public MemberDTO update( MemberDTO dto) {
		MemberDTO dto2 = null;
		System.out.println("예약을 취소하다");
		try {
			con = mgr.getConnection();
			
			// 3 sql문 결정
			String sql = "update place set ? = '0'  where ?  = ? ";
			// 넘어온 id값을  1번행을 전체 검색 후 있을시에  0으로 수정.
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId()); //?를 받아줌.
			// 전송 △
			System.out.println("3.sql문 결정 ok");
			
			// 4 sql문 전송
			ps.executeUpdate();
			System.out.println("4.sql문 전송");
			mgr.freeConnection(con, ps);
			
		} catch (Exception e) {//예외.  
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto2;
	}
	
	

	



	//1. 회원가입
	public void insert(MemberDTO dto) {
		//매개변수(파라메터,parameter 지역변수 
		System.out.println("회원가입처리하다.");
		try {// 
			con = mgr.getConnection();
			// 3 sql문 결정
//			String id = JOptionPane.showInputDialog("삽입할 id");
//			String pw = JOptionPane.showInputDialog("삽입할 pw");
//			String name = JOptionPane.showInputDialog("삽입할 name");
//			String tel = JOptionPane.showInputDialog("삽입할 tel");
			
			String sql = "insert into member values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(2, dto.getId());
			ps.setString(3, dto.getPw());
			ps.setString(4, dto.getTel());
			// 전송 △
			System.out.println("3.sql문 결정 ok");
			
			// 4 sql문 전송
			ps.executeUpdate();
			System.out.println("4.sql문 전송");
			mgr.freeConnection(con, ps);
			
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
	 		con = mgr.getConnection();
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
				mgr.freeConnection(con, ps);
				
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
			mgr.freeConnection(con, ps);
		} catch (Exception e) {//예외.  
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return result;
	}
	
}// 클래스
