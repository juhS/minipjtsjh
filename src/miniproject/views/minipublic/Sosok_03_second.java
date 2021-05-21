package miniproject.views.minipublic;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import miniproject.model.vo.Player123;
import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;
import miniproject.views.minipublic.Sosok_02.clickButton;
import miniproject.views.somang.MiniGameSsing;

public class Sosok_03_second extends JPanel { //사장님한테 미션받는 장면(캐릭터가 다가가서

   private MainFrame mf;
   private JPanel panel;

   private ImageIcon back; //배경
   private ImageIcon talk; //대화상자
   private ImageIcon characters =new ImageIcon("src/miniproject/images/SJH/Characters_6.png");
   private ImageIcon sajang = new ImageIcon("src/miniproject/images/sosok/sajang.PNG");

   private Image doorR; //소속사 문(미니게임 춤)
   private Image doorL; //소속사 문(미니게임 노래)
   
   private Player123 player;

   public Sosok_03_second(MainFrame mf, Player123 player) {

      this.mf=mf;
      panel = this;
      this.player = player;
      
      this.setLayout(null);

      back = new ImageIcon("src/miniproject/images/SJH/minibackgroundfinish.PNG"); //배경-소속사
      talk = new ImageIcon("src/miniproject/images/SJH/conv.PNG"); //대화창
      
      Image cimage = characters.getImage().getScaledInstance(100, 100, 0);
      Image simage  = sajang.getImage().getScaledInstance(100, 100, 0);
      ImageIcon cIcon = new ImageIcon(cimage);
      ImageIcon sIcon = new ImageIcon(simage);
      
      this.addMouseListener(new clickButton() );
      
   }

   public void paintComponent(Graphics g) {

      super.paintComponent(g);

      g.drawImage(back.getImage(), 0, 0, this.getWidth(),this.getHeight(),null);
      g.drawImage(talk.getImage(), 0, 600, 1400, 250,null); //원래 위치 : 0,600,1400,250
      g.drawImage(sajang.getImage(), 300, 300, 250, 250, this);
      g.drawImage(characters.getImage(), 10, 300, 250, 250, this);
      g.setFont(new Font("Neo둥근모", Font.BOLD, 30));
      g.drawString("사장님 : 훌륭하군, 트롯스타에 나가려면 노래와 춤 능력치를 1씩 더 올려오시게나", 100, 700);
      g.drawString("노래연습장은 왼쪽문이고, 춤연습장은 오른쪽문이니 순서대로 능력치를 올려보게", 120, 750);
   
   }
   

   class clickButton extends MouseAdapter{  
      @Override
      public void mouseClicked(MouseEvent e) {
         ChangePanel.changePanel(mf, panel, new Sosok_singbutton(mf,player));
         mf.revalidate();
      }


   }
}
	