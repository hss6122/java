package view;
//회원가입창.
import javax.swing.JFrame;
import javax.swing.JTextField;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Signup {
	private static JTextField tf1;
	private static JTextField tf2;
	private static JTextField tf3;
	private static JTextField tf5;
	private static JTextField tf6;
	private static JTextField tf7;
	private JTextField tf4;
//		 id,pw에 중복확인 버튼
	
		public void Signup1() {
		
		
		JFrame f = new JFrame();
		f.setSize(500, 500);
		f.getContentPane().setLayout(null);
		tf1 = new JTextField(); //id
		tf1.setBounds(254, 67, 116, 21);
		f.getContentPane().add(tf1);
		tf1.setColumns(10);
		tf2 = new JTextField(); //pw
		tf2.setColumns(10);
		tf2.setBounds(254, 98, 116, 21);
		f.getContentPane().add(tf2);
		tf3 = new JTextField(); //pw again
		tf3.setColumns(10);
		tf3.setBounds(254, 129, 116, 21);
		f.getContentPane().add(tf3);
		tf4 = new JTextField(); //name
		tf4.setColumns(10);
		tf4.setBounds(254, 160, 116, 21);
		f.getContentPane().add(tf4);
		f.setVisible(true);
		tf5 = new JTextField(); //email
		tf5.setColumns(10);
		tf5.setBounds(254, 191, 116, 21);
		f.getContentPane().add(tf5);
		tf6 = new JTextField();	//tel
		tf6.setColumns(10);
		tf6.setBounds(254, 222, 116, 21);
		f.getContentPane().add(tf6);
		tf7 = new JTextField(); //aderss
		tf7.setColumns(10);
		tf7.setBounds(254, 253, 116, 21);
		f.getContentPane().add(tf7);
		
		JLabel 회원가입 = new JLabel("회원가입 ");
		회원가입.setBounds(148, 27, 161, 30);
		f.getContentPane().add(회원가입);
		JLabel 아이디 = new JLabel("아이디");
		아이디.setBounds(148, 70, 57, 15);
		f.getContentPane().add(아이디);
		JLabel 비밀번호 = new JLabel("비밀번호");
		비밀번호.setBounds(148, 101, 57, 15);
		f.getContentPane().add(비밀번호);
		JLabel 비밀번호확인 = new JLabel("비밀번호확인");
		비밀번호확인.setBounds(148, 132, 94, 15);
		f.getContentPane().add(비밀번호확인);
		JLabel 이름 = new JLabel("이름");
		이름.setBounds(148, 163, 94, 15);
		f.getContentPane().add(이름);
		JLabel 이메일 = new JLabel("이메일");
		이메일.setBounds(148, 194, 57, 15);
		f.getContentPane().add(이메일);
		JLabel 핸드폰번호 = new JLabel("핸드폰번호");
		핸드폰번호.setBounds(148, 225, 72, 15);
		f.getContentPane().add(핸드폰번호);
		JLabel 주소 = new JLabel("주소");
		주소.setBounds(148, 256, 57, 15);
		f.getContentPane().add(주소);
//		-----------------------------------------
		
		JButton btnNewButton = new JButton("회원가입버튼");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = tf1.getText();// 아이디 중복확인절차. DAO에 추가하기
				if (tf1.getText().trim().length()==0) {//빈공간이 있을시
					JOptionPane.showMessageDialog(null, "아이디를 입력해주세요");
					return;//다시 입력.
					//가방을 꺼낸다.
				}
				String pw = tf2.getText();
				if (tf2.getText().trim().length()==0) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요");
					return;
				}String pw11 = tf3.getText();//비밀번호확인
				if (tf2.getText().trim().equals(tf3.getText().trim())) {//같다면 bool값
					JOptionPane.showMessageDialog(null, "비밀번호가 동일. 사용가능");
				}else {
					JOptionPane.showMessageDialog(null, "비밀번호가 같지 않습니다.");
					return;
				}
				String name = tf4.getText();
				if (tf4.getText().trim().length()==0) {
					JOptionPane.showMessageDialog(null, "이름을 입력해주세요");
					return;
				}
				String email = tf5.getText();
				if (tf5.getText().trim().length()==0) {
					JOptionPane.showMessageDialog(null, "이메일을 입력해주세요.");
					return;
				}
				String tel = tf6.getText();
				if (tf6.getText().trim().length()==0) {
					JOptionPane.showMessageDialog(null, "전화번호를 입력해주세요.");
					return;
				}String adress = tf7.getText();
				if (tf7.getText().trim().length()==0) {
					JOptionPane.showMessageDialog(null, "주소를  입력해주세요.");
					return;
				}else {
					
				}
				
				//1. 가방을 만든다.
				MemberDTO dto = new MemberDTO();
				//2. 가방에 넣는다.
				dto.setId(id);
				dto.setPw(pw);
				dto.setName(name);
				dto.setEmail(email);
				dto.setTel(tel);
				dto.setAdress(adress);
				//3. 어디에전달.DAO에 전달.
				MemberDAO db = new MemberDAO();
				//4. 가방을 꺼낸다.
				db.insert(dto);// DAO에  보낸다.
				JOptionPane.showMessageDialog(null, "회원가입완료");
				}
				});
		btnNewButton.setBounds(188, 329, 121, 23);
		f.getContentPane().add(btnNewButton);
//		-----------------------------------------------
		JButton btnNewButton_1 = new JButton("id중복확인");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = tf1.getText();//id필드에서 값을 가져와서 스트링 타입 id 대입한다.
				MemberDTO dto = new MemberDTO();
				//1.가방을 만든다.
				dto.setId(id);
				//2.가방에 넣는다.
				MemberDAO dao = new MemberDAO();
				//3. 가방을 전달
				MemberDTO dto2 = dao.loginCheak(dto);// DAO의 loginCheak메소드에 dto 값을 넣어 호출한다. 호출 후 값은 dto2에 대입된다.
				//4. 가방을 꺼낸다.
				if ( dto2 != null ) {//null가능성 체크. 
					JOptionPane.showMessageDialog(null, "아이디 중복 다시 생성주세요");
				}else {// null이 맞다면.
					JOptionPane.showMessageDialog(null, "아이디사용가능");
				}
				}
				});
		btnNewButton_1.setBounds(375, 66, 97, 23);
		f.getContentPane().add(btnNewButton_1);
		
	
	
		}//메인
}
