package MidProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

/** @name : 이민호
*   @date : 2019. 5. 7. 
*   @description : 시간선택 JPanel03
*/

/** @name : 나다윤
*   @date : 2019. 5. 8.
*   @description : 시간 선택 기능 구현
*/

class JPanel03 extends JPanel { // 3번째 패널

	//2019.05.13 나다윤 좌석 추가 수정
private JButton jButton4;
private JPanelTest win;
private int time;
private JLabel tmp2;
private JLabel tmp3;


	public JPanel03(JPanelTest win){
		
	    win.dao.timeChoice();
	    this.win = win;
	    setLayout(null);
	
	    jButton4 = new JButton("확인");
	    jButton4.setFont(new Font("굴림", Font.BOLD, 17));
	    jButton4.setSize(107,41);        
	    jButton4.setLocation(646, 486);
	    add(jButton4);
	    jButton4.setEnabled(false);
	
	    JLabel m_location_f = new JLabel("\uC601\uD654\uAD00 :");
	    m_location_f.setFont(new Font("굴림", Font.PLAIN, 16));
	    m_location_f.setBounds(308, 77, 64, 27);
	    add(m_location_f);
	
	    JLabel m_name_f = new JLabel("\uC601\uD654\uC81C\uBAA9:");
	    m_name_f.setFont(new Font("굴림", Font.PLAIN, 16));
	    m_name_f.setBounds(35, 77, 74, 27);
	    add(m_name_f);
	
	    JLabel moviename_label = new JLabel(win.dao.dto.getM_name());    //JPanel01에서 입력받은 영화제목
	    moviename_label.setFont(new Font("굴림", Font.BOLD, 16));
	    moviename_label.setBounds(114, 77, 93, 27);
	    add(moviename_label);
	
	    JLabel location_label = new JLabel(win.dao.dto.getM_location()+" 관");    //JPanel01에서 입력받은 영화관 번호
	    location_label.setFont(new Font("굴림", Font.BOLD, 16));
	    location_label.setBounds(385, 77, 64, 27);
	    add(location_label);
	
	    JLabel m_time_f = new JLabel("\uB0A0\uC9DC:");
	    m_time_f.setFont(new Font("굴림", Font.PLAIN, 16));
	    m_time_f.setBounds(507, 77, 48, 27);
	    add(m_time_f);
	
	    JLabel time_label = new JLabel(win.dao.dto.getM_day());    //JPanel02에서 입력받은 날짜
	    time_label.setFont(new Font("굴림", Font.BOLD, 16));
	    time_label.setBounds(567, 77, 83, 27);
	    add(time_label);
	
	    int nine = 9;
	    int fteen = 14;
	    int eteen = 18;
	    
	    JRadioButton button9 = new JRadioButton("09:00 ~ "+Integer.toString(nine+win.dao.dto.getM_runningtime())+":00");
	    button9.setFont(new Font("굴림", Font.BOLD, 17));
	    button9.setBounds(35, 173, 158, 23);
	    add(button9);
	
	    JRadioButton button14 = new JRadioButton("14:00 ~ "+Integer.toString(fteen+win.dao.dto.getM_runningtime())+":00");
	    button14.setFont(new Font("굴림", Font.BOLD, 17));
	    button14.setBounds(35, 276, 183, 23);
	    add(button14);
	
	    JRadioButton button18 = new JRadioButton("18:00 ~ "+Integer.toString(eteen+win.dao.dto.getM_runningtime())+":00");
	    button18.setFont(new Font("굴림", Font.BOLD, 17));
	    button18.setBounds(35, 374, 172, 23);
	    add(button18);
	
	    ButtonGroup bg = new ButtonGroup();
	
	    bg.add(button9);
	    bg.add(button14);
	    bg.add(button18);
	
	    JLabel lblNewLabel_1 = new JLabel("\uC794\uC5EC\uC88C\uC11D      /      \uC804\uCCB4\uC88C\uC11D");
	    lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 16));
	    lblNewLabel_1.setBounds(342, 133, 228, 27);
	    add(lblNewLabel_1);
	
	    JLabel tmp1 = new JLabel("/");
	    tmp1.setFont(new Font("굴림", Font.PLAIN, 16));
	    tmp1.setBounds(426, 378, 23, 15);
	    add(tmp1);
	
	    tmp2 = new JLabel("/");
	    tmp2.setFont(new Font("굴림", Font.PLAIN, 16));
	    tmp2.setBounds(426, 178, 23, 15);
	    add(tmp2);
	    
	    tmp3 = new JLabel("/");
	    tmp3.setFont(new Font("굴림", Font.PLAIN, 16));
	    tmp3.setBounds(426, 280, 23, 15);
	    add(tmp3);
	
	    //19.05.14 나다윤 수정
	    JLabel soldout9 = new JLabel("\uB9E4\uC9C4");
	    soldout9.setFont(new Font("굴림", Font.BOLD, 16));
	    soldout9.setForeground(Color.RED);
	    soldout9.setBounds(216, 164, 64, 41);
	    
	    
	    JLabel soldout14 = new JLabel("\uB9E4\uC9C4");
	    soldout14.setForeground(Color.RED);
	    soldout14.setFont(new Font("굴림", Font.BOLD, 16));
	    soldout14.setBounds(216, 263, 64, 41);
	    
	    
	    JLabel soldout18 = new JLabel("\uB9E4\uC9C4");
	    soldout18.setForeground(Color.RED);
	    soldout18.setFont(new Font("굴림", Font.BOLD, 16));
	    soldout18.setBounds(216, 361, 64, 41);
	    
	    
	    JLabel label1front = new JLabel(Integer.toString((16)-win.dao.rest_seat1));
	    label1front.setFont(new Font("굴림", Font.PLAIN, 16));
	    label1front.setBounds(342, 178, 23, 15);
	    add(label1front);
	    if(16-win.dao.rest_seat1==0){
	    	button9.setEnabled(false);
	    	add(soldout9);
	    }
	
	    JLabel label2front = new JLabel(Integer.toString((16)-win.dao.rest_seat2));
	    label2front.setFont(new Font("굴림", Font.PLAIN, 16));
	    label2front.setBounds(342, 280, 23, 15);
	    add(label2front);
	    if(16-win.dao.rest_seat2==0){
	    	button14.setEnabled(false);
	    	add(soldout14);
	    }
	
	    JLabel label3front = new JLabel(Integer.toString((16)-win.dao.rest_seat3));
	    label3front.setFont(new Font("굴림", Font.PLAIN, 16));
	    label3front.setBounds(342, 378, 23, 15);
	    add(label3front);
	    if(16-win.dao.rest_seat3==0){
	    	button18.setEnabled(false);
	    	add(soldout18);
	    }
	
	    JLabel label1back = new JLabel(Integer.toString(16));
	    label1back.setFont(new Font("굴림", Font.PLAIN, 16));
	    label1back.setBounds(507, 378, 28, 15);
	    add(label1back);
	
	    JLabel label2back = new JLabel(Integer.toString(16));
	    label2back.setFont(new Font("굴림", Font.PLAIN, 16));
	    label2back.setBounds(507, 177, 57, 15);
	    add(label2back);
	
	    JLabel label3back = new JLabel(Integer.toString(16));
	    label3back.setFont(new Font("굴림", Font.PLAIN, 16));
	    label3back.setBounds(507, 280, 57, 15);
	    add(label3back);
	    
	    JLabel label = new JLabel("\uC2DC\uAC04 \uC120\uD0DD");
	    label.setFont(new Font("굴림", Font.BOLD, 18));
	    label.setBounds(32, 30, 118, 27);
	    add(label);
	    
	    JButton back_btn = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		back_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.jpanel02 = new JPanel02(win);
				win.change("panel02");
			}
		});
		back_btn.setFont(new Font("굴림", Font.BOLD, 17));
		back_btn.setBounds(539, 486, 102, 41);
		add(back_btn);
	
	    
	    jButton4.addActionListener(new MyActionListener4());
	    button9.addActionListener(new ButtonListener());
	    button14.addActionListener(new ButtonListener1());
	    button18.addActionListener(new ButtonListener2());
	
	
	}
	
	class MyActionListener4 implements ActionListener {    // 버튼 키 눌리면 패널 4번 호출
	
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	
	    	  String dateFromDto = win.dao.dto.getM_day();
	          String dateFromDB = win.dao.compareDate();
	          
	          if(dateFromDto.equals(dateFromDB)==false) {
	        	  
	             System.out.println("오늘이 아니므로 panel change");
	             System.out.println(win.dao.dto.getM_day());
	             System.out.println(win.dao.compareDate());
	             
	             win.jpanel04 = new JPanel04(win);
	             win.change("panel04");  
	             
	          }
	          else//날짜가 같은경우
	          {
	             if(win.dao.dto.getM_time() > win.dao.compareTime())
	              {
	                 System.out.println("가능한 시간");
	                 
	                 win.jpanel04 = new JPanel04(win);
	                 win.change("panel04");  
	                 
	              }else
	              {
	                 JOptionPane.showMessageDialog(null, "이미 지난 시간입니다");
	                 
	                 System.out.println("이미 지난시간");
	                 
	                 win.change("panel03");
	              }    
	          }
	          
	       }
	
	 }
	class ButtonListener implements ActionListener{        // 9시 버튼
	
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        time = 9;
	        win.dao.dto.setM_time(time);
	        jButton4.setEnabled(true);
	
	    }
	}
	class ButtonListener1 implements ActionListener{    //14시 버튼
	
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	
	        time = 14;
	        win.dao.dto.setM_time(time);
	        jButton4.setEnabled(true);
	
	    }
	}
	class ButtonListener2 implements ActionListener{    //18시 버튼
	
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	
	        time = 18;
	        win.dao.dto.setM_time(time);
	        jButton4.setEnabled(true);
	
	    }
	}
}