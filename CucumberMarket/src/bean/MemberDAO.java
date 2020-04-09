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
	
	
	
//	0.장터자리예약하기
	public void selection(PlaceMemberDTO dto) {
		System.out.println("회원수정 처리하다.");
		try {
			con = mgr.getConnection();
			// 3 sql문 결정
			
			String no = dto.seatdayno;
			String ok = dto.seatok;
			
			String sql = "update member set column3 =? where column1 =?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, no);  // column3	DB부분만 1부터 시작하는 인덱스임. 특이사항.
			ps.setString(2, ok); //column1
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
	
	
	
	
	
	
	//전체검색을 할 예정. 
	public ArrayList<PlaceMemberDTO> list() {
		//(결과값은 멤머 dto가들어간 어래이 리스트이다)
		ArrayList<PlaceMemberDTO> list = new ArrayList<PlaceMemberDTO>();
		PlaceMemberDTO dto2 = null;// 초기화를 해줌.
		try {// 
			con = mgr.getConnection();
			
			// 3 sql문 결정
			String sql = "select * from place";
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("3.sql문 결정 ok");
			
			// 4 sql문 전송
			ResultSet rs = ps.executeQuery();// CRUD R만 쿼리
			System.out.println("4.sql문 전송");
			
			while (rs.next()) {// 검색 결과가 있는지 체크해주는 메서드.
				System.out.println("검색결과 있어요!!");
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
				 String seatok = rs.getString(11);//id
				 dto2 = new PlaceMemberDTO();// if 있을때만 공간을 생성해주기에 . 효율적이고 합당함.
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
				 dto2.setSeatok(seatok);
				 list.add(dto2);
			}
			mgr.freeConnection(con, ps, rs);
		} catch (Exception e) {//예외.  
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;// 트라이 밖으로. list를 인식할 수 있음.
		
	}
	
	
	
	
	public int idOver(MemberDTO dto) {//id중복체크
		int result = 0; // 없다
	 System.out.println("로그인 처리");
	 	try {// 
	 		con = mgr.getConnection();
				// 3 sql문 결정
				String sql = "select id from member where id = ?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, dto.getId());
				
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
	public void update(MemberDTO dto) {
		System.out.println("회원수정 처리하다.");
		try {
			con = mgr.getConnection();
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
			mgr.freeConnection(con, ps);
			
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
