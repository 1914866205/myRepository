package test.exception;

public interface Put {
    void putBook(Book book) throws IllegalityException,
            IllegalityNameException, IllegalityPriceException;
}
