package MidProject;

import javax.swing.JFrame;

public class JPanelMain extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JPanelTest win = new JPanelTest();
		
		win.setLocation(100, 100);
		win.setTitle("Main");
		win.ticketMainPanel = new TicketMainPanel(win);
		win.getContentPane().add(win.ticketMainPanel);
		win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		win.setSize(820, 620);
		win.setVisible(true);
		
	}
}
