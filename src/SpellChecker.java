
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class SpellChecker extends JPanel{


    Scanner t;
    String x="word/words";
    String[] splited;



    public static void main(String[] args) {

          TextArea ta=new TextArea("");
          ta.setBounds(0,0,480,480);
          JFrame frame=new JFrame("Spell checker");
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.setBounds(100,300,500,500);
          frame.add(ta);



          JLabel logMsg=new JLabel();
          JFrame frame2=new JFrame("log");
          frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame2.setBounds(700,300,500,200);
          frame2.add(logMsg);
          frame2.setVisible(true);
          frame.setVisible(true);



          SpellChecker sc=new SpellChecker();


           ta.addKeyListener(new KeyListener() {
               @Override
               public void keyTyped(KeyEvent e) {
                   if(e.getKeyChar()==' '){
                       logMsg.setText("<html>"+ sc.start(ta.getText())+"</html>");
                   }
               }

               @Override
               public void keyPressed(KeyEvent e) {

               }

               @Override
               public void keyReleased(KeyEvent e) {

               }
           });

    }



    public String start(String sc){
        int i=0;
        String log="";
        String s= sc.toLowerCase();


        while ((token(s,i)!=null)){

            if(search(token(s,i))!=true){

                log=log+token(s,i)+ " is misspelled!<br>";
            }

            i++;
        }

        return log;

    }





    public boolean search(String s){

        try {
            t=new Scanner(new File(x));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while(t.hasNextLine()){
            if(t.nextLine().matches(s)){
                return true;
            }

        }
        return false;

    }



    public  String token(String str,int i) {
        splited = str.split(" ");
        try{
        return splited[i];}
        catch (Exception e){
            return null;
        }

    }


}

