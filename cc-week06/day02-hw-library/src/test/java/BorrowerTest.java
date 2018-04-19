import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BorrowerTest {
    Borrower borrower;
    Book book;
    Book book2;
    Library library;

    @Before
    public void before() {
        borrower = new Borrower("Rachel");
        book = new Book(Genre.THRILLER);
        book2 = new Book(Genre.CRIME);
        library = new Library(3);
    }

    @Test
    public void canCountBooksBorrowed() {
        assertEquals(0, borrower.bookCount());
    }

    @Test
    public void canBorrowBookWhereBookIsThere() {
        library.addBook(book);
        borrower.borrowBook(library, book);
        assertEquals(1, borrower.bookCount());
        assertEquals(0, library.bookCount());
    }

    @Test
    public void canBorrowBookWhereBookIsNotThere() {
        library.addBook(book);
        borrower.borrowBook(library, book2);
        assertEquals(0, borrower.bookCount());
        assertEquals(1, library.bookCount());
    }
}
