package test.exception;

public class Main {
    public static void main(String[] args){
//        Book book=new SpellBook();
//        book.setISBN("1212121212121");
//        book.setName("小黄书");
//        book.setPrice(10.0);
//        try {
//            ((SpellBook) book).putBook(book);
//        } catch (IllegalityException e) {
//            e.printStackTrace();
//        } catch (IllegalityNameException e) {
//            e.printStackTrace();
//        } catch (IllegalityPriceException e) {
//            e.printStackTrace();
//        }

        Book book1=new SpellBook();
        book1.setISBN("212121");
        book1.setName("小黄书");
        book1.setPrice(10.0);
        try {
            ((SpellBook) book1).putBook(book1);
        } catch (IllegalityException e) {
            e.printStackTrace();
        } catch (IllegalityNameException e) {
            e.printStackTrace();
        } catch (IllegalityPriceException e) {
            e.printStackTrace();
        }

//        Book book2=new SpellBook();
//        book2.setISBN("1212121212121");
//        book2.setName("暴力");
//        book2.setPrice(10.0);
//        try {
//            ((SpellBook) book2).putBook(book2);
//        } catch (IllegalityException e) {
//            e.printStackTrace();
//        } catch (IllegalityNameException e) {
//            e.printStackTrace();
//        } catch (IllegalityPriceException e) {
//            e.printStackTrace();
//        }
//
//        Book book3=new SpellBook();
//        book3.setISBN("1212121212121");
//        book3.setName("小黄书");
//        book3.setPrice(101.0);
//        try {
//            ((SpellBook) book3).putBook(book3);
//        } catch (IllegalityException e) {
//            e.printStackTrace();
//        } catch (IllegalityNameException e) {
//            e.printStackTrace();
//        } catch (IllegalityPriceException e) {
//            e.printStackTrace();
//        }


    }
}
