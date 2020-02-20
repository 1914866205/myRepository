package test.exception;


public class IllegalityPriceException extends Exception{
    public IllegalityPriceException(String text) {
            System.err.println(text);
    }


}
