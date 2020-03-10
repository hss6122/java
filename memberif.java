package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class memberif {
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JTextField textField_3;
	private static JTextField textField_4;
	private static JTextField textField_5;
//회원정보수정창
	public static void main(String[] args) {
		
		JFrame f = new JFrame();
		f.setSize(500, 500);
		f.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회원정보수정");
		lblNewLabel.setBounds(12, 10, 87, 31);
		f.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(201, 102, 116, 21);
		f.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(201, 133, 116, 21);
		f.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(201, 164, 116, 21);
		f.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(201, 195, 116, 21);
		f.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(201, 226, 116, 21);
		f.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(201, 257, 116, 21);
		f.getContentPane().add(textField_5);
		
		JButton btnNewButton = new JButton("수정완료");
		btnNewButton.setBounds(95, 306, 97, 23);
		f.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("탈퇴");
		btnNewButton_1.setBounds(220, 306, 97, 23);
		f.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("아이디");
		lblNewLabel_1.setBounds(108, 105, 57, 15);
		f.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("비밀번호");
		lblNewLabel_1_1.setBounds(108, 136, 57, 15);
		f.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("이메일");
		lblNewLabel_1_1_1.setBounds(108, 167, 57, 15);
		f.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("이름");
		lblNewLabel_1_1_1_1.setBounds(108, 198, 57, 15);
		f.getContentPane().add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("주소");
		lblNewLabel_1_1_1_1_1.setBounds(108, 229, 57, 15);
		f.getContentPane().add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("전화번호");
		lblNewLabel_1_1_1_1_1_1.setBounds(108, 260, 57, 15);
		f.getContentPane().add(lblNewLabel_1_1_1_1_1_1);
	
		f.setVisible(true);
	}//메인
}
