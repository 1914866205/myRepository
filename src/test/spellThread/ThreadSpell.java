package test.spellThread;

public class ThreadSpell implements Runnable {
    private int ticket=100;
    public String name;
    public ThreadSpell(String name){
        this.name=name;
    }
    @Override
    public void run() {
        while (ticket>0){
            System.out.println(Thread.currentThread().getName()+"售票处售出第"+ticket--+"号票");
        }
    }
}
