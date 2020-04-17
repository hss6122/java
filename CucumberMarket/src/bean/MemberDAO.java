package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class MemberDAO { //�޼��� ������ ����.
	Connection con;
	DBConnectionMgr mgr;
	public MemberDAO() {
		 mgr = DBConnectionMgr.getInstance();
	}
	public ArrayList<String> seatcheck() {
		ArrayList<String> list = new ArrayList<String>();
		try { 
			con = mgr.getConnection();
			// 3 sql�� ����
			String sql = "select * from place ";
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("3.sql�� ���� ok");
			
			// 4 sql�� ����
			ResultSet rs = ps.executeQuery();// CRUD R�� ����
			
			System.out.println("4.sql�� ����");
			if (rs.next()) {// �˻� ����� �ִ��� üũ���ִ� �޼���.
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
						 
				 
				 System.out.println("�˻���� �־��!!");
			
			}
			mgr.freeConnection(con, ps);
			
		} catch (Exception e) {//����.  
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	

	//��ü�˻��� �� ���� �׽�Ʈ 
	public ArrayList< PlaceMemberDTO2_test> list1() {
	ArrayList<PlaceMemberDTO2_test> list = new ArrayList<PlaceMemberDTO2_test>();
		try {// 
			con = mgr.getConnection();
			
			// 3 sql�� ����
			String sql = "select * from place_1";
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("3.sql�� ���� ok");
			
			// 4 sql�� ����
			ResultSet rs = ps.executeQuery();// CRUD R�� ����
			System.out.println("4.sql�� ����");
			
			while (rs.next()) {// �˻� ����� �ִ��� üũ���ִ� �޼���.
				System.out.println("�˻���� �־��!!");
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
		} catch (Exception e) {//����.  
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;// Ʈ���� ������. list�� �ν��� �� ����.
		
	}
	
	
	
	
	
	//��ü�˻��� �� ����. 
	public ArrayList<PlaceMemberDTO2_test> list() {
		//(������� ��� dto���� ��� ����Ʈ�̴�)
		ArrayList<PlaceMemberDTO2_test> list = new ArrayList<PlaceMemberDTO2_test>();
		PlaceMemberDTO2_test dto2 = null;// �ʱ�ȭ�� ����.
		try {// 
			con = mgr.getConnection();
			
			// 3 sql�� ����
			String sql = "select * from place_1";
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("3.sql�� ���� ok");
			
			// 4 sql�� ����
			ResultSet rs = ps.executeQuery();// CRUD R�� ����
			System.out.println("4.sql�� ����");
			
			while (rs.next()) {// �˻� ����� �ִ��� üũ���ִ� �޼���.
				System.out.println("�˻���� �־��!!");
				 String id = rs.getString(1);//id
				 String seatnum = rs.getString(2);//id
				 dto2 = new PlaceMemberDTO2_test();// if �������� ������ �������ֱ⿡ . ȿ�����̰� �մ���.
				 dto2.setId(id);
				 dto2.setSeatnum(seatnum);
				 list.add(dto2);
			}
			mgr.freeConnection(con, ps, rs);
		} catch (Exception e) {//����.  
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;// Ʈ���� ������. list�� �ν��� �� ����.
		
	}
	
	
	
	
	public int sellplacecheck( String id) {//id�ߺ�üũ
		int result = 0; // ����
	 System.out.println("member���̺� sellplace�� �˻�");
	 	try {// 
	 		con = mgr.getConnection();
				// 3 sql�� ����
				String sql = "select sellplace from member where id = ?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, id);
				
				// 4 sql�� ����
				ResultSet rs = ps.executeQuery();
				System.out.println("4.spl�� ����");
				
				if (rs.next()) {
					System.out.println("�˻��������");
					result = 1;
				}
				mgr.freeConnection(con, ps, rs);
			} catch (Exception e) {//����.  
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 	return result;
	}
	
	
	//4.�˻��� �� ����. 
	public PlaceMemberDTO select(PlaceMemberDTO dto) {
		PlaceMemberDTO dto2 = null;// �ʱ�ȭ�� ����.
		
		try { 
			con = mgr.getConnection();
			// 3 sql�� ����
			String sql = "select * from place where id =? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());  
			System.out.println("3.sql�� ���� ok");
			
			
			// 4 sql�� ����
			ResultSet rs = ps.executeQuery();// CRUD R�� ����
			
			System.out.println("4.sql�� ����");
			if (rs.next()) {// �˻� ����� �ִ��� üũ���ִ� �޼���.
				 dto2 = new PlaceMemberDTO();// if �������� ������ �������ֱ⿡ . ȿ�����̰� �մ���.
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
				 System.out.println("�˻���� �־��!!");
			
			}
			mgr.freeConnection(con, ps);
			
		} catch (Exception e) {//����.  
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto2;// Ʈ���� ������. dto2�� �ν��� �� ����.
	}
	
	
	
//	0.ȸ����������
	public MemberDTO update( MemberDTO dto) {
		MemberDTO dto2 = null;
		System.out.println("������ ����ϴ�");
		try {
			con = mgr.getConnection();
			
			// 3 sql�� ����
			String sql = "update place set ? = '0'  where ?  = ? ";
			// �Ѿ�� id����  1������ ��ü �˻� �� �����ÿ�  0���� ����.
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId()); //?�� �޾���.
			// ���� ��
			System.out.println("3.sql�� ���� ok");
			
			// 4 sql�� ����
			ps.executeUpdate();
			System.out.println("4.sql�� ����");
			mgr.freeConnection(con, ps);
			
		} catch (Exception e) {//����.  
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto2;
	}
	
	

	



	//1. ȸ������
	public void insert(MemberDTO dto) {
		//�Ű�����(�Ķ����,parameter �������� 
		System.out.println("ȸ������ó���ϴ�.");
		try {// 
			con = mgr.getConnection();
			// 3 sql�� ����
//			String id = JOptionPane.showInputDialog("������ id");
//			String pw = JOptionPane.showInputDialog("������ pw");
//			String name = JOptionPane.showInputDialog("������ name");
//			String tel = JOptionPane.showInputDialog("������ tel");
			
			String sql = "insert into member values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(2, dto.getId());
			ps.setString(3, dto.getPw());
			ps.setString(4, dto.getTel());
			// ���� ��
			System.out.println("3.sql�� ���� ok");
			
			// 4 sql�� ����
			ps.executeUpdate();
			System.out.println("4.sql�� ����");
			mgr.freeConnection(con, ps);
			
		} catch (Exception e) {//����.  
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
//2. DB����
	public int idCheck(MemberDTO dto) {
		int result = 0; // ����
	 System.out.println("�α��� ó��");
	 	try {// 
	 		con = mgr.getConnection();
				// 3 sql�� ����
				String sql = "select * from member where id = ? and pw = ?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, dto.getId());
				ps.setString(2, dto.getPw());
				
				// 4 sql�� ����
				ResultSet rs = ps.executeQuery();
				System.out.println("4.spl�� ����");
				if (rs.next()) {
					System.out.println("�˻��������");
					result = 1;
				}
				mgr.freeConnection(con, ps);
				
			} catch (Exception e) {//����.  
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 	return result;
	}
	
//3. ȸ��Ż��
	public int delete(MemberDTO dto) {//<
		System.out.println("ȸ��Ż�� ó���ϴ�.");
		int result = 0; //ȸ��Ż��  �ȵ� ���
		try {// 
			
			// 3 sql�� ����
			String sql = "delete from member where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId()); //?�� �޾���.
			
			// ���� ��
			System.out.println("3.sql�� ���� ok");
			
			// 4 sql�� ����
			result = ps.executeUpdate();
			
			System.out.println("������û �����"+result);
			//��ȯ�� 1���� 1���� ȸ������ dto�� �����ߴ���. ǥ��
			System.out.println("4.sql�� ����");
			mgr.freeConnection(con, ps);
		} catch (Exception e) {//����.  
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return result;
	}
	
}// Ŭ����
