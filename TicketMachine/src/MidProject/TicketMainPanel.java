package MidProject;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author KITRI
 * @name : 홍사명 @date : 2019. 5. 9.
 * @description : 메인화면
 */

class TicketMainPanel extends JPanel {
	private JPanelTest win;
	private TicketDao dao;

	public TicketMainPanel(JPanelTest win) {
		this.win = win;
		setLayout(null);

		ImageIcon i = new ImageIcon(TicketMainPanel.class.getResource("/MidProject/background.png"));
		Image ichange = i.getImage();
		Image newIchange = ichange.getScaledInstance(800, 600, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newI = new ImageIcon(newIchange);

		JButton b1 = new JButton("예매");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.moviechoiceview = new MovieChoiceView(win);
				win.change("moviechoiceview");
			}
		});
		b1.setFont(new Font("굴림", Font.BOLD, 25));
		b1.setBounds(84, 365, 97, 48);
		b1.setContentAreaFilled(false);
		b1.setBorderPainted(false);
		add(b1);

		JButton b2 = new JButton("조회");
		b2.setFont(new Font("굴림", Font.BOLD, 25));
		b2.setContentAreaFilled(false);
		b2.setBorderPainted(false);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.jpanel01 = new JPanel01(win);
				win.change("panel01");
			}
		});
		b2.setBounds(350, 365, 97, 48);
		add(b2);

		JButton b3 = new JButton("스낵");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.snackpanel01 = new SnackPanel01(win);
				win.change("snackpanel01");
			}
		});
		b3.setFont(new Font("굴림", Font.BOLD, 25));
		b3.setContentAreaFilled(false);
		b3.setBorderPainted(false);
		b3.setBounds(608, 365, 97, 48);
		add(b3);
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(newI);
		lblNewLabel.setBounds(0, 0, 794, 567);
		add(lblNewLabel);
		dao = new TicketDao();

	}

	class MyActionListener3 implements ActionListener { // 버튼 키 눌리면 패널 2번 호출
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("panel03");
		}
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}