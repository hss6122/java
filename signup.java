package view;
//회원가입창.
import javax.swing.JFrame;
import javax.swing.JTextField;

import 클래스만들기.값전달;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.TextField;
import java.awt.event.ActionEvent;

public class signup {
	private static JTextField tf1;
	private static JTextField tf2;
	private static JTextField tf3;
	private static JTextField tf5;
	private static JTextField tf6;
	private static JTextField tf7;
	private JTextField tf4;
		
	/**
	 * @wbp.parser.entryPoint
	 */
	public  void signup() {
		
		
		
		
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
		
		JLabel lblNewLabel = new JLabel("회원가입 ");
		lblNewLabel.setBounds(148, 27, 161, 30);
		f.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("아이디");
		lblNewLabel_1.setBounds(148, 70, 57, 15);
		f.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("비밀번호");
		lblNewLabel_1_1.setBounds(148, 101, 57, 15);
		f.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("비밀번호확인");
		lblNewLabel_1_1_1.setBounds(148, 132, 94, 15);
		f.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("이메일");
		lblNewLabel_1_1_1_1.setBounds(148, 194, 57, 15);
		f.getContentPane().add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("핸드폰번호");
		lblNewLabel_1_1_1_1_1.setBounds(148, 225, 72, 15);
		f.getContentPane().add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("주소");
		lblNewLabel_1_1_1_1_1_1.setBounds(148, 256, 57, 15);
		f.getContentPane().add(lblNewLabel_1_1_1_1_1_1);
//		-----------------------------------------
		JButton btnNewButton = new JButton("회원가입버튼");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String id = tf1.getText();
				String pw = tf2.getText();
				String pw1 = tf3.getText();//비밀번호확인
				if (pw == pw1) {
					JOptionPane.showMessageDialog(null, "비밀번호 동일");
					
				} else {
					JOptionPane.showMessageDialog(null, "비밀번호가 같지 않습니다");
				}
				String name = tf4.getText();
				String email = tf5.getText();
				String tel = tf6.getText();
				String adress = tf7.getText();
				
				
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
				
			}
		});
		btnNewButton.setBounds(188, 329, 121, 23);
		f.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("이름");
		lblNewLabel_1_1_1_2.setBounds(148, 163, 94, 15);
		f.getContentPane().add(lblNewLabel_1_1_1_2);
		
	
	}//메인
}
