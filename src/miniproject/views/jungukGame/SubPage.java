package miniproject.views.jungukGame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import miniproject.model.vo.Player123;
import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;


public class SubPage extends JPanel {
   private MainFrame mf;
   private JPanel panel = this;
   
   private ImageIcon bg = new ImageIcon("src/miniproject/images/junguk/bg1.PNG");
   
   private Player123 player;
   
   
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawImage(bg.getImage(), 0, 0, 1400, 900, null);
      setOpaque(false);
   }

   public SubPage(MainFrame mf,Player123 player) {
	   
	   this.mf = mf;
	   this.player = player;

      JLabel label = new JLabel() {
         public void paintComponent(Graphics g) {
            ImageIcon quest = new ImageIcon("src/miniproject/images/junguk/Q1.png");
            g.drawImage(quest.getImage(), 0, -30, 1000, 600, null);
            setOpaque(false); 
            super.paintComponent(g);
         }
      };
      
      label.setLayout(null);
      label.setBounds(200,50,1000,700);
      this.add(label); 


      this.addMouseListener(new MouseAdapter() {
         private GamePanel gp;

         public void mouseClicked(MouseEvent e) {
            System.out.println("다음페이지");
            ChangePanel.changePanel(mf, panel, new GamePanel(mf,player));
            mf.revalidate();
         }
      });
   }

}