package b_info;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.border.Border;

public class Inforeview {

	// 1. 멤버 변수 선언
	JFrame f; // 프레임, 프로그램의 제목
	JTextField tfName, tfId, tfTel, tfGender, tfAge, tfHome; // 왼쪽에 올 텍스트 필드 변수 선언
	JTextArea ta; // 텍스트 입력 칸 변수 선언
	JButton bAdd, bShow, bSearch, bDelete, bCancle, bExit; // 아랫쪽에 올 버튼 변수 선언

	// 2. 멤버변수 객체 생성
	Inforeview() {
		f = new JFrame("DBTEST_2"); // 프로그램 제목 설정
		tfName = new JTextField(); // name 텍스트필드 객체 생성
		tfId = new JTextField(); // id 텍스트필드 객체 생성
		tfTel = new JTextField(); // tel 텍스트필드 객체 생성
		tfGender = new JTextField(); // gender 텍스트필드 객체 생성
		tfAge = new JTextField(); // age 텍스트필드 객체 생성
		tfHome = new JTextField(); // home 텍스트필드 객체 생성
		bAdd = new JButton("Add"); // add 버튼 객체 생성
		bShow = new JButton("Show"); // show 버튼 객체 생성
		bSearch = new JButton("Search"); // search 버튼 객체 생성
		bDelete = new JButton("Delete"); // delete 버튼 객체 생성
		bCancle = new JButton("Cancle"); // cancle 버튼 객체 생성
		bExit = new JButton("Exit"); // exit 버튼 객체 생성
	}

	/*
	 * 3.화면 구성하고 출력
	 * 
	 * 전체 프레임 border layout 지정 - West : 판넬 붙이기 (6행2열) - Center : TextArea ,
	 * TextArea는 바로 객체 생성 예정 - South : 판넬 붙이기 (1행6열)
	 */

	public void addLayout() { // 메서드 생성

		f.setLayout(new BorderLayout()); // 레이아웃 세팅, borderlayout : 동서남북,가운데로 레이아웃 지정

		// 서쪽 판넬 생성
		JPanel pWest/* 서쪽 판넬 변수 이름 */ = new JPanel(new GridLayout(6, 2)/* gridlayout(행,열) : 행과 열로 레이아웃 배치 */);
		pWest.add(new JLabel("Name", JLabel.CENTER)/* "name"옆에 JLabel.동서남북,가운데 지정 가능 */);
		pWest.add(tfName); // tfName 객체를 판넬에 붙임
		pWest.add(new JLabel("ID", JLabel.CENTER));
		pWest.add(tfId); // tfId 객체를 판넬에 붙임
		pWest.add(new JLabel("Tel", JLabel.CENTER));
		pWest.add(tfTel); // tfTel 객체를 판넬에 붙임
		pWest.add(new JLabel("Gender", JLabel.CENTER));
		pWest.add(tfGender); // tfGender 객체를 판넬에 붙임
		pWest.add(new JLabel("Age", JLabel.CENTER));
		pWest.add(tfAge); // tfAge 객체를 판넬에 붙임
		pWest.add(new JLabel("Home", JLabel.CENTER));
		pWest.add(tfHome); // tfHome 객체를 판넬에 붙임
		f.add(pWest, BorderLayout.WEST); // 제작한 west 판넬을 WEST Border에 붙임

		pWest.setPreferredSize(new Dimension(250, 25)); // West 판넬 사이즈 지정

		// 가운데 텍스트 에어리어
		f.add(new TextArea(), BorderLayout.CENTER); // 가운데 텍스트 에어리어를 생성후 Center Border에 붙임

		// 남쪽 판넬 생성
		JPanel pSouth = new JPanel(new GridLayout(1, 6)); // pSouth 판넬 제작후 1행6열 레이아웃 지정
		pSouth.add(bAdd); // south 판넬에 버튼 객체 생성
		pSouth.add(bShow); // south 판넬에 버튼 객체 생성
		pSouth.add(bSearch); // south 판넬에 버튼 객체 생성
		pSouth.add(bDelete); // south 판넬에 버튼 객체 생성
		pSouth.add(bCancle); // south 판넬에 버튼 객체 생성
		pSouth.add(bExit); // south 판넬에 버튼 객체 생성
		f.add(pSouth, BorderLayout.SOUTH); // south border에 psouth 판넬 붙임

		pSouth.setPreferredSize(new Dimension(500, 50)); // south panel size

		// 화면 출력
		f.setBounds(700, 300, 900, 450); // 창을 나타낼 위치, 창의 크기
		f.setVisible(true); // 창을 나타낼건지
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X버튼을 누르면 프로그램 종료 할것인지

	}

	public void eventProc() { // 이벤트 창 띄우는 메서드 묶음
		bAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "ADD버튼 클릭");
			}
		});
		bShow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null, "SHOW버튼 클릭");
			}
		});
		bSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Search버튼 클릭");
			}
		});
		bDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Delete버튼 클릭");
			}
		});
		bCancle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "CANCLE버튼 클릭");
			}
		});
		bExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // exit버튼을 누르면 종료
			}
		});
		
		//주민번호 입력창에서 포커스 이벤트가 발생했을때
		tfId.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {		//focus를 잃었을때
				getJuminInfo();
			}

			public void focusGained(FocusEvent e) {		//focus를 얻었을때
			}
		});	//end focus

	}


void getJuminInfo() {
	tfId.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String jumin = tfId.getText(); // jumin변수에 tfid텍스트 추출
			if (jumin.length() < 14) { // 14자리 미만까지 입력
				JOptionPane.showMessageDialog(null, ": - 을 포함한 14자를 맞춰주세요"); // 부족하거나 넘을시
				return;
			}

			// (1) 주민번호의 7번째 문자로 성별을 구하여 성별창에 출력
			if (jumin.charAt(7) == '1' | jumin.charAt(7) == '3') {
				tfGender.setText("남자");
			} else if (jumin.charAt(7) == '2' | jumin.charAt(7) == '4') {
				tfGender.setText("여자");
			}
			// (2) 주민번호의 8번째 문자로 출신지를 구하여 출신지창에 출력
			switch (jumin.charAt(8)) {
			case '1':
				tfHome.setText("서울");
				break;
			case '2':
				tfHome.setText("경기도");
				break;
			case '3':
				tfHome.setText("인천");
				break;
			case '4':
				tfHome.setText("강원도");
				break;
			case '5':
				tfHome.setText("충청북도");
				break;
			case '6':
				tfHome.setText("충청남도");
				break;
			case '7':
				tfHome.setText("전라도");
				break;
			case '8':
				tfHome.setText("경상도");
				break;
			case '9':
				tfHome.setText("제주도");
				break;
			default:
				JOptionPane.showMessageDialog(null, "잘못 입력하셨습니다.");
				break;
			}
			// (3) 주민번호에서 년도에 의해 나이를 구해서 나이창에 출력
			String nai = jumin.substring(0, 2); // nai에 jumin의 0~1번째 자리 글자 추출
			int sunai = Integer.parseInt(nai); // sunai에 nai(String)을 int로 변환
			int age = 0;
			Calendar c = Calendar.getInstance(); // calender 클래스 오버라이딩
			int year = c.get(Calendar.YEAR); // calender 클래스에서 year뽑아옴. (현재 년도 추출)

			int nyun = 0; // 지금의 년대를 저장할 변수
			char sung = jumin.charAt(7); // sung의 7번째 자릿수에 있는 문자를 뽑아옴

			if (sung == '1' | sung == '2') { // 1,2면 1900년대생
				nyun = 1900;
			} else if (sung == '3' | sung == '4') { // 3,4면 2000년대생
				nyun = 2000;
			}
			age = year - (nyun + sunai) + 1; // age = 현재 년도 - (위의 1900년대생 + 주민번호0~1자리 숫자) + 1(만나이)
			String agege = String.valueOf(age); // int형을 String형으로 다시 변환
			tfAge.setText(agege); // tfAge텍스트필드에 agege 입력

		}
	});
}





		public static void main(String[] args) {

			Inforeview info = new Inforeview();
			info.addLayout(); // addLayout 메소드 호출
			info.eventProc();
			info.getJuminInfo();
		}

	}