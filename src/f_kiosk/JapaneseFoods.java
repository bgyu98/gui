package f_kiosk;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JapaneseFoods extends JPanel{
	
	MainKiosk parent;
	JButton bsushi, bramen, bshrimp, bsake;
	JLabel bsushii;
	
	public JapaneseFoods(MainKiosk kiosk) {
		parent = kiosk;
		
		bsushi = new JButton("<html>&nbsp; 초밥<br>6000원</html>");
		bramen = new JButton("라멘");
		bshrimp = new JButton("새우튀김");
		bsake = new JButton("사케");
		
		setBackground(new Color(255,255,255));
		addLayout();
		
	}//end jpfoods
	
	void addLayout() {
		
		//초밥 메뉴 세팅
		bsushi.setIcon(new ImageIcon("src\\f_kiosk\\icon\\sushi.png"));
		bsushi.setHorizontalTextPosition(JButton.CENTER);
		bsushi.setVerticalTextPosition(JButton.BOTTOM);
		bsushi.setPreferredSize(new Dimension(300, 300));
		
		//라면 메뉴 세팅
		bramen.setIcon(new ImageIcon("src\\f_kiosk\\icon\\ramen.png"));
		bramen.setHorizontalTextPosition(JButton.CENTER);
		bramen.setVerticalTextPosition(JButton.BOTTOM);
		bramen.setPreferredSize(new Dimension(300, 300));
		
		//새우튀김 메뉴 세팅
		bshrimp.setIcon(new ImageIcon("src\\f_kiosk\\icon\\shrimp.png"));
		bshrimp.setHorizontalTextPosition(JButton.CENTER);
		bshrimp.setVerticalTextPosition(JButton.BOTTOM);
		bshrimp.setPreferredSize(new Dimension(300, 300));
		
		//사케 메뉴 세팅
		bsake.setIcon(new ImageIcon("src\\f_kiosk\\icon\\sake.png"));
		bsake.setHorizontalTextPosition(JButton.CENTER);
		bsake.setVerticalTextPosition(JButton.BOTTOM);
		bsake.setPreferredSize(new Dimension(300, 300));
		
		
		JPanel pEast = new JPanel(new GridLayout(2,2, 10, 10));		//메뉴 판넬
			pEast.add(bsushi);
			pEast.add(bramen);
			pEast.add(bshrimp);
			pEast.add(bsake);
			
		add(pEast);
		
	}//end addLayout()
	
}
