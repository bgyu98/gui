package f_kiosk;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class MainKiosk {
	
	JFrame f;
	JButton btn;
	JLabel la;
	JTextField tf;
	
	JapaneseFoods jpFoods;
	
	MainKiosk(){
	
		f = new JFrame("KIOSK");
		btn = new JButton("MENU");
		la = new JLabel("메뉴를 선택하세요.");
		tf = new JTextField();
		
		jpFoods = new JapaneseFoods(this);
		
	}//end MainKiosk()
	
	void addLayout() {
		//기본 레이아웃 설정
		f.setLayout(new BorderLayout());
		
		//탭 설정
		JTabbedPane tab = new JTabbedPane();
		tab.addTab("일식", jpFoods);
		
		//add
		f.add(btn, BorderLayout.EAST);
		f.add(la, BorderLayout.NORTH);
		f.add(tf, BorderLayout.CENTER);
		f.add(tab, BorderLayout.AFTER_LINE_ENDS);
		
		
		
		//기본 창 설정
		f.setBounds(100,100,1000,700);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		MainKiosk kiosk = new MainKiosk();
		kiosk.addLayout();
	}
}
