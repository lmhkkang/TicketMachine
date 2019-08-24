package MidProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JComboBox;

/** @author KITRI
*@name : È«»ç¸í 
*@date : 2019. 5. 7.
*@description : 4¹øÂ°ÆÐ³Î ÀÚ¸®¼±ÅÃ /

/** @name : ³ª´ÙÀ±
*@date : 2019. 5. 8. 
*@description : ÁÂ¼® ¼±ÅÃ ±â´É ±¸Çö
*/

/**
 * @name : ³ª´ÙÀ±
 * @date : 2019. 5. 13.
 * @description : ÁÂ¼® Ãß°¡ ±¸Çö
 */

class JPanel04 extends JPanel { // 4¹øÂ° ÆÐ³Î
	
	private JPanelTest win;
	private JScrollPane jScrollPane1;
	private JButton button;
	int cnt = 0;
	boolean seat_flag[][] = new boolean[4][4];
	JCheckBox[] pCount = new JCheckBox[16];

	public JPanel04(JPanelTest win) {
		
		for (int i = 0; i < 4; i++) {
			Arrays.fill(seat_flag[i], false);
		}
		
		this.win = win;
		
		win.dao.seatChoice();

		setLayout(null);

		JComboBox<Integer> p_num_combo = new JComboBox<Integer>();
		p_num_combo.setBounds(91, 136, 44, 23);
		
				
		//System.out.println(rest + "rest");
		int rest = 16 - win.dao.rest_seat1;
		for (int i = 1; i <= rest; i++) {
			p_num_combo.addItem(i);
		}
		add(p_num_combo);
		JButton check_btn = new JButton("\uD655\uC778");
		check_btn.setFont(new Font("±¼¸²", Font.BOLD, 17));

		JFormattedTextField screen = new JFormattedTextField();
		screen.setHorizontalAlignment(SwingConstants.CENTER);
		screen.setText("screen");
		screen.setBounds(202, 191, 320, 21);
		add(screen);

		// ¿µÈ­ ¼±ÅÃ Ã¼Å©¹Ú½º
		JCheckBox a01_chxbox = new JCheckBox("A01");
		a01_chxbox.setFont(new Font("±¼¸²", Font.PLAIN, 22));
		a01_chxbox.setBounds(202, 233, 82, 41);
		add(a01_chxbox);
		if (win.dao.seat_chk[0][0].equals("Y")) {
			a01_chxbox.setEnabled(false);
		}

		JCheckBox b01_chxbox = new JCheckBox("B01");
		b01_chxbox.setFont(new Font("±¼¸²", Font.PLAIN, 22));
		b01_chxbox.setBounds(288, 233, 82, 41);
		add(b01_chxbox);
		if (win.dao.seat_chk[0][1].equals("Y")) {
			b01_chxbox.setEnabled(false);
		}

		JCheckBox c01_chxbox = new JCheckBox("C01");
		c01_chxbox.setFont(new Font("±¼¸²", Font.PLAIN, 22));
		c01_chxbox.setBounds(374, 233, 82, 41);
		add(c01_chxbox);
		if (win.dao.seat_chk[0][2].equals("Y")) {
			c01_chxbox.setEnabled(false);
		}

		JCheckBox d01_chxbox = new JCheckBox("D01");
		d01_chxbox.setFont(new Font("±¼¸²", Font.PLAIN, 22));
		d01_chxbox.setBounds(460, 233, 82, 41);
		add(d01_chxbox);
		if (win.dao.seat_chk[0][3].equals("Y")) {
			d01_chxbox.setEnabled(false);
		}

		JCheckBox a02_chxbox = new JCheckBox("A02");
		a02_chxbox.setFont(new Font("±¼¸²", Font.PLAIN, 22));
		a02_chxbox.setBounds(202, 276, 82, 41);
		add(a02_chxbox);
		if (win.dao.seat_chk[1][0].equals("Y")) {
			a02_chxbox.setEnabled(false);
		}

		JCheckBox b02_chxbox = new JCheckBox("B02");
		b02_chxbox.setFont(new Font("±¼¸²", Font.PLAIN, 22));
		b02_chxbox.setBounds(288, 276, 82, 41);
		add(b02_chxbox);
		if (win.dao.seat_chk[1][1].equals("Y")) {
			b02_chxbox.setEnabled(false);
		}

		JCheckBox c02_chxbox = new JCheckBox("C02");
		c02_chxbox.setFont(new Font("±¼¸²", Font.PLAIN, 22));
		c02_chxbox.setBounds(374, 276, 82, 41);
		add(c02_chxbox);
		if (win.dao.seat_chk[1][2].equals("Y")) {
			c02_chxbox.setEnabled(false);
		}

		JCheckBox d02_chxbox = new JCheckBox("D02");
		d02_chxbox.setFont(new Font("±¼¸²", Font.PLAIN, 22));
		d02_chxbox.setBounds(460, 276, 82, 41);
		add(d02_chxbox);
		if (win.dao.seat_chk[1][3].equals("Y")) {
			d02_chxbox.setEnabled(false);
		}

		JCheckBox a03_chxbox = new JCheckBox("A03");
		a03_chxbox.setFont(new Font("±¼¸²", Font.PLAIN, 22));
		a03_chxbox.setBounds(202, 319, 82, 41);
		add(a03_chxbox);
		if (win.dao.seat_chk[2][0].equals("Y")) {
			a03_chxbox.setEnabled(false);
		}

		JCheckBox b03_chxbox = new JCheckBox("B03");
		b03_chxbox.setFont(new Font("±¼¸²", Font.PLAIN, 22));
		b03_chxbox.setBounds(288, 319, 82, 41);
		add(b03_chxbox);
		if (win.dao.seat_chk[2][1].equals("Y")) {
			b03_chxbox.setEnabled(false);
		}

		JCheckBox c03_chxbox = new JCheckBox("C03");
		c03_chxbox.setFont(new Font("±¼¸²", Font.PLAIN, 22));
		c03_chxbox.setBounds(374, 319, 82, 41);
		add(c03_chxbox);
		if (win.dao.seat_chk[2][2].equals("Y")) {
			c03_chxbox.setEnabled(false);
		}

		JCheckBox d03_chxbox = new JCheckBox("D03");
		d03_chxbox.setFont(new Font("±¼¸²", Font.PLAIN, 22));
		d03_chxbox.setBounds(460, 319, 82, 41);
		add(d03_chxbox);
		if (win.dao.seat_chk[2][3].equals("Y")) {
			d03_chxbox.setEnabled(false);
		}

		JCheckBox a04_chxbox = new JCheckBox("A04");
		a04_chxbox.setFont(new Font("±¼¸²", Font.PLAIN, 22));
		a04_chxbox.setBounds(202, 362, 82, 41);
		add(a04_chxbox);
		if (win.dao.seat_chk[3][0].equals("Y")) {
			a04_chxbox.setEnabled(false);
		}

		JCheckBox b04_chxbox = new JCheckBox("B04");
		b04_chxbox.setFont(new Font("±¼¸²", Font.PLAIN, 22));
		b04_chxbox.setBounds(288, 362, 82, 41);
		add(b04_chxbox);
		if (win.dao.seat_chk[3][1].equals("Y")) {
			b04_chxbox.setEnabled(false);
		}

		JCheckBox c04_chxbox = new JCheckBox("C04");
		c04_chxbox.setFont(new Font("±¼¸²", Font.PLAIN, 22));
		c04_chxbox.setBounds(374, 362, 82, 41);
		add(c04_chxbox);
		if (win.dao.seat_chk[3][2].equals("Y")) {
			c04_chxbox.setEnabled(false);
		}

		JCheckBox d04_chxbox = new JCheckBox("D04");
		d04_chxbox.setFont(new Font("±¼¸²", Font.PLAIN, 22));
		d04_chxbox.setBounds(460, 362, 82, 41);
		add(d04_chxbox);
		if (win.dao.seat_chk[3][3].equals("Y")) {
			d04_chxbox.setEnabled(false);
		}

		pCount[0] = a01_chxbox;
		pCount[1] = b01_chxbox;
		pCount[2] = c01_chxbox;
		pCount[3] = d01_chxbox;
		pCount[4] = a02_chxbox;
		pCount[5] = b02_chxbox;
		pCount[6] = c02_chxbox;
		pCount[7] = d02_chxbox;
		pCount[8] = a03_chxbox;
		pCount[9] = b03_chxbox;
		pCount[10] = c03_chxbox;
		pCount[11] = d03_chxbox;
		pCount[12] = a04_chxbox;
		pCount[13] = b04_chxbox;
		pCount[14] = c04_chxbox;
		pCount[15] = d04_chxbox;

		check_btn.setBounds(586, 486, 107, 41);
		add(check_btn);
		check_btn.setEnabled(false);

		JLabel label = new JLabel("\uC88C\uC11D \uC120\uD0DD");
		label.setFont(new Font("±¼¸²", Font.BOLD, 18));
		label.setBounds(32, 31, 118, 27);
		add(label);

		JLabel lblNewLabel = new JLabel(
				"\uC608\uB9E4\uD560 \uC88C\uC11D \uC218\uB97C \uC120\uD0DD\uD574\uC8FC\uC138\uC694");
		lblNewLabel.setFont(new Font("±¼¸²", Font.PLAIN, 13));
		lblNewLabel.setBounds(91, 105, 224, 15);
		add(lblNewLabel);

		a01_chxbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (seat_flag[0][0]) {
					seat_flag[0][0] = false;
					cnt -= 1;
				} else {
					cnt += 1;
					seat_flag[0][0] = true;
				}
				int t = (int) p_num_combo.getSelectedItem();
				if (cnt == t) {
					check_btn.setEnabled(true);
				} else {
					check_btn.setEnabled(false);
				}
			}
		});
		
		b01_chxbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (seat_flag[0][1]) {
					seat_flag[0][1] = false;
					cnt -= 1;
				} else {
					cnt += 1;
					seat_flag[0][1] = true;
				}
				int t = (int) p_num_combo.getSelectedItem();
				if (cnt == t) {
					check_btn.setEnabled(true);
				} else {
					check_btn.setEnabled(false);
				}
			}
		});
		
		c01_chxbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (seat_flag[0][2]) {
					seat_flag[0][2] = false;
					cnt -= 1;
				} else {
					cnt += 1;
					seat_flag[0][2] = true;
				}
				int t = (int) p_num_combo.getSelectedItem();
				if (cnt == t) {
					check_btn.setEnabled(true);
				} else {
					check_btn.setEnabled(false);
				}
			}
		});
		
		d01_chxbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (seat_flag[0][3]) {
					seat_flag[0][3] = false;
					cnt -= 1;
				} else {
					cnt += 1;
					seat_flag[0][3] = true;
				}
				int t = (int) p_num_combo.getSelectedItem();
				if (cnt == t) {
					check_btn.setEnabled(true);
				} else {
					check_btn.setEnabled(false);
				}
			}
		});
		//
		a02_chxbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (seat_flag[1][0]) {
					seat_flag[1][0] = false;
					cnt -= 1;
				} else {
					cnt += 1;
					seat_flag[1][0] = true;
				}
				int t = (int) p_num_combo.getSelectedItem();
				if (cnt == t) {
					check_btn.setEnabled(true);
				} else {
					check_btn.setEnabled(false);
				}
			}
		});
		
		b02_chxbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (seat_flag[1][1]) {
					seat_flag[1][1] = false;
					cnt -= 1;
				} else {
					cnt += 1;
					seat_flag[1][1] = true;
				}
				int t = (int) p_num_combo.getSelectedItem();
				if (cnt == t) {
					check_btn.setEnabled(true);
				} else {
					check_btn.setEnabled(false);
				}
			}
		});
		
		c02_chxbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (seat_flag[1][2]) {
					seat_flag[1][2] = false;
					cnt -= 1;
				} else {
					cnt += 1;
					seat_flag[1][2] = true;
				}
				int t = (int) p_num_combo.getSelectedItem();
				if (cnt == t) {
					check_btn.setEnabled(true);
				} else {
					check_btn.setEnabled(false);
				}
			}
		});
		
		d02_chxbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (seat_flag[1][3]) {
					seat_flag[1][3] = false;
					cnt -= 1;
				} else {
					cnt += 1;
					seat_flag[1][3] = true;
				}
				int t = (int) p_num_combo.getSelectedItem();
				if (cnt == t) {
					check_btn.setEnabled(true);
				} else {
					check_btn.setEnabled(false);
				}
			}
		});
		//
		a03_chxbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (seat_flag[2][0]) {
					seat_flag[2][0] = false;
					cnt -= 1;
				} else {
					cnt += 1;
					seat_flag[2][0] = true;
				}
				int t = (int) p_num_combo.getSelectedItem();
				if (cnt == t) {
					check_btn.setEnabled(true);
				} else {
					check_btn.setEnabled(false);
				}
			}
		});
		
		b03_chxbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (seat_flag[2][1]) {
					seat_flag[2][1] = false;
					cnt -= 1;
				} else {
					cnt += 1;
					seat_flag[2][1] = true;
				}
				int t = (int) p_num_combo.getSelectedItem();
				if (cnt == t) {
					check_btn.setEnabled(true);
				} else {
					check_btn.setEnabled(false);
				}
			}
		});
		
		c03_chxbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (seat_flag[2][2]) {
					seat_flag[2][2] = false;
					cnt -= 1;
				} else {
					cnt += 1;
					seat_flag[2][2] = true;
				}
				int t = (int) p_num_combo.getSelectedItem();
				if (cnt == t) {
					check_btn.setEnabled(true);
				} else {
					check_btn.setEnabled(false);
				}
			}
		});
		
		d03_chxbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (seat_flag[2][3]) {
					seat_flag[2][3] = false;
					cnt -= 1;
				} else {
					cnt += 1;
					seat_flag[2][3] = true;
				}
				int t = (int) p_num_combo.getSelectedItem();
				if (cnt == t) {
					check_btn.setEnabled(true);
				} else {
					check_btn.setEnabled(false);
				}
			}
		});
		//
		a04_chxbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (seat_flag[3][0]) {
					seat_flag[3][0] = false;
					cnt -= 1;
				} else {
					cnt += 1;
					seat_flag[3][0] = true;
				}
				int t = (int) p_num_combo.getSelectedItem();
				if (cnt == t) {
					check_btn.setEnabled(true);
				} else {
					check_btn.setEnabled(false);
				}
			}
		});
		
		b04_chxbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (seat_flag[3][1]) {
					seat_flag[3][1] = false;
					cnt -= 1;
				} else {
					cnt += 1;
					seat_flag[3][1] = true;
				}
				int t = (int) p_num_combo.getSelectedItem();
				if (cnt == t) {
					check_btn.setEnabled(true);
				} else {
					check_btn.setEnabled(false);
				}
			}
		});
		
		c04_chxbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (seat_flag[3][2]) {
					seat_flag[3][2] = false;
					cnt -= 1;
				} else {
					cnt += 1;
					seat_flag[3][2] = true;
				}
				int t = (int) p_num_combo.getSelectedItem();
				if (cnt == t) {
					check_btn.setEnabled(true);
				} else {
					check_btn.setEnabled(false);
				}
			}
		});
		
		d04_chxbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (seat_flag[3][3]) {
					seat_flag[3][3] = false;
					cnt -= 1;
				} else {
					cnt += 1;
					seat_flag[3][3] = true;
				}
				int t = (int) p_num_combo.getSelectedItem();
				if (cnt == t) {
					check_btn.setEnabled(true);
				} else {
					check_btn.setEnabled(false);
				}
			}
		});

		JButton back_btn = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		back_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.jpanel03 = new JPanel03(win);
				win.change("panel03");
			}
		});
		back_btn.setFont(new Font("±¼¸²", Font.BOLD, 17));
		back_btn.setBounds(472, 486, 102, 41);
		add(back_btn);

		// ÀÚ¸®¸¦ ÀúÀåÇÒ ¹è¿­

		check_btn.addActionListener(new MyActionListener4());

	}

	class MyActionListener4 implements ActionListener {

		// ¹öÆ° Å° ´­¸®¸é ÆÐ³Î 4¹ø È£Ãâ

		@Override
		public void actionPerformed(ActionEvent e) {
			int cnt = 0;
			ArrayList<String> tmp = new ArrayList<String>();
			for (int i = 0; i < pCount.length; i++) {
				if (pCount[i].isSelected() == true) {
					tmp.add(pCount[i].getText());
					cnt++;
				}
			}
			win.dao.ticket_btn_flag=false;
			win.dao.dto.setM_seat(tmp);
			win.dao.dto.setNum_of_people(cnt);
			//System.out.println(win.dao.dto.getM_seat());
			win.jpanel05 = new JPanel05(win);
			win.change("panel05");
		}
	}

	public int seatCount(JCheckBox[] pCount) {// ¼±ÅÃµÈ °¹¼ö È®ÀÎ
		int cnt = 0;

		for (int i = 0; i < pCount.length; i++) {
			if (pCount[i].isSelected() == true) {
				cnt++;
			}
		}
		
		return cnt;
	}
}