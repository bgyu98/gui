package A_sample;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BTest extends JFrame{	//이지어?
	
	JButton btn;
	
	BTest(){
		super("나의 두번째창");
		btn = new JButton("확인2");
	}
	void addLayout() {
		add(btn);
		
		setBounds(10,10,500,350);		//크기 지정
		setVisible(true);		//창 띄울거니?
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//x버튼 누르면 종료할거니?
	}
	
	public static void main(String[] args) {
		
		BTest b = new BTest();
		b.addLayout();
	}
}
