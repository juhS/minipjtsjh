package  miniproject.views.minigame;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import miniproject.model.vo.Player123;
import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;
import miniproject.views.minipublic.Sosok_dancebutton;


public class MiniGameDance3_Lose extends JPanel{ // 미니게임 지면 나오는 화면

   private MainFrame mf;
   private MiniGameDance3_Lose panel;
   
   private ImageIcon back;
   private ImageIcon talk;
   private ImageIcon characters;
   private ImageIcon lose;
   
   private Player123 player;

   public MiniGameDance3_Lose(MainFrame mf, Player123 player) {

      this.mf = mf;
      panel = this;
      this.player = player;
      
      this.setLayout(null);
      back = new ImageIcon("src/miniproject/images/SJH/minigamekey.png");
      talk = new ImageIcon("src/miniproject/images/SJH/conv.png");
      characters = new ImageIcon("src/miniproject/images/SJH/Lose_Characters02_1.png");
      lose = new ImageIcon("src/miniproject/images/SJH/lose.png");

      this.addMouseListener(new clickPanel());
      this.setFocusable(true);
      
     
      
   }

   public void paintComponent(Graphics g) {
      g.drawImage(back.getImage(), 0, 0,1400,900, null);
      g.drawImage(talk.getImage(), 5, 620, 1390, 250, null);
      g.drawImage(lose.getImage(),350,50,700,170,null);
      if (characters != null) {
         g.drawImage(characters.getImage(), 500, 250, 398, 398, this);
      }
      g.setFont(new Font("Neo둥근모", Font.BOLD, 40));
      g.drawString("아쉬워요.. 춤스킬을 얻지 못했습니다........", 70, 750);

      setOpaque(false);
      super.paintComponent(g);
   }


   class clickPanel extends MouseAdapter {
      @Override
      public void mouseClicked(MouseEvent e) {
         

         ChangePanel.changePanel(mf, panel, new Sosok_dancebutton(mf,player));
         mf.revalidate();

      }

   }

   
}



