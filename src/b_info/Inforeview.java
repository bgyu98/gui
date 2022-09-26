package b_info;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Inforeview {

	//1. 멤버 변수 선언
	JFrame f; // 프레임, 프로그램의 제목
	JTextField tfName, tfId, tfTel, tfGender, tfAge, tfHome; // 왼쪽에 올 텍스트 필드 변수 선언
	JTextArea ta; //텍스트 입력 칸 변수 선언
	JButton bAdd, bShow, bSearch, bDelete, bCancle, bExit;	//아랫쪽에 올 버튼 변수 선언
	
	//2. 멤버변수 객체 생성
	Inforeview(){
		f = new JFrame("DBTEST_2");			//프로그램 제목 설정
		tfName = new JTextField();			//name 텍스트필드 객체 생성
		tfId = new JTextField();			//id 텍스트필드 객체 생성
		tfTel = new JTextField();			//tel 텍스트필드 객체 생성
		tfGender = new JTextField();		//gender 텍스트필드 객체 생성
		tfAge = new JTextField();			//age 텍스트필드 객체 생성
		tfHome = new JTextField();			//home 텍스트필드 객체 생성
		bAdd = new JButton("Add");			//add 버튼 객체 생성
		bShow = new JButton("Show");		//show 버튼 객체 생성
		bSearch = new JButton("Search");	//search 버튼 객체 생성
		bDelete = new JButton("Delete");	//delete 버튼 객체 생성
		bCancle = new JButton("Cancle");	//cancle 버튼 객체 생성
		bExit = new JButton("Exit");		//exit 버튼 객체 생성
	}
	
	/*
	 * 3.화면 구성하고 출력
	 * 
	 * 전체 프레임 border layout 지정
	 * 			- West   : 판넬 붙이기 (6행2열)
	 * 			- Center : TextArea , TextArea는 바로 객체 생성 예정
	 * 			- South	 : 판넬 붙이기 (1행6열)
	 */
	
	
	public void addLayout() {	//메서드 생성
		f.setLayout(new BorderLayout()); 	//레이아웃 세팅, borderlayout : 동서남북,가운데로 레이아웃 지정
		
		//서쪽 판넬 생성
			JPanel pWest/*서쪽 판넬 변수 이름*/ = new JPanel(new GridLayout(6,2)/*gridlayout(행,열) : 행과 열로 레이아웃 배치*/);
			pWest.add(new JLabel("Name" , JLabel.CENTER)/*"name"옆에 JLabel.동서남북,가운데 지정 가능*/);
			pWest.add(tfName);							//tfName 객체를 판넬에 붙임
			pWest.add(new JLabel("ID" , JLabel.CENTER));
			pWest.add(tfId);							//tfId 객체를 판넬에 붙임
			pWest.add(new JLabel("Tel" , JLabel.CENTER));
			pWest.add(tfTel);							//tfTel 객체를 판넬에 붙임
			pWest.add(new JLabel("Gender" , JLabel.CENTER));
			pWest.add(tfGender);						//tfGender 객체를 판넬에 붙임
			pWest.add(new JLabel("Age" , JLabel.CENTER));
			pWest.add(tfAge);							//tfAge 객체를 판넬에 붙임
			pWest.add(new JLabel("Home" , JLabel.CENTER));
			pWest.add(tfHome);							//tfHome 객체를 판넬에 붙임
		f.add(pWest, BorderLayout.WEST);				// 제작한 west 판넬을 WEST Border에 붙임
			
		pWest.setPreferredSize(new Dimension(250,25));	//West 판넬 사이즈 지정
		
		//가운데 텍스트 에어리어
		f.add(new TextArea(), BorderLayout.CENTER);	//가운데 텍스트 에어리어를 생성후 Center Border에 붙임
		
		//남쪽 판넬 생성
			JPanel pSouth = new JPanel(new GridLayout(1,6));	//pSouth 판넬 제작후 1행6열 레이아웃 지정
			pSouth.add(bAdd);			//south 판넬에 버튼 객체 생성
			pSouth.add(bShow);			//south 판넬에 버튼 객체 생성
			pSouth.add(bSearch);		//south 판넬에 버튼 객체 생성
			pSouth.add(bDelete);		//south 판넬에 버튼 객체 생성
			pSouth.add(bCancle);		//south 판넬에 버튼 객체 생성
			pSouth.add(bExit);			//south 판넬에 버튼 객체 생성
		f.add(pSouth, BorderLayout.SOUTH);	//south border에 psouth 판넬 붙임
		
		pSouth.setPreferredSize(new Dimension(500,50));		//south panel size
	
		//화면 출력
		f.setBounds(700,300,900,450);	//창을 나타낼 위치, 창의 크기
		f.setVisible(true);				//창을 나타낼건지
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//X버튼을 누르면 프로그램 종료 할것인지
		
	}
	
	public static void main(String[] args) {
		Inforeview info = new Inforeview();
		info.addLayout();	//addLayout 메소드 호출
	}
	
}
