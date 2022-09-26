package A_sample;
import java.awt.*;

import javax.swing.*;
/*
 *  자바의 GUI(화면)
 *  - AWT : 1.2이전
 *  - Swing : 1.2이후
 *  			대부분 클래스 앞에 J
 */

public class ATest {		//헤즈어?

	JFrame f;		//Swing ** Frame앞에 J가 붙으면 Swing
	JButton btn;	//버튼
	JButton btn2;	//버튼2
	JCheckBox cb , cb2;	//체크박스1,2
	JRadioButton rb1, rb2;
	JTextArea  ta;
	JTextField tf;
	
	ATest(){
		f = new JFrame("나의 첫창");
		btn = new JButton("클릭");
		btn2 = new JButton("취소");
		cb = new JCheckBox("자바");
		cb2 = new JCheckBox("오라클");
		rb1 = new JRadioButton("남자");
		rb2 = new JRadioButton("여자");
	}
	void addLayout() {
		//f.setLayout(new FlowLayout());	//한 줄로 나열
		//f.setLayout(new GridLayout(3,3));	//행,열로 나열
		f.setLayout(new BorderLayout());	//동/서/남/북/가운데 배치
		
		ButtonGroup group = new ButtonGroup();
		group.add(rb1);
		group.add(rb2);
		//붙이기 작업
		f.add(btn, BorderLayout.NORTH);
		f.add(btn2, BorderLayout.SOUTH);
		//f.add(cb);
		//f.add(cb2);
			JPanel pEast = new JPanel();
			pEast.add(rb1);
			pEast.add(rb2);
		f.add(pEast, BorderLayout.EAST);
			
		//f.add(rb1,BorderLayout.EAST);
		//f.add(rb2,BorderLayout.EAST);
		f.add(new JLabel("입력하세요"),BorderLayout.WEST);
		//f.add(new TextField(1),BorderLayout.EAST);
		f.add(new TextArea(2,2),BorderLayout.CENTER);
		
		//화면 출력
		f.setBounds(700,300,500,400);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		ATest a = new ATest();
		a.addLayout();

	}

}
