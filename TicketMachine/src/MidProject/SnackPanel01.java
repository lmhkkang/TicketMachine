package MidProject;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextPane;

import javax.swing.JTextField;
import javax.swing.JComboBox;

/**
 * @name : �̹�ȣ
 * @date : 2019. 5. 8.
 * @description : SnackPanel01 - �޴�����page1
 */

public class SnackPanel01 extends JPanel { // 2019.05.13 ������ �� �ѱ�� ����

	private JPanelTest win;
	private SnackDao dao = new SnackDao();
	int popcornAmount;
	int cokeAmount;
	int hotDogAmount;
	int beerAmount;
	String[] arr = null;
	JComboBox<Integer> comboBox;
	JComboBox<Integer> comboBox_1;
	JComboBox<Integer> comboBox_2;
	JComboBox<Integer> comboBox_3;
	int popcnt;// ���ܹ�ư�������� 1������
	int cokecnt;
	int hotdogcnt;
	int beercnt;

	public SnackPanel01(JPanelTest win) {

		this.win = win;
		setLayout(null);

		Integer[] amount = new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		JButton button = new JButton("����");
		button.setFont(new Font("����", Font.BOLD, 17));
		button.setBounds(129, 289, 90, 30);
		add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (popcnt == 10) {
					popcnt = 0;
				}
				popcnt++;
				comboBox.setSelectedIndex(popcnt);
				win.sdao.setPopcorn(popcornAmount);
			}
		});
		JButton button_1 = new JButton("�ݶ�");
		button_1.setFont(new Font("����", Font.BOLD, 17));
		button_1.setBounds(483, 289, 84, 30);
		add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cokecnt == 10) {
					cokecnt = 0;
				}
				cokecnt++;
				comboBox_2.setSelectedIndex(cokecnt);
				win.sdao.setCoke(cokeAmount);
			}
		});

		JButton button_2 = new JButton("�ֵ���");
		button_2.setFont(new Font("����", Font.BOLD, 17));
		button_2.setBounds(129, 494, 90, 29);
		add(button_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (hotdogcnt == 10) {
					hotdogcnt = 0;
				}
				hotdogcnt++;
				comboBox_1.setSelectedIndex(hotdogcnt);
				win.sdao.setHotDog(hotDogAmount);
			}
		});

		JButton button_3 = new JButton("����");
		button_3.setFont(new Font("����", Font.BOLD, 17));
		button_3.setBounds(483, 493, 84, 30);
		add(button_3);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (beercnt == 10) {
					beercnt = 0;
				}
				beercnt++;
				comboBox_3.setSelectedIndex(beercnt);
				win.sdao.setBeer(beerAmount);
			}
		});

		JLabel poster_Label = new JLabel(""); // ���ܶ�
		poster_Label.setIcon(new ImageIcon(SnackPanel01.class.getResource("/MidProject/popcorn.jpg")));
		poster_Label.setBounds(104, 94, 169, 149);
		add(poster_Label);

		JLabel poster_Label_1 = new JLabel(""); // �ݶ��
		poster_Label_1.setIcon(new ImageIcon(SnackPanel01.class.getResource("/MidProject/coke.jpg")));
		poster_Label_1.setBounds(472, 122, 104, 132);
		add(poster_Label_1);

		JLabel poster_Label_2 = new JLabel(""); // �ֵ��׶�
		poster_Label_2.setIcon(new ImageIcon(SnackPanel01.class.getResource("/MidProject/hotdog.jpg")));
		poster_Label_2.setBounds(104, 329, 142, 121);
		add(poster_Label_2);

		comboBox = new JComboBox(amount); // ���� ����ڽ� 0~10
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				popcornAmount = (int) comboBox.getSelectedIndex();
				System.out.println("���� ���");
				win.sdao.setPopcorn(popcornAmount);
			}
		});
		comboBox.setBounds(235, 294, 49, 23);
		add(comboBox);

		comboBox_1 = new JComboBox(amount); // �ֵ��� ����ڽ� 0~10
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hotDogAmount = (int) comboBox_1.getSelectedIndex();
				System.out.println("�ֵ��� ���");
				win.sdao.setHotDog(hotDogAmount);
			}
		});
		comboBox_1.setBounds(235, 498, 49, 23);
		add(comboBox_1);

		comboBox_2 = new JComboBox(amount); // �ݶ� ����ڽ� 0~10
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cokeAmount = (int) comboBox_2.getSelectedIndex();
				System.out.println("�ݶ� ���");
				win.sdao.setCoke(cokeAmount);
			}

		});
		comboBox_2.setBounds(579, 294, 49, 23);
		add(comboBox_2);

		comboBox_3 = new JComboBox(amount); // ���� ����ڽ� 0~10
		comboBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				beerAmount = (int) comboBox_3.getSelectedIndex();
				System.out.println("���� ���");
				win.sdao.setBeer(beerAmount);
			}
		});
		comboBox_3.setBounds(579, 498, 49, 23);
		add(comboBox_3);

		JButton button_4 = new JButton("�ֹ��ϱ�");
		button_4.setFont(new Font("����", Font.BOLD, 17));
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				win.sdao.print();
				win.snackpanel02 = new SnackPanel02(win);
				win.change("snackpanel02");
			}// �ֹ��ϱ��ư�� ������ db insert���� �����ؾ���
		});
		button_4.setBounds(658, 486, 113, 37);
		add(button_4);

		JLabel label_1 = new JLabel("8000\uC6D0");
		label_1.setFont(new Font("����", Font.BOLD, 15));
		label_1.setBounds(155, 253, 64, 26);
		add(label_1);

		JLabel label_2 = new JLabel("3000\uC6D0");
		label_2.setFont(new Font("����", Font.BOLD, 15));
		label_2.setBounds(504, 253, 63, 26);
		add(label_2);

		JLabel label_3 = new JLabel("4000\uC6D0");
		label_3.setFont(new Font("����", Font.BOLD, 15));
		label_3.setBounds(155, 466, 57, 18);
		add(label_3);

		JLabel label_4 = new JLabel("5000\uC6D0");
		label_4.setFont(new Font("����", Font.BOLD, 15));
		label_4.setBounds(504, 465, 57, 18);
		add(label_4);
		
		JLabel label = new JLabel("\uBA54\uB274 \uC120\uD0DD");
		label.setFont(new Font("����", Font.BOLD, 18));
		label.setBounds(32, 30, 118, 27);
		add(label);
		
				JLabel poster_Label_3 = new JLabel(""); // ���ֶ�
				poster_Label_3.setIcon(new ImageIcon(SnackPanel01.class.getResource("/MidProject/beer.jpg")));
				poster_Label_3.setBounds(504, 329, 57, 149);
				add(poster_Label_3);

	}
}