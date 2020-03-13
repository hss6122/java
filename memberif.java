package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class memberif {
	private static JTextField tf1;
	private static JTextField tf2;
	private static JTextField tf3;
	private static JTextField tf4;
	private static JTextField tf5;
	private static JTextField tf6;
//회원정보수정창
//로그인에 성공한 id로 우선 스키마를 띄어온다.
	/**
	 * @wbp.parser.entryPoint
	 */
	
//	public static void main(String[] args) {// 본창만 테이트하고 싶을시 살리기
//		new memberif();
//	}
	
	
	
	public void MemberIf() {
		
		JFrame f = new JFrame();
		f.setSize(500, 500);
		f.getContentPane().setLayout(null);
		
		JLabel 회원정보수정 = new JLabel("회원정보수정");
		회원정보수정.setBounds(12, 10, 87, 31);
		f.getContentPane().add(회원정보수정);
		
		tf1 = new JTextField(); // 아이디
		tf1.setBounds(201, 102, 116, 21);
		f.getContentPane().add(tf1);
		tf1.setColumns(10);
		tf2 = new JTextField(); // 비번
		tf2.setColumns(10);
		tf2.setBounds(201, 133, 116, 21); 
		f.getContentPane().add(tf2);
		tf3 = new JTextField();//이름
		tf3.setColumns(10);
		tf3.setBounds(201, 164, 116, 21); 
		f.getContentPane().add(tf3);
		tf4 = new JTextField();//이메일
		tf4.setColumns(10);
		tf4.setBounds(201, 195, 116, 21); 
		f.getContentPane().add(tf4);
		tf5 = new JTextField();//전화번호
		tf5.setColumns(10);
		tf5.setBounds(201, 226, 116, 21);
		f.getContentPane().add(tf5);
		tf6 = new JTextField(); // 주소
		tf6.setColumns(10);
		tf6.setBounds(201, 257, 116, 21);
		f.getContentPane().add(tf6);
		
		JButton 수정완료 = new JButton("수정완료");
		수정완료.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = tf1.getText();
				String pw = tf2.getText();
				if (tf2.getText().trim().length()==0) {
					JOptionPane.showInputDialog(null, "변경할 패스워드 입력");
				}else {
					
				}
				
//				String name = tf3.getText();
//				String tel = tf4.getText();
//				String email = tf5.getText();
//				String adress = tf6.getText();
				
					MemberDTO dto = new MemberDTO();
				//가방을 만든다,
					dto.setId(id);
					dto.setPw(pw);
//					dto.setName(name);
//					dto.setTel(tel);
//					dto.setEmail(email);
//					dto.setAdress(adress);
				//가방에 넣는다.
					MemberDAO db = new MemberDAO();
				//가방을 전달한다.
					db.Update(dto);
				//가방을 꺼낸다.
			}
		});
		수정완료.setBounds(95, 306, 97, 23);
		f.getContentPane().add(수정완료);
		JButton 탈퇴 = new JButton("탈퇴");
		탈퇴.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		탈퇴.setBounds(220, 306, 97, 23);
		f.getContentPane().add(탈퇴);
		JLabel 아이디 = new JLabel("아이디");
		아이디.setBounds(108, 105, 57, 15);
		f.getContentPane().add(아이디);
		JLabel 비밀번호 = new JLabel("비밀번호");
		비밀번호.setBounds(108, 136, 57, 15);
		f.getContentPane().add(비밀번호);
		JLabel 이름 = new JLabel("이름");
		이름.setBounds(108, 167, 57, 15);
		f.getContentPane().add(이름);
		JLabel 이메일 = new JLabel("이메일");
		이메일.setBounds(108, 198, 57, 15);
		f.getContentPane().add(이메일);
		JLabel 전화번호 = new JLabel("전화번호");
		전화번호.setBounds(108, 229, 57, 15);
		f.getContentPane().add(전화번호);
		JLabel 주소 = new JLabel("주소");
		주소.setBounds(108, 260, 57, 15);
		f.getContentPane().add(주소);
		
		JButton 회원정보불러오기 = new JButton("회원정보불러오기");
		회원정보불러오기.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = tf1.getText();// 아이디 입력필드 값을 스트링 타입으로 id 변수 지정
					if (tf1.getText().trim().length()!=0) {
						tf1.setEditable(false);//변경 처리 못하게 막음.
					}else {
						
					}
				
				//가방만든다
				MemberDTO dto = new MemberDTO(); // 가방을 인스턴스한다.
				//가방 넣는다.
				dto.setId(id);	// 가방에 보낼 (찾고 싶은 id)를 넣는다.
				//가방 전달
				MemberDAO dao = new MemberDAO();// 가방을 전달 위해 DAO를 인스턴스한다.
				//가방꺼낸다.
				MemberDTO dto2= dao.CheckIf(dto); //  DB에서 가져온 값을 꺼낸다.
				if (dto2 != null) {// DAO절차를 거친 후 해당 정보의 값이 있다면. 
					System.out.println("정보잇음");
					tf1.setText(dto2.id);// id필드에 dto2의 id값을 보낸다.
					tf2.setText(dto2.pw);
					tf3.setText(dto2.name);
					tf4.setText(dto2.email);
					tf5.setText(dto2.tel);
					tf6.setText(dto2.adress);
				}else {
					JOptionPane.showMessageDialog(null, "정보없음");
				}
			}
		});
		회원정보불러오기.setBounds(12, 52, 129, 23);
		f.getContentPane().add(회원정보불러오기);
	
		f.setVisible(true);
	}//메인
}
