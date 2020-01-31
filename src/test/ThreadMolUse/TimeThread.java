package test.ThreadMolUse;

import javax.swing.*;

public class TimeThread implements  Runnable{
    @Override
    public void run() {
        JFrame frame=new JFrame("ddsaf");
        JLabel lab=new JLabel();
        new Times(lab);
        frame.add(lab);
        frame.setSize(300, 50);
        frame.setVisible(true);    }
}
