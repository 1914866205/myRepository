package test.exception;


public class IllegalityNameException extends Exception{
    public IllegalityNameException(String text) {
            System.err.println(text);
    }


}
