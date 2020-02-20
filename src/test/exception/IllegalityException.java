package test.exception;
public class IllegalityException extends Exception{
    public IllegalityException(String text) {
            System.err.println(text);
    }
}
