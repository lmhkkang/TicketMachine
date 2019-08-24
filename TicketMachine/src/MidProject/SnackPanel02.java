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
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

/**
 * @name : ÀÌ¹ÎÈ£
 * @date : 2019. 5. 9.
 * @description : ½º³¼¸Þ´º2¹øÂ° SnackPanel02
 */

/**
 * @name : ³ª´ÙÀ±
 * @date : 2019. 5. 13.
 * @description : ¹öÆ° Ã³¸® ¼öÁ¤
 */

public class SnackPanel02 extends JPanel {

	private JPanelTest win;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField popcotn_txt;
	private JTextField cola_txt;
	private JTextField hotdog_txt;
	private JTextField beer_txt;
	private JTextField total;

	public SnackPanel02(JPanelTest win) {
		this.win = win;
		setLayout(null);

		JButton btnPopcorn = new JButton("POPCORN ");
		btnPopcorn.setFont(new Font("±¼¸²", Font.BOLD, 17));
		btnPopcorn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPopcorn.setBounds(71, 166, 147, 42);
		add(btnPopcorn);
		btnPopcorn.setEnabled(false);

		JButton btnCocaCola = new JButton("COCA COLA");
		btnCocaCola.setFont(new Font("±¼¸²", Font.BOLD, 17));
		btnCocaCola.setBounds(71, 218, 147, 42);
		add(btnCocaCola);
		btnCocaCola.setEnabled(false);

		JButton btnHotDog = new JButton("HOT DOG");
		btnHotDog.setFont(new Font("±¼¸²", Font.BOLD, 17));
		btnHotDog.setBounds(71, 270, 147, 42);
		add(btnHotDog);
		btnHotDog.setEnabled(false);

		JButton btnBeer = new JButton("BEER");
		btnBeer.setFont(new Font("±¼¸²", Font.BOLD, 17));
		btnBeer.setBounds(71, 326, 147, 42);
		add(btnBeer);
		btnBeer.setEnabled(false);

		textField = new JTextField("8000¿ø");
		textField.setFont(new Font("±¼¸²", Font.BOLD, 17));
		textField.setHorizontalAlignment(JTextField.CENTER);
		textField.setBounds(302, 166, 150, 42);
		add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField("3000¿ø");
		textField_1.setFont(new Font("±¼¸²", Font.BOLD, 17));
		textField_1.setHorizontalAlignment(JTextField.CENTER);
		textField_1.setBounds(302, 220, 150, 42);
		add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField("4000¿ø");
		textField_2.setFont(new Font("±¼¸²", Font.BOLD, 17));
		textField_2.setHorizontalAlignment(JTextField.CENTER);
		textField_2.setBounds(302, 270, 150, 42);
		add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField("5000¿ø");
		textField_3.setFont(new Font("±¼¸²", Font.BOLD, 17));
		textField_3.setHorizontalAlignment(JTextField.CENTER);
		textField_3.setBounds(302, 326, 150, 42);
		add(textField_3);
		textField_3.setColumns(10);

		JButton btnNewButton = new JButton("TOTAL");
		btnNewButton.setFont(new Font("±¼¸²", Font.BOLD, 17));
		btnNewButton.setBounds(71, 384, 147, 42);
		add(btnNewButton);
		btnNewButton.setEnabled(false);

		JButton btnMenu = new JButton("MENU");
		btnMenu.setFont(new Font("±¼¸²", Font.BOLD, 17));
		btnMenu.setBounds(71, 114, 147, 42);
		add(btnMenu);
		btnMenu.setEnabled(false);

		JButton btnCharge = new JButton("CHARGE");
		btnCharge.setFont(new Font("±¼¸²", Font.BOLD, 17));
		btnCharge.setBounds(302, 114, 150, 42);
		add(btnCharge);
		btnCharge.setEnabled(false);

		JButton btnAmount = new JButton("AMOUNT");
		btnAmount.setFont(new Font("±¼¸²", Font.BOLD, 17));
		btnAmount.setBounds(514, 114, 141, 42);
		add(btnAmount);
		btnAmount.setEnabled(false);

		popcotn_txt = new JTextField(Integer.toString(win.sdao.popcornAmount())); // popcorn text field string °ªÀ¸·Î µé¾î°¡¾ßÇÔ
		popcotn_txt.setFont(new Font("±¼¸²", Font.BOLD, 17));
		popcotn_txt.setHorizontalAlignment(JTextField.RIGHT);
		popcotn_txt.setBounds(514, 166, 141, 42);

		add(popcotn_txt);
		popcotn_txt.setColumns(10);

		cola_txt = new JTextField(Integer.toString(win.sdao.cokeAmount())); // coke text field
		cola_txt.setFont(new Font("±¼¸²", Font.BOLD, 17));
		cola_txt.setHorizontalAlignment(JTextField.RIGHT);
		cola_txt.setBounds(514, 218, 141, 42);
		add(cola_txt);
		cola_txt.setColumns(10);

		hotdog_txt = new JTextField(Integer.toString(win.sdao.hotDogAmount())); // hot dog text field
		hotdog_txt.setFont(new Font("±¼¸²", Font.BOLD, 17));
		hotdog_txt.setHorizontalAlignment(JTextField.RIGHT);
		hotdog_txt.setBounds(514, 270, 141, 42);
		add(hotdog_txt);
		hotdog_txt.setColumns(10);

		beer_txt = new JTextField(Integer.toString(win.sdao.beerAmount())); // beer text field
		beer_txt.setFont(new Font("±¼¸²", Font.BOLD, 17));
		beer_txt.setHorizontalAlignment(JTextField.RIGHT);
		beer_txt.setBounds(514, 326, 141, 42);
		add(beer_txt);
		beer_txt.setColumns(10);

		total = new JTextField(Integer.toString(win.sdao.getTotalCharge()));
		total.setFont(new Font("±¼¸²", Font.BOLD, 17));
		total.setHorizontalAlignment(JTextField.RIGHT);
		total.setBounds(302, 384, 353, 42);
		add(total);
		total.setColumns(10);

		JButton button = new JButton("°áÁ¦");
		button.setFont(new Font("±¼¸²", Font.BOLD, 17));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.dao.snack_btn_flag = false;
				win.jpanel05 = new JPanel05(win);
				win.change("panel05");
			}
		});
		button.setBounds(376, 469, 122, 42);
		add(button);

		JButton btnNewButton_1 = new JButton("Ãë¼Ò");
		btnNewButton_1.setFont(new Font("±¼¸²", Font.BOLD, 17));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.sdao.deleteDao();
				win.dao.snack_btn_flag = true;
				win.dao.ticket_btn_flag = true;
				win.change("ticketMainPanel");
			}
		});
		btnNewButton_1.setBounds(533, 469, 122, 42);
		add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("µÚ·Î");
		btnNewButton_2.setFont(new Font("±¼¸²", Font.BOLD, 17));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.change("snackpanel01");
			}
		});
		btnNewButton_2.setBounds(71, 469, 122, 42);
		add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("¿µÈ­¿¹¸Å");
		btnNewButton_3.setFont(new Font("±¼¸²", Font.BOLD, 17));
		btnNewButton_3.setBounds(229, 469, 122, 42);
		add(btnNewButton_3);
		
		JLabel label = new JLabel("\uC7A5\uBC14\uAD6C\uB2C8");
		label.setFont(new Font("±¼¸²", Font.BOLD, 18));
		label.setBounds(30, 30, 118, 27);
		add(label);
		if (!win.dao.ticket_btn_flag) {
			btnNewButton_3.setEnabled(false);
		}
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.dao.snack_btn_flag = false;
				win.moviechoiceview = new MovieChoiceView(win);
				win.change("moviechoiceview");
			}
		});

	}
}
