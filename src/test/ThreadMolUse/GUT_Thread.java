package test.ThreadMolUse;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 结合GUI和多线程
 * 1.同步显示系统时间
 * 2.播放音乐
 * 3.图片轮播
 */

public class GUT_Thread {
    public static String time;

    public static void main(String[] args) {

        JFrame mainFrame = new JFrame();
        mainFrame.setSize(400, 300);
        mainFrame.setLocation(400, 300);
        mainFrame.setLayout(new FlowLayout());

        JButton timebtn = new JButton();
        timebtn.setSize(400,30);
        timebtn.setVisible(true);
        timebtn.setText("获取当前时间");
        timebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread threadTime = new Thread(new TimeThread());
                threadTime.start();
                System.out.println(threadTime.getName());
            }
        });
        mainFrame.add(timebtn);

        JButton musicbtn = new JButton();
        musicbtn.setSize(400,30);
        musicbtn.setVisible(true);
        musicbtn.setText("播放音乐");
        musicbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread threadMusic = new Thread(new MusicThread());
                threadMusic.start();
                System.out.println(threadMusic.getName());
            }
        });


        JButton imagebtn = new JButton();
        imagebtn.setSize(400,300);
        imagebtn.setVisible(true);
        imagebtn.setText("轮播图");
        imagebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread imageThread = new Thread(new ImageThread());
                imageThread.start();
                System.out.println(imageThread.getName());
            }
        });
        System.out.println(Thread.currentThread().getName());


        mainFrame.add(imagebtn);
        mainFrame.add(timebtn);
        mainFrame.add(musicbtn);
        mainFrame.setVisible(true);
    }
}
