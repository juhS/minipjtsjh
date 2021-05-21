package miniproject.views.minipublic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import miniproject.model.vo.Player123;
import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;
import miniproject.views.Pyosi;
import miniproject.views.mainMap.MainMapJunguk;

public class Sosok_01 extends JPanel { //소속사 첫화면

   private MainFrame mf;
   private JPanel panel;

   private ImageIcon back; //배경
   private ImageIcon talk; //대화상자
   private ImageIcon characters =new ImageIcon("src/miniproject/images/SJH/Characters_5.png");
   private ImageIcon sajang = new ImageIcon("src/miniproject/images/sosok/sajang.PNG");

   private ImageIcon doorMain;
   private JLabel door;//문
   private Player123 player;
   private Pyosi pyosi;
   
   
   public Sosok_01(MainFrame mf, Player123 player) {
	   

      this.mf=mf;
      panel = this;
      this.player  = player;
      
      this.setLayout(null);
      pyosi = new Pyosi(player);
      pyosi.setLayout(null);
      pyosi.setBounds(600,0,500,200);
      pyosi.setFont(new Font("맑은고딕", Font.BOLD, 25));
      pyosi.setForeground(Color.WHITE);
      panel.add(pyosi);
      

      back = new ImageIcon("src/miniproject/images/SJH/minibackgroundfinish.PNG"); //배경-소속사
      talk = new ImageIcon("src/miniproject/images/SJH/conv.PNG"); //대화창
      Image cimage = characters.getImage().getScaledInstance(100, 100, 0);
      Image simage  = sajang.getImage().getScaledInstance(100, 100, 0);
      ImageIcon cIcon = new ImageIcon(cimage);
      ImageIcon sIcon = new ImageIcon(simage);
      

      doorMain = new ImageIcon("src/miniproject/images/SJH/outdoor.png");
      //문 
      door = new JLabel(doorMain);
      door.setLayout(null);
      door.setBounds(0, 300, 40, 250);
      door.setOpaque(false);
      this.add(door);

      door.addMouseListener(new MouseAdapter() {

         @Override
         public void mouseClicked(MouseEvent e) {
            ChangePanel.changePanel(mf, panel, new MainMapJunguk(mf,player));

         }
      });
      
      
      this.addMouseListener(new clickButton() );
      
      
   }

   public void paintComponent(Graphics g) {

      super.paintComponent(g);

      g.drawImage(back.getImage(), 0, 0, this.getWidth(),this.getHeight(),null);
      g.drawImage(talk.getImage(), 0, 600, 1400, 250,null); //원래 위치 : 0,600,1400,250
      g.drawImage(sajang.getImage(), 300, 300, 250, 250, this);
      g.drawImage(characters.getImage(), 10, 300, 250, 250, this);
      g.setFont(new Font("Neo둥근모", Font.BOLD, 30));
      g.drawString("[소속사안...]", 100, 730);
   
   }


   class clickButton extends MouseAdapter{  
      @Override
      public void mouseClicked(MouseEvent e) {
         ChangePanel.changePanel(mf, panel, new Sosok_02(mf,player));
         mf.revalidate();
      }


   }
}