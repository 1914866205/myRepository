package test.ThreadMolUse;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class MusicThread implements Runnable {
    @Override
    public void run() {
        try {
            File file = new File("C:\\Users\\lenovo\\StudioProjects\\MyApplication11\\soundpool\\src\\main\\res\\raw\\music.wav");
            System.out.println(file.getName());
            URI uri = file.toURI();
            URL url = uri.toURL();  //解析地址
            AudioClip aau;
            aau = Applet.newAudioClip(url);
            aau.loop();  //循环播放
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
