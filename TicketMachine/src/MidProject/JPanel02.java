package MidProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Enumeration;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

/**
 * @name : 나다윤
 * @date : 2019. 5. 7.
 * @description : 날짜 선택 구현
 */

class JPanel02 extends JPanel {
	JPanelTest win = new JPanelTest();
	private boolean radioFlag = false;
	private String radioText = "";
	private JButton button;
	private ImageDB imageDb = new ImageDB();

	public JPanel02(JPanelTest win) {
		this.win = win;
		setLayout(null);
		win.dao.movieChoice();
		win.dao.dayChoice();
		
		JLabel lblNewLabel = new JLabel("날짜 선택");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel.setBounds(31, 31, 118, 27);
		add(lblNewLabel);

		JLabel poster_Label = new JLabel(""); // 포스터 사진 띄우는 라벨
		int a = (win.dao.dto.getM_id());
		Image ichange = imageDb.imageArray[a].getImage();
		Image newIchange = ichange.getScaledInstance(150, 237, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newI = new ImageIcon(newIchange);

		poster_Label.setIcon(newI);
		System.out.println(win.dao.dto.getM_id());
		poster_Label.setBounds(36, 144, 150, 237);
		add(poster_Label);
		
		// 이민호 2019.05.13 실시간 날짜 버튼
		// 나다윤 2019.05.14 수정
		JRadioButton rb1 = new JRadioButton(win.dao.setterDate(0, "yy/05/dd"));
		rb1.setFont(new Font("굴림", Font.PLAIN, 17));
		JRadioButton rb2 = new JRadioButton(win.dao.setterDate(1, "yy/05/dd"));
		rb2.setFont(new Font("굴림", Font.PLAIN, 17));
		JRadioButton rb3 = new JRadioButton(win.dao.setterDate(2, "yy/05/dd"));
		rb3.setFont(new Font("굴림", Font.PLAIN, 17));
		
		JLabel soldout1 = new JLabel("\uB9E4\uC9C4");
		soldout1.setForeground(Color.RED);
		soldout1.setFont(new Font("굴림", Font.BOLD, 17));
		soldout1.setBounds(678, 188, 82, 27);
		
		JLabel soldout2 = new JLabel("\uB9E4\uC9C4");
		soldout2.setForeground(Color.RED);
		soldout2.setFont(new Font("굴림", Font.BOLD, 17));
		soldout2.setBounds(678, 291, 82, 27);
		
		JLabel soldout3 = new JLabel("\uB9E4\uC9C4");
		soldout3.setForeground(Color.RED);
		soldout3.setFont(new Font("굴림", Font.BOLD, 17));
		soldout3.setBounds(678, 392, 82, 27);

		JLabel label1front = new JLabel(Integer.toString((16 * 3) - win.dao.rest_seat1));
		label1front.setFont(new Font("굴림", Font.PLAIN, 17));
		label1front.setBounds(398, 194, 23, 15);
		add(label1front);
		if((16 * 3) - win.dao.rest_seat1==0){
			rb1.setEnabled(false);
			add(soldout1);
		}

		JLabel label2front = new JLabel(Integer.toString((16 * 3) - win.dao.rest_seat2));
		label2front.setFont(new Font("굴림", Font.PLAIN, 17));
		label2front.setBounds(398, 297, 23, 15);
		add(label2front);
		if((16 * 3) - win.dao.rest_seat2==0){
			rb2.setEnabled(false);
			add(soldout2);
		}

		JLabel label3front = new JLabel(Integer.toString((16 * 3) - win.dao.rest_seat3));
		label3front.setFont(new Font("굴림", Font.PLAIN, 17));
		label3front.setBounds(398, 398, 23, 15);
		add(label3front);
		if((16 * 3) - win.dao.rest_seat3==0){
			rb3.setEnabled(false);
			add(soldout3);
		}

		JLabel label1back = new JLabel(Integer.toString(16 * 3));
		label1back.setFont(new Font("굴림", Font.PLAIN, 17));
		label1back.setBounds(588, 194, 28, 15);
		add(label1back);

		JLabel label2back = new JLabel(Integer.toString(16 * 3));
		label2back.setFont(new Font("굴림", Font.PLAIN, 17));
		label2back.setBounds(588, 297, 57, 15);
		add(label2back);

		JLabel label3back = new JLabel(Integer.toString(16 * 3));
		label3back.setFont(new Font("굴림", Font.PLAIN, 17));
		label3back.setBounds(588, 398, 57, 15);
		add(label3back);

		
		ButtonGroup group = new ButtonGroup(); // 라디오버튼 그룹화를 위한 버튼그룹 설정
												// 같은 그룹끼리는 그룹중에 1개만 선택된다.

		group.add(rb1);
		group.add(rb2);
		group.add(rb3); // 그룹에 그룹화시킬 버튼들을 추가

		rb1.setBounds(236, 181, 89, 41);
		add(rb1);
		rb2.setBounds(236, 284, 89, 41);
		add(rb2);
		rb3.setBounds(236, 385, 89, 41);
		add(rb3);

		// 확인버튼
		button = new JButton("확인");
		button.setFont(new Font("굴림", Font.BOLD, 17));
		button.setBounds(631, 486, 102, 41);
		add(button);
		button.setEnabled(false);

		JLabel lblNewLabel_1 = new JLabel("\uC794\uC5EC\uC88C\uC11D      /           \uC804\uCCB4\uC88C\uC11D");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 17));
		lblNewLabel_1.setBounds(392, 118, 275, 27);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("/");
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 17));
		lblNewLabel_2.setBounds(499, 194, 23, 15);
		add(lblNewLabel_2);

		JLabel label = new JLabel("/");
		label.setFont(new Font("굴림", Font.BOLD, 17));
		label.setBounds(499, 297, 23, 15);
		add(label);

		JLabel label_1 = new JLabel("/");
		label_1.setFont(new Font("굴림", Font.BOLD, 17));
		label_1.setBounds(499, 398, 23, 15);
		add(label_1);

		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setBounds(36, 422, 164, 70);
		add(textArea);
		textArea.setText("영화명   | " + win.dao.dto.getM_name()+"\n"+"상영관   | "+win.dao.dto.getM_locationString()+"관"+"\n"+"러닝타임 | "+win.dao.dto.getM_runningtime()+"시간");
		
		JButton back_btn = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		back_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.moviechoiceview = new MovieChoiceView(win);
				win.change("moviechoiceview");
			}
		});
		back_btn.setFont(new Font("굴림", Font.BOLD, 17));
		back_btn.setBounds(514, 486, 102, 41);
		add(back_btn);
		
		// 리스너 설정
		rb1.addItemListener(new SelectItemListener());
		rb2.addItemListener(new SelectItemListener());
		rb3.addItemListener(new SelectItemListener());

		if (radioFlag) {
			button.setEnabled(true);
		}

		button.addActionListener(new MyActionListener());

	}

	class SelectItemListener implements ItemListener { // 라디오버튼 이벤트 처리
		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			AbstractButton sel = (AbstractButton) e.getItemSelectable();
			if (e.getStateChange() == ItemEvent.SELECTED) {
				radioText = sel.getText();
				win.dao.dto.setM_day(radioText);
				button.setEnabled(true);
				radioFlag = true;
			}
		}
	}

	class MyActionListener implements ActionListener { // 버튼 키 눌리면 패널 3번 호출
		@Override
		public void actionPerformed(ActionEvent e) {
			win.jpanel03 = new JPanel03(win);
			win.change("panel03");
		}
	}
}