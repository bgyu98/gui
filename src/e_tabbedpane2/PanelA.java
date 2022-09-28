package e_tabbedpane2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelA extends JPanel {

	JLabel aLa = new JLabel("판떼기 A");
	JButton aBtn = new JButton("A 버튼");
	
	MainTest parent;
	
	public PanelA(MainTest mainTest) {
		
		parent = mainTest;
		
		setBackground(new Color(255, 0, 0));
		addLayout();
		eventProc();
	}//end PanelA
	
	void addLayout() {
		add(aLa);
		add(aBtn);
	
	}//end addLayout
	
	void eventProc() {
		aBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.la.setText("안녕하세요");
			}//end per
		});//end listener
	}//end eventProc()
	
}
