package MidProject;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class JPanelTest extends JFrame {

	public JPanelTest() {}

	public static boolean p_chk = false;
	public JPanel01 jpanel01 = null;
	public JPanel02 jpanel02 = null;
	public JPanel03 jpanel03 = null;
	public JPanel04 jpanel04 = null;
	public JPanel05 jpanel05 = null;
	public SnackPanel01 snackpanel01 = null;
	public SnackPanel02 snackpanel02 = null;
	public TicketMainPanel ticketMainPanel = null;
	public MovieChoiceView moviechoiceview = null;
	public ReservationDao dao = new ReservationDao();
	public SnackDao sdao = new SnackDao();

	public void changePage(Component obj) {
		getContentPane().removeAll();
		getContentPane().add(obj);
		revalidate();
		repaint();
	}

	public void change(String panelName) { // 패널 1~4번까지 설정

		switch (panelName) {
		case "panel01":
			changePage(jpanel01);
			break;
		case "panel02":
			changePage(jpanel02);
			break;
		case "panel03":
			changePage(jpanel03);
			break;
		case "panel04":
			// dialog.setVisible(true);
			changePage(jpanel04);
			break;
		case "panel05":
			// dialog.setVisible(true);
			changePage(jpanel05);
			break;
		case "snackpanel01":
			changePage(snackpanel01);
			break;
		case "snackpanel02":
			changePage(snackpanel02);
			break;
		case "ticketMainPanel":
			changePage(ticketMainPanel);
			break;
		case "moviechoiceview":
			changePage(moviechoiceview);
			break;

		}

	}

}