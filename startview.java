package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.Toolkit;

public class startview {
	static String loginkey;// 로그인 id를 다른 클래스에서 사용 할 수 있도록 스태틱지정
	private static JTextField tf1;// 해당 클래스에서만 전역변수로 이용
	private static JPasswordField tf_pw;
	public static void main(String[] args) {// 메인 클래스안에서는 스트링값으로된 것들을 입력값으로 사용
	
		
			 
		JFrame f1 = new JFrame(); // JFrame 메소드를 인스턴스하여 f1에 변수 지정하였음 제이프레임의 생성자
		

		
		

		f1.getContentPane().setBackground(Color.DARK_GRAY);
		f1.setSize(1100, 800);
		f1.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Member Login");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(495, 228, 154, 38);
		f1.getContentPane().add(lblNewLabel);

//----------------------------------------------- id작성
		tf1 = new JTextField();
		tf1.setHorizontalAlignment(SwingConstants.CENTER);
		tf1.setBounds(476, 276, 183, 36);
		f1.getContentPane().add(tf1);
		tf1.setColumns(10);
//-------------------------------------------------pw작성		
		tf_pw = new JPasswordField();
		tf_pw.setHorizontalAlignment(SwingConstants.CENTER);
		// 자바 스윙에서 위 필드를 사용하면 암호입력시 *표시로 표시할 수 있도록.
		tf_pw.setEchoChar('*');
		// setEchoChar로 password필드에 표시될 문자를 설정.
		tf_pw.setBounds(476, 322, 183, 36);
		f1.getContentPane().add(tf_pw);
//		-------------------------------
		JButton btnNewButton = new JButton("로그인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = tf1.getText();
				char[] pw1 = tf_pw.getPassword();// *표시를 해줬기에. 개별로 된 char값 배열에저장.
				String pw = new String(pw1); // char을 스트링 값으로 변환 하여 DB저장될 수 있게 가공.
				// 1.가방을 만든다.
				MemberDTO dto = new MemberDTO();
				// 2.가방에 넣음
				dto.setId(id);// ID필드값을 DTO로 보냄~
				dto.setPw(pw);// PW필드값을 DTO로 보냄
				// 3.가방전달
				MemberDAO dao = new MemberDAO();
				// 4.가방을 꺼낸다.
				MemberDTO dto2 = dao.login(dto);// dao의 login메소드에 dto값을 보냄.
				if (dto2 != null) {// null가능성 체크하여 하단 절차 실행
					JOptionPane.showMessageDialog(null, "로그인성공");
					memberif if1 = new memberif();// DAO 클래스의 memberif메소드를 인스턴스함.
					loginkey = id;// 로그인 id값을 키값으로 지정
					if1.MemberIf();// 회원정보창 메소드
				} else {
					JOptionPane.showMessageDialog(null, "로그인 실패");
					return;
				}
			}
		});
		btnNewButton.setBounds(476, 392, 183, 35);
		f1.getContentPane().add(btnNewButton);
//		--------------------------------
		JButton btnNewButton_1 = new JButton("회원가입");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Signup sgin = new Signup(); // signup클래스를 인스턴스하여 sgin변수지정
				sgin.Signup1(); // 회원가입창 메소드 해당 클래스에 메인이 없음으로 팝업형태로 호출됨
			}
		});
		btnNewButton_1.setBounds(476, 437, 183, 38);
		f1.getContentPane().add(btnNewButton_1);

		f1.setVisible(true);

	}// 메인
}
