package test.ThreadMolUse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImageThread extends JFrame implements Runnable {
    MyJpanel myJpanel;
    int index;
ImageIcon[] imgs={
        new ImageIcon("D:\\CompcuteApplication\\projectTest\\Java项目\\src\\test\\ThreadMolUse\\img\\i1.jpeg"),
        new ImageIcon("D:\\CompcuteApplication\\projectTest\\Java项目\\src\\test\\ThreadMolUse\\img\\i2.jpeg"),
        new ImageIcon("D:\\CompcuteApplication\\projectTest\\Java项目\\src\\test\\ThreadMolUse\\img\\i3.jpeg"),
        new ImageIcon("D:\\CompcuteApplication\\projectTest\\Java项目\\src\\test\\ThreadMolUse\\img\\i4.jpeg")
};
public ImageThread(){
    myJpanel=new MyJpanel();

     }
    @Override
    public void run() {
        new ImageThread();
        this.add(myJpanel);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("窗口");
        this.setVisible(true);
        //设置定时器
        Timer timer=new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myJpanel.repaint();
            }
        });
        timer.start();
    }
    class MyJpanel extends JPanel{
        public void paint(Graphics g){
            super.paint(g);
            g.drawImage(imgs[index%imgs.length].getImage(),0,0,this);
            index++;
        }
    }
}
