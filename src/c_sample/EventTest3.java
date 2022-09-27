package c_sample;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
/*
 * 화면(JFrame)에 '확인' 버튼 하나 출력
 */

public class EventTest3 {
	
	JFrame f;
	JButton bA;
	EventTest3(){
		f = new JFrame("Test");
		f.setLayout(new FlowLayout());
		bA = new JButton("확인");
		
		//1. 이벤트 핸들러 만들기
		// 2. 핸들러 객체 생성
		// 3. 이벤트 발생할 컴포넌트와 연결
		bA.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "이벤트 발생3");
				System.exit(0);
			}
		});
	}
	
	public void addLayout() {
		f.add(bA);
		
		f.setBounds(700,300,900,450);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
	
	public static void main(String[] args) {
		
		EventTest3 test = new EventTest3();
		test.addLayout();
	}
}
