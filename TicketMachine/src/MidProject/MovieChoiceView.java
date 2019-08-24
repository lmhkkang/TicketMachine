package MidProject;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Group;
import MidProject.JPanel02.SelectItemListener;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.ImageIcon;
import java.awt.Font;

public class MovieChoiceView extends JPanel {
	private JPanelTest win;
	private boolean rFlag = false;
	private String radioText;
	private JButton btnNewButton;
	private int[] cnt;
	private int choice = 0;
	private Image ichange;
	private Image newIchange;
	private ImageIcon newI;
	private String[] abc;
	private int[] copyabc;

	public MovieChoiceView(JPanelTest win) {
		this.win = win;
		setLayout(null);

		ImageDB imageDb = new ImageDB();

		JLabel A_label = new JLabel("New label");

		A_label.setBounds(95, 91, 97, 137);
		add(A_label);

		JLabel lblNewLabel_1 = new JLabel("New label");

		lblNewLabel_1.setBounds(331, 91, 97, 137);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("New label");

		lblNewLabel_2.setBounds(585, 91, 97, 137);
		add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("New label");

		lblNewLabel_3.setBounds(95, 297, 97, 137);
		add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("New label");

		lblNewLabel_4.setBounds(331, 297, 97, 137);
		add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("\uC0C1\uC601\uBBF8\uC815");
		lblNewLabel_5.setBounds(585, 297, 97, 137);
		add(lblNewLabel_5);

		JLabel[] l = { null, A_label, lblNewLabel_1, lblNewLabel_2, lblNewLabel_3, lblNewLabel_4, lblNewLabel_5 };

		for (int i = 1; i <= 6 ; i++) {
			Image ichange = imageDb.imageArray[i].getImage();
			Image newIchange = ichange.getScaledInstance(97, 139, java.awt.Image.SCALE_SMOOTH);
			ImageIcon newI = new ImageIcon(newIchange);
			l[i].setIcon(newI);
		}

		JRadioButton RButton = new JRadioButton("A");
		RButton.setFont(new Font("굴림", Font.BOLD, 16));
		RButton.setBounds(95, 234, 121, 23);
		add(RButton);

		JRadioButton rdbtnB = new JRadioButton("B");
		rdbtnB.setFont(new Font("굴림", Font.BOLD, 16));
		rdbtnB.setBounds(331, 234, 121, 23);
		add(rdbtnB);

		JRadioButton rdbtnC = new JRadioButton("C");
		rdbtnC.setFont(new Font("굴림", Font.BOLD, 16));
		rdbtnC.setBounds(586, 234, 121, 23);
		add(rdbtnC);

		JRadioButton rdbtnD = new JRadioButton("D");
		rdbtnD.setFont(new Font("굴림", Font.BOLD, 16));
		rdbtnD.setBounds(95, 440, 121, 23);
		add(rdbtnD);

		JRadioButton rdbtnE = new JRadioButton("E");
		rdbtnE.setFont(new Font("굴림", Font.BOLD, 16));
		rdbtnE.setBounds(331, 440, 121, 23);
		add(rdbtnE);

		JRadioButton rdbtnF = new JRadioButton("F");
		rdbtnF.setFont(new Font("굴림", Font.BOLD, 16));
		rdbtnF.setBounds(585, 440, 121, 23);
		add(rdbtnF);
		
		JRadioButton t_rbtn = new JRadioButton("");
		t_rbtn.setBounds(456, 91, 121, 23);
		//add(t_rbtn);

		RButton.addItemListener(new SelectItemListener());
		rdbtnB.addItemListener(new SelectItemListener());
		rdbtnC.addItemListener(new SelectItemListener());
		rdbtnD.addItemListener(new SelectItemListener());
		rdbtnE.addItemListener(new SelectItemListener());
		rdbtnF.addItemListener(new SelectItemListener());

		ButtonGroup mcButtonG = new ButtonGroup();
		mcButtonG.add(RButton);
		mcButtonG.add(rdbtnB);
		mcButtonG.add(rdbtnC);
		mcButtonG.add(rdbtnD);
		mcButtonG.add(rdbtnE);
		mcButtonG.add(rdbtnF);
		mcButtonG.add(t_rbtn);

		JButton btnHome = new JButton("home");
		btnHome.setFont(new Font("굴림", Font.BOLD, 17));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.dao.deleteDao();
				win.change("ticketMainPanel");
			}
		});
		btnHome.setBounds(276, 500, 102, 41);
		add(btnHome);

		btnNewButton = new JButton("확인");
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(win.dao.dto.getM_name());
				win.jpanel02 = new JPanel02(win);
				win.change("panel02");
			}
		});
		btnNewButton.setBounds(384, 500, 102, 41);
		btnNewButton.setVisible(rFlag);
		add(btnNewButton);

		JLabel label = new JLabel("\uC601\uD654 \uC120\uD0DD");
		label.setFont(new Font("굴림", Font.BOLD, 18));
		label.setBounds(31, 31, 118, 27);
		add(label);

		cnt = new int[win.dao.movieCount()]; // 영화별 정렬된 순서를 기억하기위한 배열
		String[] rename = new String[win.dao.movieCount()];// 정렬된 이름을 기억하기 위한 배열
		cnt = win.dao.rankCount(cnt.length);// 예매횟수별로 정렬된 순서 저장하는 배열
		JRadioButton[] b = { RButton, rdbtnB, rdbtnC, rdbtnD, rdbtnE, rdbtnF, t_rbtn }; // 라디오 버튼을 담는 배열

		abc = new String[cnt.length];
		abc = win.dao.dbGetName(cnt.length);

		for (int i = 0; i < cnt.length; i++) {
			rename[i] = win.dao.rankname(cnt[i]);
		}
		
		copyabc = win.dao.indexSerch(abc);
		JButton btnSort = new JButton("개봉일순");

		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < b.length; i++) {
					//System.out.println(i);
					b[i].setSelected(true);
				}
				btnNewButton.setVisible(false);
				
				switch (choice) {
				
				case 0:
					
					for (int i = 0; i < rename.length; i++) {
						b[i].setText(rename[i]);// 정렬된것들을 표현해주는
						int tmp = cnt[i];
						ichange = imageDb.imageArray[tmp].getImage();
						newIchange = ichange.getScaledInstance(97, 139, java.awt.Image.SCALE_SMOOTH);
						newI = new ImageIcon(newIchange);
						l[i + 1].setIcon(newI);
					}
					btnSort.setText("예매순");
					choice++;
					break;

				case 1:

					win.dao.movieNameLoad(b);
					for (int i = 1; i < win.dao.movieCount() + 1; i++) {
						ichange = imageDb.imageArray[i].getImage();
						newIchange = ichange.getScaledInstance(97, 139, java.awt.Image.SCALE_SMOOTH);
						newI = new ImageIcon(newIchange);
						l[i].setIcon(newI);
					}
					btnSort.setText("개봉일순");
					choice = 0;
					break;

				}

			}
		});
		btnSort.setBounds(331, 34, 97, 23);
		add(btnSort);
		
		JLabel lblNewLabel = new JLabel("1.");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setBounds(65, 91, 18, 15);
		add(lblNewLabel);
		
		JLabel label_1 = new JLabel("2.");
		label_1.setFont(new Font("굴림", Font.BOLD, 15));
		label_1.setBounds(301, 91, 18, 15);
		add(label_1);
		
		JLabel label_2 = new JLabel("3.");
		label_2.setFont(new Font("굴림", Font.BOLD, 15));
		label_2.setBounds(555, 91, 18, 15);
		add(label_2);
		
		JLabel label_3 = new JLabel("4.");
		label_3.setFont(new Font("굴림", Font.BOLD, 15));
		label_3.setBounds(65, 297, 18, 15);
		add(label_3);
		
		JLabel label_4 = new JLabel("5.");
		label_4.setFont(new Font("굴림", Font.BOLD, 15));
		label_4.setBounds(301, 297, 18, 15);
		add(label_4);
		
		JLabel label_5 = new JLabel("6.");
		label_5.setFont(new Font("굴림", Font.BOLD, 15));
		label_5.setBounds(555, 297, 18, 15);
		add(label_5);
		
		
		win.dao.movieNameLoad(b);// DB에 있는 영화제목을 로드해서 출력해주는 함수

	}

	class SelectItemListener implements ItemListener { // 라디오버튼 이벤트 처리
		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			AbstractButton sel = (AbstractButton) e.getItemSelectable();
			if (e.getStateChange() == ItemEvent.SELECTED) {
				radioText = sel.getText();
				win.dao.dto.setM_name(radioText);
				rFlag = true;
				btnNewButton.setVisible(rFlag);
			}
		}

	}
}