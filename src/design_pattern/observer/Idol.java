package design_pattern.observer;

public interface Idol {
    void addFan(Fan fan);

    void deFan(Fan fan);

    void notify(String message);
}
