package f_kiosk;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JapaneseFoods extends JPanel{

	MainKiosk parent;
	JButton [] menu = new JButton[4];


	public JapaneseFoods(MainKiosk kiosk) {
		parent = kiosk;

		menu[0] = new JButton("초밥");		//버튼0 = 초밥
		menu[1] = new JButton("라멘");		//버튼1 = 라멘
		menu[2] = new JButton("새우튀김");		//버튼2 = 새우튀김
		menu[3] = new JButton("사케");		//버튼3 = 사케

		addLayout();
		eventProc();

	}//end jpFoods

	void addLayout() {

		setBackground(Color.WHITE);
		setLayout(new GridLayout(2,2));
		
		for (int i = 0; i < menu.length; i++) {
			add(menu[i]);
			menu[i].setPreferredSize(new Dimension(120,120));	// 크기 재지정
			menu[i].setVerticalTextPosition(JButton.BOTTOM);		// 버튼 수직 기준 텍스트 위치 지정
			menu[i].setHorizontalTextPosition(JButton.CENTER);	// 버튼 수평 기준 텍스트 위치 지정
			menu[i].setBackground(Color.WHITE);					// 버튼 배경 색 지정
		}

		//아이콘 삽입
		menu[0].setIcon(new ImageIcon("src\\f_kiosk\\icon\\sushi.png"));
		menu[1].setIcon(new ImageIcon("src\\f_kiosk\\icon\\ramen.png"));
		menu[2].setIcon(new ImageIcon("src\\f_kiosk\\icon\\shrimp.png"));
		menu[3].setIcon(new ImageIcon("src\\f_kiosk\\icon\\sake.png"));
		//아이콘 삽입 여기까지

	}//end addLayout()



	void eventProc() {	//이벤트 메서드(버튼 클릭하면 ~~)
		for(int i = 0; i < menu.length; i++) {
			menu[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JButton eBtn = (JButton)e.getSource();
					String str = eBtn.getText();
					parent.ta.append(str+"\t"+parent.menu.get(str)+"\n");
					parent.total += parent.menu.get(str);
					parent.taTotal.setText(String.valueOf(parent.total)+"원");
				}// end of actionPerformed()
			});// end of addActionListener()
		}// for

	}//end eventProc()
}

