package design_pattern.observer;

import java.util.ArrayList;

public class ConCreateIdol implements Idol {
    private ArrayList<Fan> fans;

    public ConCreateIdol() {
        this.fans = new ArrayList<Fan>();
    }

    //添加粉丝
    @Override
    public void addFan(Fan fan) {
        fans.add(fan);
    }

    //拉黑粉丝
    @Override
    public void deFan(Fan fan) {
        fans.remove(fan);
    }

    //通知 发动态
    @Override
    public void notify(String message) {
        for (Fan fan : fans) {
            fan.update(message);
        }
    }
}
