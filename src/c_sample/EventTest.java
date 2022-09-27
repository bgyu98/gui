package c_sample;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
/*
 * 화면(JFrame)에 '확인' 버튼 하나 출력
 */

public class EventTest {
	
	JFrame f;
	JButton bA;
	EventTest(){
		f = new JFrame("Test");
		f.setLayout(new FlowLayout());
		bA = new JButton("확인");
		
		// 2. 핸들러 객체 생성
		MyHandler hdlr = new MyHandler();
		// 3. 이벤트 발생할 컴포넌트와 연결
		bA.addActionListener(hdlr);
		
	}
	
	
	//1. 이벤트 핸들러 만들기
	class MyHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "이벤트 발생");
			
		}
		
	}
	
	public void addLayout() {
		f.add(bA);
		
		f.setBounds(700,300,900,450);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
	
	public static void main(String[] args) {
		
		EventTest test = new EventTest();
		test.addLayout();
	}
}
