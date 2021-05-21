package miniproject.views.nickname;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import miniproject.model.vo.Player123;
import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;
import miniproject.views.selectC.SelectC;


public class NickName extends JPanel {
   public static String nickname;
   private Graphics g;
   private Set nicks = new LinkedHashSet(); 
   private MainFrame mf;
   private NickName nick = this;
   private Player123 player;
   
   
   // 배경화면 설정부분
   public void paintComponent(Graphics g) { 
	   ImageIcon bground = new ImageIcon("src/miniproject/images/nickNameSelect/nickname_background.jpeg");
	   
	   g.drawImage(bground.getImage(), 0, 0, 1400, 900, null);
	   setOpaque(false); //그림을 표시하게 설정,투명하게 조절
	   super.paintComponent(g);
   };
   public NickName(MainFrame mf) {
      
	   Scanner sc = new Scanner(System.in);
	   
	   player = new Player123();
	   
      //텍스트 입력하는 곳-------------------------------
      JTextField get_nickname = new JTextField(3) {
         public void paintComponent (Graphics g) {
        	 ImageIcon inputw = new ImageIcon("src/miniproject/images/nickNameSelect/malpung.png");
            g.drawImage(inputw.getImage(), 0, 0, 450, 120, null);
            setOpaque(false);
          super.paintComponent(g);
         }
      };
      
      

      Font neo = new Font("Neo둥근모",Font.BOLD,30);
      get_nickname.setDocument(new JTextFieldLimit(3));
      get_nickname.setLayout(null);
      get_nickname.setBorder(null);
      get_nickname.setHorizontalAlignment(JTextField.CENTER);
      get_nickname.setFont(neo);   
      get_nickname.setBounds(540,350,480,120);
      get_nickname.setOpaque(false);
      this.add(get_nickname);
      
      //닉네임 설정 부분-----------
      JLabel nn = new JLabel() {
    	  ImageIcon nickn = new ImageIcon("src/miniproject/images/nickNameSelect/nickname.png");
         public void paintComponent (Graphics g) {
            g.drawImage(nickn.getImage(), 0, 0, 300, 100, null);
            setOpaque(false);
            super.paintComponent(g);
         }
      };
      nn.setLayout(null);
      nn.setBounds(190,350,400,100);
      this.add(nn);

      //닉네임 설정한 거 출력하는 부분~~~
      

      nickname = get_nickname.getText(); 
      JTextField setBtnText = new JTextField();
      setBtnText.setBounds(450, 100, 700, 100);
      setBtnText.setEditable(false);
      this.add(setBtnText);
      Font neo2 = new Font("Neo둥근모",Font.BOLD, 25);
      setBtnText.setForeground(Color.WHITE);
      setBtnText.setFont(neo2);
      setBtnText.setBorder(null);
      setBtnText.setOpaque(false);
      

      Image select_btn =    new ImageIcon("src/miniproject/images/nickNameSelect/select.png").getImage();

      JButton btn = new JButton(new ImageIcon(select_btn));

      btn.setBounds(550,650,300,50);
      btn.setBorderPainted(false);
      btn.setContentAreaFilled(false);
      btn.setFocusPainted(false);
      this.add(btn);
      btn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            nickname = get_nickname.getText();
            if (nickname.equals("")) {
            	 setBtnText.setText("닉네임은 1글자 이상, 3글자 이하로 입력해주세요");
            }else {
            setBtnText.setText("당신의 닉네임은 "+ nickname + " 입니다. 환영합니다.");
            setBtnText.removeAll();
            setBtnText.setFocusable(true);
            player.setUserId(nickname);
            System.out.println(player.getUserId());
            ChangePanel.changePanel(mf,nick,new SelectC(mf,player));
            }
            
         }
      });

   }
}
     
