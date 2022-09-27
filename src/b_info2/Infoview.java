package b_info2;
import java.awt.*;
import javax.swing.*;

public class Infoview {
	
	//1. 멤버변수 선언
	JFrame f;	//dbtext
	JTextField tfName, tfId, tfTel, tfGender, tfAge, tfHome;	//왼쪽글
	JTextArea ta; //텍스트칸
	JButton bAdd, bShow, bSearch, bDelete, bCancle, bExit;	//아래 버튼
	JLabel label;
	
	
	//2. 멤버변수 객체생성
	Infoview(){
		f = new JFrame("DBTest");
		tfName = new JTextField();
		tfId = new JTextField();
		tfTel = new JTextField();
		tfGender = new JTextField();
		tfAge = new JTextField();
		tfHome = new JTextField();
		bAdd = new JButton("Add");
		bShow = new JButton("Show");
		bSearch = new JButton("Search");
		bDelete = new JButton("Delete");
		bCancle = new JButton("Cancle");
		bExit = new JButton("Exit");
		label = new JLabel();
		
	}
	//3. 화면구성하고 출력
	/*
	 * 전체 프레임 border layout 지정
	 * 		-West : 판넬 붙이기 6행2열
	 * 		-center : 텍스트에어리어
	 * 		-south : 판넬 붙이기 1행6열
	 */
	public void addLayout() {
		f.setLayout(new BorderLayout());	// 레이아웃
		// 서쪽 판넬
			JPanel pWest = new JPanel(new GridLayout(6,2));
			pWest.add(new JLabel("Name",JLabel.CENTER));
			pWest.add(tfName);
			pWest.add(new JLabel("ID",JLabel.CENTER));
			pWest.add(tfId);
			pWest.add(new JLabel("Tel",JLabel.CENTER));
			pWest.add(tfTel);
			pWest.add(new JLabel("Gender",JLabel.CENTER));
			pWest.add(tfGender);
			pWest.add(new JLabel("Age",JLabel.CENTER));
			pWest.add(tfAge);
			pWest.add(new JLabel("Home",JLabel.CENTER));
			pWest.add(tfHome);
		f.add(pWest, BorderLayout.WEST);
		
		pWest.setPreferredSize(new Dimension(250,25));		//서쪽 판넬 사이즈
		
		// 가운데 텍스트 에어리어
		f.add(new TextArea(), BorderLayout.CENTER);
			
		// 남쪽 판넬
			JPanel pSouth = new JPanel(new GridLayout(1,6));
			pSouth.add(bAdd);
			pSouth.add(bShow);
			pSouth.add(bSearch);
			pSouth.add(bDelete);
			pSouth.add(bCancle);
			pSouth.add(bExit);
		f.add(pSouth, BorderLayout.SOUTH);
		
		pSouth.setPreferredSize(new Dimension(500,50));		//남쪽 판넬 사이즈
		
		
		
		//화면 출력
		f.setBounds(700,300,900,450);		//창을 나타낼 위치, 창의 크기
		f.setVisible(true);					//보일거냐고
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//x버튼 누르면 종료?
		
	}
	
	
	public static void main(String[] args) {
	
		Infoview info = new Infoview();
		info.addLayout();
		
	} 
	
}
