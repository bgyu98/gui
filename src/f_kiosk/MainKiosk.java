package f_kiosk;

import java.awt.BorderLayout;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainKiosk {
	
	JFrame f = new JFrame("KIOSK");				//프로그램 타이틀
	JLabel la = new JLabel("메뉴를 선택하세요.");		
	JTextArea ta = new JTextArea("==메뉴==\t==가격==\n");				//장바구니
	JTextArea taTotal = new JTextArea("총계 : ");				//장바구니에 담긴 메뉴 총액
	JButton bCancle = new JButton();	//취소버튼 예정
	JScrollPane scroll = new JScrollPane(ta);
	
	KoreanFoods korFoods;		//탭
	JapaneseFoods jpFoods;		//탭
	ChineseFoods cnnFoods;		//탭
	WestonFoods wtFoods;		//탭
	
	int total;	//메뉴 합계 금액 저장 변수
	
	HashMap<String , Integer> menu;		//hashmap <"메뉴이름", "가격">
	
	MainKiosk(){
	
		la = new JLabel("메뉴를 선택하세요.");
		
		korFoods = new KoreanFoods(this);
		jpFoods = new JapaneseFoods(this);
		cnnFoods = new ChineseFoods(this);
		wtFoods = new WestonFoods(this);
		menu = new HashMap<String, Integer> ();
		setMenu();
		
	
	}//end MainKiosk()
	
	void addLayout() {
		//기본 레이아웃 설정
		f.setLayout(new BorderLayout());
		ta.setAutoscrolls(true);
		
		//탭 설정
		JTabbedPane tab = new JTabbedPane();
		tab.addTab("한식", korFoods);
		tab.addTab("중식", cnnFoods);
		tab.addTab("일식", jpFoods);
		tab.addTab("양식", wtFoods);
		
		//add
		f.add(taTotal, BorderLayout.AFTER_LAST_LINE);
		f.add(la, BorderLayout.NORTH);
		f.add(ta, BorderLayout.CENTER);
		f.add(tab, BorderLayout.AFTER_LINE_ENDS);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		
		
		//기본 창 설정
		f.setBounds(100,100,1000,700);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//end addLayout()
	
	void eventProc() {
		
	}//end eventProc()
	
	void setMenu(){
		menu.put("초밥",9000);
		menu.put("라멘",8000);
		menu.put("새우튀김",7000);
		menu.put("사케",6000);
		
	}//end setmenu
	
	public static void main(String[] args) {
		MainKiosk kiosk = new MainKiosk();
		kiosk.addLayout();
		kiosk.eventProc();
		kiosk.setMenu();
		
	}
}
