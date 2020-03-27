package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class MemberDAO { //�޼��� ������ ����.
	String url="jdbc:mysql://localhost:3400/virus";
	String user="root";
	String password="1234";
	
	//4.�˻��� �� ����. 
	public MemberDTO select(MemberDTO dto) {
		MemberDTO dto2 = null;// �ʱ�ȭ�� ����.
		
		try {// 
			// 1 Ŀ���� ����
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1.Ŀ���� ���� ok..");
			
			// 2  DB����
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2.DB���� ok.....");
			
			// 3 sql�� ����
			String sql = "select * from member where id =? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());  
			// ���� ��
			System.out.println("3.sql�� ���� ok");
			
			// 4 sql�� ����
			ResultSet rs = ps.executeQuery();// CRUD R�� ����
			
			System.out.println("4.sql�� ����");
			if (rs.next()) {// �˻� ����� �ִ��� üũ���ִ� �޼���.
				System.out.println("�˻���� �־��!!");
				 dto2 = new MemberDTO();// if �������� ������ �������ֱ⿡ . ȿ�����̰� �մ���.
				 String id = rs.getString(1);//id
				 dto2.setId(id);
			}
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
			// 1 Ŀ���� ����
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1.Ŀ���� ���� ok..");
			
			// 2  DB����
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2.DB���� ok.....");
			
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
			// 1 Ŀ���� ����
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1.Ŀ���� ���� ok..");
			
			// 2  DB����
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2.DB���� ok.....");
			
			// 3 sql�� ����
//			String id = JOptionPane.showInputDialog("������ id");
//			String pw = JOptionPane.showInputDialog("������ pw");
//			String name = JOptionPane.showInputDialog("������ name");
//			String tel = JOptionPane.showInputDialog("������ tel");
			
			String sql = "insert into member values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());  
			ps.setString(2, dto.getId());
			ps.setString(3, dto.getPw());
			ps.setString(4, dto.get
			ps.setString(4, dto.getTel());
			// ���� ��
			System.out.println("3.sql�� ���� ok");
			
			// 4 sql�� ����
			ps.executeUpdate();
			System.out.println("4.sql�� ����");
			
			
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
				// 1 Ŀ���� ����
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("1.Ŀ���� ���� ok..");
				
				// 2  DB����
				Connection con =DriverManager.getConnection(url, user, password);
				System.out.println("2.DB���� ok.....");
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
			// 1 Ŀ���� ����
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1.Ŀ���� ���� ok..");
			
			// 2  DB����
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2.DB���� ok.....");
			
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
			
		} catch (Exception e) {//����.  
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return result;
	}
	
}// Ŭ����
