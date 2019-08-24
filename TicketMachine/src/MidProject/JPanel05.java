package MidProject;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

/**
 * @name : �̹�ȣ
 * @date : 2019. 5. 9.
 * @description : ����â paypanel01
 */

/**
 * @name : ������
 * @date : 2019. 5. 13.
 * @description : ��ư enable ó�� �� ����
 */

public class JPanel05 extends JPanel {
	
	private JTextField textField;
	private JPanelTest win;
	private JTextArea textarea;

	public JPanel05(JPanelTest win) {
		
		this.win = win;
		setLayout(null);

		JLabel lblNewLabel = new JLabel("<\uACB0\uC81C\uC815\uBCF4>");
		lblNewLabel.setFont(new Font("����", Font.BOLD, 16));
		lblNewLabel.setBounds(304, 70, 117, 40);
		add(lblNewLabel);

		JButton cancle_btn = new JButton("HOME���� ���ư���");
		cancle_btn.setFont(new Font("����", Font.BOLD, 17));
		cancle_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.jpanel02 = null;
				win.snackpanel02 = null;
				win.dao.snack_btn_flag = true;
				win.dao.ticket_btn_flag = true;
				win.dao.deleteDao();
				win.sdao.deleteDao();
				win.change("ticketMainPanel");
			}
		});

		cancle_btn.setBounds(427, 491, 229, 41);
		add(cancle_btn);

		JButton snack_btn = new JButton("����");
		snack_btn.setFont(new Font("����", Font.BOLD, 17));
		snack_btn.setBounds(297, 491, 107, 41);
		add(snack_btn);
		if (!win.dao.snack_btn_flag) {
			snack_btn.setEnabled(false);
		}
		snack_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.dao.ticket_btn_flag = false;
				win.dao.snack_btn_flag = false;
				win.snackpanel01 = new SnackPanel01(win);
				win.change("snackpanel01");
			}
		});

		textarea = new JTextArea();
		textarea.setEditable(false);
		textarea.setBounds(256, 120, 191, 308);
		add(textarea);
		textarea.setColumns(10);
		win.dao.printMovieInfo(textarea);
		win.sdao.printSnackInfo(textarea);
		textarea.append("====================================\n");
		textarea.append("�� �ݾ�: " + Integer.toString(win.dao.getTotalCharge() + win.sdao.getTotalCharge()));

		JButton pay_btn = new JButton("�����ϱ�");
		pay_btn.setFont(new Font("����", Font.BOLD, 17));
		pay_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (!win.dao.snack_btn_flag && !win.dao.ticket_btn_flag) {// Ƽ�� o ���� o
					
					win.dao.insertTicketInfo();
					win.dao.insertSeat();
					win.dao.insertPayTable(win.sdao.getTotalCharge());
					win.sdao.insertSnackOrder(win.sdao.popcornAmount(), win.sdao.cokeAmount(), win.sdao.hotDogAmount(),
							win.sdao.beerAmount()); // Ƽ���̶� ������ģ ����(���������� �����)
					
				} else if (win.dao.snack_btn_flag && !win.dao.ticket_btn_flag) { // Ƽ�� o����x
					
					win.dao.insertTicketInfo();
					win.dao.insertSeat();
					win.dao.insertPayTable(win.sdao.getTotalCharge());
					
				} else if (!win.dao.snack_btn_flag && win.dao.ticket_btn_flag) {// Ƽ��x ����o
					
					win.sdao.insertPayinfo();// ������ ��ģ����
					win.sdao.insertSnackOrder(win.sdao.popcornAmount(), win.sdao.cokeAmount(), win.sdao.hotDogAmount(),
							win.sdao.beerAmount());

				}
				
				win.sdao.deleteDao(); // dto�ʱ�ȭ
				
				pay_btn.setEnabled(false);
				snack_btn.setEnabled(false);

			}
		});

		pay_btn.setBounds(166, 491, 107, 41);
		add(pay_btn);

		JLabel label = new JLabel("\uACB0\uC81C");
		label.setFont(new Font("����", Font.BOLD, 18));
		label.setBounds(31, 29, 118, 27);
		add(label);
		
	}
}
