package test.spellThread;

public class test {
    public static void main(String[] args) {
        ThreadSpell spell=new ThreadSpell("售票处");
        Thread thread1=new Thread(spell,"小胖");
        Thread thread2=new Thread(spell,"大狼");
        thread1.start();
        thread2.start();
    }
}
