package d_calculator;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class CalTest{
	//1. 맴버변수 선언
	JFrame f;		//프레임
	JTextField tf;	//텍스트 필드
	JButton []bNum = new JButton[10]; //0~9 숫자 표현할 버튼
	JButton []bOp = new JButton[4];	// +, - , * , * 버튼
	JButton bEqual;	// = 버튼
	
	int first, second;	//첫번째 숫자, 두번째 숫자
	String op;



	//2. 객체 선언

	CalTest(){
		f = new JFrame("유치원 계산기");
		tf = new JTextField();
		for(int i = 0; i<bNum.length; i++) {			//bNum배열에 숫자 넣기
			bNum[i] = new JButton(String.valueOf(i));
		}//end for
		bOp[0] = new JButton("+");		//bOp 배열에 문자 넣기
		bOp[1] = new JButton("-");		// |..
		bOp[2] = new JButton("*");		//  |
		bOp[3] = new JButton("/");		// ..|
		bEqual = new JButton("=");		// = 배치


	}//end of CalTest()

	//3.화면 구성 및 화면 출력

	void addLayout() {


		f.setLayout(new BorderLayout());	//보더레이아웃
		JPanel pSouth = new JPanel(new GridLayout(5,3));		//남쪽 판넬
		for(int i = 1; i<bNum.length; i++) {
			pSouth.add(bNum[i]);
		}//end for to bNum
		pSouth.add(bOp[0]);	//		**for 로 하면 왜 안돼?
		pSouth.add(bNum[0]); // 0 위치 지정
		pSouth.add(bEqual);	// = 배치
		pSouth.add(bOp[1]);	// 남쪽판넬에 bOp넣어주기~
		pSouth.add(bOp[2]);	//		~
		pSouth.add(bOp[3]);	//		~ ;
		f.add(pSouth, BorderLayout.SOUTH);	//남쪽 판넬 남쪽에 배치
		f.add(tf, BorderLayout.NORTH); //북쪽에 텍스트 필드 배치

		pSouth.setPreferredSize(new Dimension(425,355)); //남쪽판넬 크기조정


		f.setBounds(700,300,450,450);	//창 크기, 위치
		f.setVisible(true);	//띄울건지
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 종료 버튼 누르면 실행 종료
	}//end of addLayout()
	void eventProc() {
		for(int i = 0 ; i<bNum.length; i++) {
			bNum[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JButton eBtn = (JButton)e.getSource();
					String su =(tf.getText() + eBtn.getText() ) ;
					tf.setText(su);
				}//end of void

			});	//end actionlistener
		}//end of for bNum

			// 연산자 버튼이 눌러졌을때
		for(int i = 0; i<bOp.length; i++) {
			bOp[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JButton eBtn = (JButton)e.getSource();
					op = eBtn.getText();
					
					first = Integer.parseInt(tf.getText());
					tf.setText("");
					//String su = eBtn.getText();
					//tf.setText(su);
					
				}//end of void
			});//end of bOp[i]
		}//end of for
		
			// = 버튼이 눌러졌을때
			bEqual.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					second = Integer.parseInt(tf.getText());
					int result = 0;
					
					switch (op) {
					case "+": result = first + second; break;
					case "-": result = first - second; break;
					case "*": result = first * second; break;
					case "/": result = first / second; break;
					default : break;
					}
					tf.setText(String.valueOf(result));
				}//end of void
			});	//end of bEqual
		}//end of eventProc()

		public static void main(String[] args) {
			CalTest cal = new CalTest();
			cal.addLayout();
			cal.eventProc();

		}
	}

