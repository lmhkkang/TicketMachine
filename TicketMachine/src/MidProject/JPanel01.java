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
 *@name : 홍사명
 *@date : 2019. 5. 8.
 *@description : 예매확인 취소 창
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
    private boolean check=false; //검색결과 유무를 알기위한 변수

    
    public void JPanel01() {}
    
    public JPanel01(JPanelTest win){

           this.win = win;
           setLayout(null);
           
           JTextArea textArea = new JTextArea();
           textArea.setEditable(false);
           textArea.setBounds(178, 255, 390, 203);
           add(textArea);

           PhoneButton = new JButton("전화번호검색");
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
                 //검색데이터 유무에 따른 버튼 유무
                 
                 check=dao.tIdSerch(textArea,txtB.getText());
                 btnD.setEnabled(check);
                 btnNewButton.setEnabled(check);
                 
                 dao.tComboInsert(comboBox);
                 
                 txtA.setText("");

                 
              }
           });
           
           Idbutton.setBounds(585, 169, 176, 30);
           add(Idbutton);
           
           btnD = new JButton("출력");
           btnD.setEnabled(false);
           btnD.setBounds(286, 502, 97, 41);
           add(btnD);
           
           btnNewButton = new JButton("예매취소");
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
           label.setFont(new Font("굴림", Font.BOLD, 18));
           label.setBounds(31, 31, 118, 27);
           add(label);
           btnHome.setBounds(393, 502, 97, 41);
           add(btnHome);
           
           //팝업관련 메뉴
           
           
           
    }
}