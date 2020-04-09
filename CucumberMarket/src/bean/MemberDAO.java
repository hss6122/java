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
	
	
	
//	0.�����ڸ������ϱ�
	public void selection(PlaceMemberDTO dto) {
		System.out.println("ȸ������ ó���ϴ�.");
		try {
			con = mgr.getConnection();
			// 3 sql�� ����
			
			String no = dto.seatdayno;
			String ok = dto.seatok;
			
			String sql = "update member set column3 =? where column1 =?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, no);  // column3	DB�κи� 1���� �����ϴ� �ε�����. Ư�̻���.
			ps.setString(2, ok); //column1
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
	
	
	
	
	
	
	//��ü�˻��� �� ����. 
	public ArrayList<PlaceMemberDTO> list() {
		//(������� ��� dto���� ��� ����Ʈ�̴�)
		ArrayList<PlaceMemberDTO> list = new ArrayList<PlaceMemberDTO>();
		PlaceMemberDTO dto2 = null;// �ʱ�ȭ�� ����.
		try {// 
			con = mgr.getConnection();
			
			// 3 sql�� ����
			String sql = "select * from place";
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("3.sql�� ���� ok");
			
			// 4 sql�� ����
			ResultSet rs = ps.executeQuery();// CRUD R�� ����
			System.out.println("4.sql�� ����");
			
			while (rs.next()) {// �˻� ����� �ִ��� üũ���ִ� �޼���.
				System.out.println("�˻���� �־��!!");
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
				 dto2 = new PlaceMemberDTO();// if �������� ������ �������ֱ⿡ . ȿ�����̰� �մ���.
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
		} catch (Exception e) {//����.  
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;// Ʈ���� ������. list�� �ν��� �� ����.
		
	}
	
	
	
	
	public int idOver(MemberDTO dto) {//id�ߺ�üũ
		int result = 0; // ����
	 System.out.println("�α��� ó��");
	 	try {// 
	 		con = mgr.getConnection();
				// 3 sql�� ����
				String sql = "select id from member where id = ?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, dto.getId());
				
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
	public void update(MemberDTO dto) {
		System.out.println("ȸ������ ó���ϴ�.");
		try {
			con = mgr.getConnection();
			// 3 sql�� ����
			
			String tel = JOptionPane.showInputDialog("������  tel");
			String id = JOptionPane.showInputDialog("��� id>>");
			
			String sql = "update member set column3 =? where column1 =?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, tel);  // column3	DB�κи� 1���� �����ϴ� �ε�����. Ư�̻���.
			ps.setString(2, id); //column1
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
