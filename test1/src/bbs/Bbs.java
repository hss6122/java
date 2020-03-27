package bbs;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Bbs {
	private static JTextField tf1;
	private static JTextField tf2;
	private static JTextField tf3;
	private static JTextField tf4;
	private static JTextField tf5;

	public static void main(String[] args) {
		
	JFrame j = new JFrame();
		j.setTitle("자바 시험");
		j.setSize(500, 500);
		j.getContentPane().setLayout(null);
		
		tf1 = new JTextField();
		tf1.setBounds(49, 84, 116, 21);
		j.getContentPane().add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setColumns(10);
		tf2.setBounds(49, 115, 116, 21);
		j.getContentPane().add(tf2);
		
		tf3 = new JTextField();
		tf3.setColumns(10);
		tf3.setBounds(49, 146, 116, 21);
		j.getContentPane().add(tf3);
		
		tf4 = new JTextField();
		tf4.setColumns(10);
		tf4.setBounds(49, 177, 116, 21);
		j.getContentPane().add(tf4);
		
		tf5 = new JTextField();
		tf5.setColumns(10);
		tf5.setBounds(49, 208, 116, 21);
		j.getContentPane().add(tf5);
		
		JButton btnNewButton = new JButton("입력완료");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String no1 = tf1.getText();
				String no2 = tf2.getText();
				String no3 = tf3.getText();
				String no4 = tf4.getText();
				String no5 = tf5.getText();
				
				
				JOptionPane.showMessageDialog(null , no1+ " " +no2 + " "+ no3 +" "+ no4 +" "+ no5);
			}
		});
		btnNewButton.setBounds(49, 255, 97, 23);
		j.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("게시물번호");
		lblNewLabel.setBounds(197, 87, 78, 15);
		j.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("제목");
		lblNewLabel_1.setBounds(197, 118, 57, 15);
		j.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("내용");
		lblNewLabel_1_1.setBounds(197, 149, 57, 15);
		j.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("작성자");
		lblNewLabel_1_2.setBounds(197, 180, 57, 15);
		j.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("소속");
		lblNewLabel_1_2_1.setBounds(197, 211, 57, 15);
		j.getContentPane().add(lblNewLabel_1_2_1);
		j.setVisible(true);
	}
}
