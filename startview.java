package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.View;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Stack;
import java.awt.event.ActionEvent;

public class startview {
	private static JTextField tf1;
	private static JPasswordField tf_pw;

	public static void main(String[] args) {

		JFrame f1 = new JFrame();
		f1.setSize(700, 700);
		f1.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("로그인");
		lblNewLabel.setBounds(303, 41, 57, 15);
		f1.getContentPane().add(lblNewLabel);
//----------------------------------------------- id작성
		tf1 = new JTextField();
		tf1.setBounds(266, 86, 116, 21);
		f1.getContentPane().add(tf1);
		tf1.setColumns(10);
//-------------------------------------------------pw작성		
		tf_pw = new JPasswordField();
		// 자바 스윙에서 위 필드를 사용하면 암호입력시 *표시로 표시할 수 있도록.
		tf_pw.setEchoChar('*');
		// 암호 입력시 * 로 가려지게함,
		tf_pw.setBounds(266, 130, 116, 21);
		f1.getContentPane().add(tf_pw);
//		-------------------------------
		JButton btnNewButton = new JButton("로그인버튼");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = tf1.getText();
				char[] pw1 = tf_pw.getPassword();// *표시를 해줬기에. 개별로 된 char값 배열에저장.
				// 필드에서 패스워드를 얻어와서 char[]배열에 저장
				String pw = new String(pw1); // char을 스트링 값으로 변환 하여 DB저장될 수 있게 가공.
				// 가방을 만든다.
				MemberDTO dto = new MemberDTO();
				// 가방에 넣음
				dto.setId(id);
				dto.setPw(pw);

				// 가방전달
				MemberDAO dao = new MemberDAO();
				// 가방을 꺼낸다.
				MemberDTO dto2 = dao.login(dto);

				// 로그인 확인조건
				// id && pw true >>>>>>>>>> 성공
				// id가 없는 경우
				// id는 있는데 비번이 다른경우>>>>>>
				if (dto2 != null) {// null가능성 체크.
					JOptionPane.showMessageDialog(null, "로그인성공");
					// if if 문으로 null값 해결하기
				} else {
					JOptionPane.showMessageDialog(null, "로그인 실패");
					return;
				}
			}
		});
		btnNewButton.setBounds(266, 160, 116, 23);
		f1.getContentPane().add(btnNewButton);
//		--------------------------------
		JButton btnNewButton_1 = new JButton("회원가입버튼");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Signup sgin = new Signup(); // signup 클래스 에 접근하기위해 sgin변수에인스턴스
				sgin.Signup1(); // 회원가입창 메소드
			}
		});
		btnNewButton_1.setBounds(266, 207, 116, 23);
		f1.getContentPane().add(btnNewButton_1);

		f1.setVisible(true);

	}// 메인
}
