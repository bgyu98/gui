package b_info;

import java.awt.*;
import java.awt.event.*;
import java.nio.channels.Selector;
import java.util.*;
import java.util.logging.ErrorManager;

import javax.swing.*;
import javax.xml.transform.ErrorListener;


public class Inforeview {

	// 1. 멤버 변수 선언
	JFrame f; // 프레임, 프로그램의 제목
	JTextField tfName, tfId, tfTel, tfGender, tfAge, tfHome; // 왼쪽에 올 텍스트 필드 변수 선언
	JTextArea ta; // 텍스트 입력 칸 변수 선언
	JButton bAdd, bShow, bSearch, bDelete, bCancle, bExit; // 아랫쪽에 올 버튼 변수 선언

	ArrayList<PersonVO> list = new ArrayList<PersonVO>();

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
		ta = new JTextArea(); //text area 객체 생성
		bExit = new JButton("Exit (alt+x)" ,new ImageIcon("src\\b_info\\imgs\\2.png"));	//exit버튼에 단축키 설정, 아이콘 설정
		bExit.setRolloverIcon(new ImageIcon("src\\b_info\\imgs\\3.png")); // 버튼에 마우스를 올려놓으면 다른 이미지 띄우기
		bExit.setPressedIcon(new ImageIcon("src\\b_info\\imgs\\3.png")); // 버튼을 누르면 이미지 바뀜
		bExit.setHorizontalTextPosition(JButton.RIGHT);
		bExit.setVerticalTextPosition(JButton.BOTTOM);
		bExit.setToolTipText("프로그램을 종료합니다.");	//마우스를 버튼위에 올려놓으면 툴팁 제공
		bExit.setMnemonic('x');	//alt x 누르면 종료
		bExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// exit버튼을 누르면 종료
				System.exit(0);
			}
		});
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
		f.add(ta, BorderLayout.CENTER); // 가운데 텍스트 에어리어를 생성후 Center Border에 붙임

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
			public void actionPerformed(ActionEvent e) {
				inputData();
				clearTextField();
				selectAll();
			}
		});
		bShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectAll();
			}
		});
		bSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectByTel();
			}
		});
		bDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteByTel();
			}
		});
		bCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearTextField();
			}
		});
		bExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // exit버튼을 누르면 종료
			}
		});

		//전화번호 텍스트필드에서 포커스 이벤트가 발생했을때
		tfTel.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				selectByTel();
			}
			public void focusGained(FocusEvent e) {
			}
		});

		//전화번호 텍스트필드에서 엔터쳤을때
		tfTel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectByTel();
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

		tfId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getJuminInfo();
			}
		});	//end actionlistener

	}

	/*
	 * add 버튼이 눌렸을 때 텍스트필드에 입력한 사용자의 값들을 personVO에 저장
	 */


	public void inputData() {
		//1) 각각의 텍스트필드의 입력값을 얻어오기
		//2) 1번의 값들을 personvo에 멤버변수에 저장(setter/constructor)
		PersonVO vo = new PersonVO();
		vo.setName(tfName.getText());
		vo.setGender(tfGender.getText());
		vo.setHome(tfHome.getText());
		vo.setId(tfId.getText());
		vo.setTel(tfTel.getText());
		vo.setAge(Integer.parseInt(tfAge.getText()));

		list.add(vo);

	}//end inputData()

	/*
	 * 함수명 	: selectByTel
	 * 인자 		: 없음
	 * 리턴값 	: void
	 * 역할 		: 전화번호를 입력하고 Search버튼을 누르면 저장되어 있는 list에서 일치하는지 확인 후 일치하면 나머지 정보들을 뽑아옴
	 */
	void selectByTel() {
		//전화번호값을 입력
		String tel = tfTel.getText();
		//입력받은 전화번호가 공백이라면 메시지 창을 띄우기
		if(tel.equals("")) {
			JOptionPane.showMessageDialog(null, "전화번호를 입력하세요");
			return;	//전화번호를 입력하지 않고 실행하면 안됨
		}//if end
		//해당 전화번호가 있으면 그 내용을 각각의 텍스트필드에 출력
		for(PersonVO vo : list) {
			if(tel.equals(vo.getTel())) {
				tfName.setText(vo.getName());
				tfGender.setText(vo.getGender());
				tfId.setText(vo.getId());
				tfHome.setText(vo.getHome());
				tfAge.setText(String.valueOf(vo.getAge()));
				return;
			}else {
				JOptionPane.showMessageDialog(null, "일치하는 전화번호가 없습니다.");

			}//if end


		}//for end
	}//end selectByTel()

	void deleteByTel() {
		//입력한 전화번호값을얻어오기
		String tel = tfTel.getText();
		// 입력받은 전화번호가 공백이라면 "전화번호를 입력하세요" 라는 메세지창을 출력

		if(tel.equals("")) {
			JOptionPane.showMessageDialog(null, "전화번호를 입력하세요");
			return;
		}//if end
		for(PersonVO vo : list) {
			if(tel.equals(vo.getTel())) {
				list.remove(vo);
				JOptionPane.showMessageDialog(null, "삭제 성공");
				clearTextField();
				break;
			}else {
				JOptionPane.showMessageDialog(null, "일치하는 전화번호가 없습니다.");
			}//if end

			// 리스트에 저장된 personVO의전화번호와 비교하여 해당 전화번호가 있으면 그 해당하는 personVO를 리스트에서 삭제

			// (참고) 삭제하고 나서 break로 반복문 끝내기
		}//for end
	}//end deleteByTel()

		/*
		 * lists에 저장된 정보를 모두 텍스트에어리어에 출력
		 */
		void selectAll() {
			ta.setText("=======전체목록======\n");
			for(PersonVO vo : list) {
				ta.append(vo.toString());
			}//end enhanced for
		}//end of selectAll()


		/*
		 * clearTextField()
		 * 각각의 텍스트 필드의 값을 지우기, 텍스트 에어리어도 지우기
		 */
		public void clearTextField() {
			ta.setText(null);
			tfAge.setText(null);
			tfGender.setText(null);
			tfHome.setText(null);
			tfId.setText(null);
			tfName.setText(null);
			tfTel.setText(null);

		}//end of cleartextfield(){}




		public void getJuminInfo() {

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





		public static void main(String[] args) {

			Inforeview info = new Inforeview();
			info.addLayout(); // addLayout 메소드 호출
			info.eventProc();
			//			info.getJuminInfo();
			//			info.clearTextField();
		}

	}