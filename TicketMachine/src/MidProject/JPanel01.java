package MidProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;


/**
 *@author KITRI
 *@name : ȫ���
 *@date : 2019. 5. 8.
 *@description : ����Ȯ�� ��� â
 */

class JPanel01 extends JPanel{
    private TicketDao dao;
    
    private JPanelTest win;
    private JScrollPane scrollPane;
    
    private JTextField txtA;
    private JTextField txtB;
   
    private JButton Idbutton;
    private JButton PhoneButton;
    private JButton btnNewButton;
    private JButton btnHome;
    private JButton btnD;
    
    private JComboBox<String> comboBox;
    // private Ttimer th;
    private boolean check=false; //�˻���� ������ �˱����� ����

    
    public void JPanel01() {}
    
    public JPanel01(JPanelTest win){

           this.win = win;
           setLayout(null);
           
           JTextArea textArea = new JTextArea();
           textArea.setEditable(false);
           textArea.setBounds(178, 255, 390, 203);
           add(textArea);

           PhoneButton = new JButton("��ȭ��ȣ�˻�");
           PhoneButton.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                 dao=new TicketDao();
                 check =dao.phoneSerch(textArea,txtA.getText());
                 btnD.setEnabled(check);
                 btnNewButton.setEnabled(check);
                 
                 txtB.setText("");

                 dao.pComboInsert(comboBox);

              }
           });
           
           scrollPane = new JScrollPane(textArea);
           scrollPane.setBounds(178, 255, 390, 203);
           add(scrollPane);
           
           PhoneButton.setSize(176,30);        
           PhoneButton.setLocation(585, 113);
           add(PhoneButton);
           
           txtA = new JTextField();
           txtA.setBounds(178, 111, 390, 35);
           add(txtA);
           txtA.setColumns(10);
           
           txtB = new JTextField();
           txtB.setBounds(177, 169, 391, 35);
           add(txtB);
           txtB.setColumns(10);
           
           Idbutton = new JButton("\uC608\uB9E4\uBC88\uD638\uAC80\uC0C9");
           Idbutton.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                 
                 dao=new TicketDao();
                 //�˻������� ������ ���� ��ư ����
                 
                 check=dao.tIdSerch(textArea,txtB.getText());
                 btnD.setEnabled(check);
                 btnNewButton.setEnabled(check);
                 
                 dao.tComboInsert(comboBox);
                 
                 txtA.setText("");

                 
              }
           });
           
           Idbutton.setBounds(585, 169, 176, 30);
           add(Idbutton);
           
           btnD = new JButton("���");
           btnD.setEnabled(false);
           btnD.setBounds(286, 502, 97, 41);
           add(btnD);
           
           btnNewButton = new JButton("�������");
           btnNewButton.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                 dao.ticketDelete(comboBox, textArea);
                 
              }
           });
           btnNewButton.setEnabled(false);
           btnNewButton.setBounds(716, 252,  82, 30);
           add(btnNewButton);
           
           comboBox = new JComboBox<String>();
           comboBox.setBounds(585, 252, 119, 30);
           add(comboBox);
           
           btnHome = new JButton("home");
           btnHome.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                 win.change("ticketMainPanel");
                 win.dao.deleteDao();
              }
           });
           
           JLabel label = new JLabel("\uC608\uB9E4 \uC870\uD68C");
           label.setFont(new Font("����", Font.BOLD, 18));
           label.setBounds(31, 31, 118, 27);
           add(label);
           btnHome.setBounds(393, 502, 97, 41);
           add(btnHome);
           
           //�˾����� �޴�
           
           
           
    }
}