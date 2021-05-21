package miniproject.views.minigame;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import miniproject.model.vo.Player123;
import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;

public class MiniGameDance2 extends JPanel  { // 미니게임 연결화면 (춤연습장 들어가서 두번째화면) -> 다시 소속사 
   // 키보드 입력받을 때 두번째화면 문제(화살표) 안뜸..., 게임 조건(3문제(화살표21개)중 2줄 이상 맞춰야 스킬+1, 아니면 실패 후 나가기.
   private ImageIcon back;
   private ImageIcon talk;
   private ImageIcon characters;
   //private ImageIcon keyspace;
   private MainFrame mf;
   private JPanel panel;
   private int x = 300;  //고정(첫번째화살표 위치값)
   private int x2 = 300; //고정(두번째화살표 위치값)
   private JLabel[] arrows; //화살표(문제)
   private int[] arrNo; //화살표(문제)
   private ArrayList<JLabel> inputs;
   private int cnt = 0;
   private int index = 0;
   int num = 0;
   //----점수출력   
   int su = 0;
   //---------   
   

   public int point = 0;
   private JTextField keyScore;
   private Player123 player;



   public MiniGameDance2(MainFrame mf,Player123 player) { //게임두번째화면

      this.mf=mf;
      panel = this;
      this.player = player;
      
      this.setLayout(null);

      back = new ImageIcon("src/miniproject/images/SJH/minigamekey.PNG"); //배경
      talk = new ImageIcon("src/miniproject/images/SJH/conv.PNG"); //대화창
      characters = new ImageIcon("src/miniproject/images/SJH/Characters_5.png"); //캐릭터
      arrows = new JLabel[7];   
      inputs = new ArrayList<JLabel>();
      arrNo = new int[7];



      buttonInit();
      mf.requestFocus(); // -> 두번째 화면에서 문제화살표 출력안되서 포커스 맞춰둠
      mf.addKeyListener(new KeyAdapter() {      //**this로 하면 절대안됨........z

         @Override
         public void keyPressed(KeyEvent e) { 
//0628
            if(su !=1) {
            System.out.println(e.getKeyCode()+ " 첫번째 확인용 ");

            int num = 0;

            if(e.getKeyCode() == KeyEvent.VK_LEFT) {
               num = 4;
            }
            if(e.getKeyCode() == KeyEvent.VK_DOWN) {
               num = 3;
            }
            if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
               num = 2;
            }
            if(e.getKeyCode() == KeyEvent.VK_UP) {
               num = 1;
            }


            
            addButton(num);   //(안생김.........ㅋ안ㅋ됨ㅋ)->해결함.     -----> 이거 때문인거같은데.......ㅋ.ㅎ.
            mf.repaint();
            cnt++;
         }
         }


      });

   }

   //첫번재 화살표 출력(문제)
   public void buttonInit(){

      x = 300; //-> 삭제하면 두번째 문제 출력안됨.. (프레임 밖으로 벗어나서..)


      for(int i = 0; i < arrows.length; ++i) {
         int num = new Random().nextInt(4) + 1;
         arrNo[i] = num;
         ImageIcon arrow = new ImageIcon("src/miniproject/Images/SJH/"+num+"-blue.png");

         arrows[i] = new JLabel(new ImageIcon(arrow.getImage().getScaledInstance(150, 150, 0)));
         arrows[i].setBounds(x, 100, 150, 150);
         x += 150;
         this.add(arrows[i]);
         System.out.println("두번쨰 확인용");
         System.out.println("두 번째 화살표 위치 : " + arrows[i].getX() + ", " + arrows[i].getY());


      }
      this.repaint();
      System.out.println(mf.isFocused());



   }



   public void addButtonJumsu(int su) {
      this.su = su;

   }




   // 두번째 화살표 출력(정답)
   public void addButton(int num) { 


      System.out.println("세번째확인용 :" + num);
//0628//if(point <21) {
      
      if(index >= 7){
         reset();
      }else{
         System.out.println("네번째확인용 : " + index);

         String color = "";

         if(arrNo[index] == num) { 
            color = "blue";
            ImageIcon arrows = new ImageIcon("src/miniproject/images/SJH/"+num+"-"+color+".png");


            //point-----------------------------------------------------------------------
            point += 1;
            System.out.println("개수확인 : " + point);



            if(point >=14) {
               System.out.println("14개 이상 화살표를 맞췄습니당. 춤스킬 +1 짝짝!!");

               //-------------  
                  su += 1; //스킬점수 


               System.out.println("스킬점수 : " + su);

               keygamewin();
               //--------------      



            }else {
               System.out.println("아쉽게 스킬획득을 못했네염...ㅎ.ㅎ....");
               //-------------------            
               
               
               
               
               this.addMouseListener(new MyMouseAdapter());


            }


            System.out.println("다섯번째확인용 : " + index);

            //---------------------------------------------------------------------------위 코드 출력 안됨.삭제예정.->완
         }else {
            color = "red";

            ImageIcon arrow = new ImageIcon("src/miniproject/images/SJH/"+num+"-"+color+".png");

            System.out.println("여섯번째확인용 :" + index);

         }

         ImageIcon arrow = new ImageIcon("src/miniproject/images/SJH/"+num+"-"+color+".png");

         JLabel input = new JLabel(new ImageIcon(arrow.getImage().getScaledInstance(150, 150, 0)));
         input.setBounds(x2, 350, 150, 150);
         inputs.add(input);
         x2 += 150;
         this.add(inputs.get(index));

         System.out.println("일곱번째 확인용");
         this.repaint();
         index++;

      }


   }


   //--------------------------------------   

   public void reset(){

      System.out.println("여덟번째확인용");

      //21개화살표(총3줄)까지는 리셋(7개 기준)해서 문제 출제,  
      //한줄에 7개화살표, 총 21개 화살표 
      //화살표가 7개보다 많아지면 화살표 리셋한 뒤 다시 출력 총 21개까지..
      if(cnt <22  ) {


         for (int i = 0; i < arrows.length; i++) {
            this.remove(arrows[i]);
            System.out.println("아홉번째확인용" + "arrows : " + arrows +"i"+i  );
            this.repaint();



         }
            buttonInit();
         


         for (int j = 0; j < arrNo.length; j++) {
            this.remove(this.inputs.get(j));
            System.out.println("열번째확인용");
            this.repaint();



         }




         inputs.clear();

         System.out.println("열한번째확인용");
         mf.repaint();
         index = 0;
         x =300;
         x2 = 300;

      } else {
         System.out.println("end");
         


      }



   }



   public void keygamewin() {

      MiniGameDance3_Win win = new MiniGameDance3_Win(mf,player); //게임 이기면 이기는 화면으로 넘어감.

      win.keyjumsu(su);  //몇점 얻었는지(춤스킬+1)
      player.setDanceScore(player.getDanceScore() + su);

      ChangePanel.changePanel(mf, panel, win);



   }


   public void paintComponent(Graphics g) {

      super.paintComponent(g);
      g.drawImage(back.getImage(), 0, 0, this.getWidth(),this.getHeight(),null);
      g.drawImage(talk.getImage(), 0, 600, 1400, 250,null); //원래 위치 : 0,600,1400,250
      g.setFont(new Font("Neo둥근모", Font.BOLD, 30));
      g.drawString("통과하면 노래스킬 +1 !!!", 100, 700); //글씨 위치 조절 필요
      g.drawString("14개 이상 동일한 키보드를 입력하세용", 100, 750);
      g.drawImage(characters.getImage(), 10, 100, 398, 398, this); //원래크기 : 398,398
      setOpaque(false);

      setOpaque(false);

   }

   class MyMouseAdapter extends MouseAdapter{


      @Override
      public void mouseClicked(MouseEvent e) {


         ChangePanel.changePanel(mf, panel, new MiniGameDance3_Lose(mf,player));      
      }



   }
}


