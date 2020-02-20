package test.exception;

import java.util.regex.Pattern;

public class SpellBook extends Book implements Put {
    @Override
    public void putBook(Book book) throws IllegalityException, IllegalityNameException, IllegalityPriceException {
        Pattern pattern=Pattern.compile("\\d{13}");
        if (!pattern.matcher(book.getISBN()).matches()) {
            throw new IllegalityException("ISBN:"+book.getISBN()+"ISBN不是13位数字组成");
        }
        System.out.println(pattern.matcher(book.getISBN()).matches());
        if (book.getName().contains("暴力") || book.getName().contains("恐怖") || book.getName().contains("色情")) {
            throw new IllegalityNameException("ISBN:"+book.getISBN()+"书名中含有“暴力”，“恐怖”等禁词");
        }
        if (book.getPrice() >= 100) {
            throw new IllegalityPriceException("ISBN:"+book.getISBN()+"价格超过100元");
        }

    }
}
