import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryTest {
    Library library;
    Book book;
    Book book2;

    @Before
    public void before() {
        library = new Library(3);
        book = new Book(Genre.THRILLER);
        book2 = new Book(Genre.CRIME);

    }

    @Test
    public void canCountBooks() {
        assertEquals(0, library.bookCount());
    }

    @Test
    public void canAddBooksWhenCapacityNotReached() {
        library.addBook(book);
        assertEquals(1, library.bookCount());
        assertEquals(1,library.returnGenreHash().get(Genre.THRILLER));
        assertTrue(library.returnGenreHash().containsKey(Genre.THRILLER));
    }

    @Test
    public void cannotAddBooksWhenCapacityReached() {
        library.addBook(book);
        library.addBook(book);
        library.addBook(book);
        library.addBook(book);
        library.addBook(book);
        assertEquals(3, library.bookCount());
        assertEquals(3,library.returnGenreHash().get(Genre.THRILLER));
        assertTrue(library.returnGenreHash().containsKey(Genre.THRILLER));
    }

    @Test
    public void canRemoveBooksWhenBookIsThere() {
        library.addBook(book);
        library.removeBook(book);
        assertEquals(0, library.bookCount());
        assertEquals(0,library.returnGenreHash().get(Genre.THRILLER));
    }


    @Test
    public void cannotRemoveBooksWhenBookIsNotThere() {
        library.addBook(book2);
        library.removeBook(book);
        assertEquals(1, library.bookCount());
        assertEquals(0,library.returnGenreHash().get(Genre.THRILLER));
        assertEquals(1,library.returnGenreHash().get(Genre.CRIME));
    }

    @Test
    public void canCheckIfLibraryHoldsBookWhereLibraryDoesNotHoldBook() {
        assertFalse(library.holdsBook(book));
    }

    @Test
    public void canCheckIfLibraryHoldsBookWhereLibraryHoldsBook() {
        library.addBook(book);
        assertTrue(library.holdsBook(book));
    }

    @Test
    public void canCountBooksWithSpecifiedGenre() {
        library.addBook(book);
        library.addBook(book);
        library.addBook(book2);
        assertEquals(2,library.genreCount(Genre.THRILLER));
        assertEquals(1,library.genreCount(Genre.CRIME));
    }

    @Test
    public void canGetHash() {
        library.addBook(book);
        library.addBook(book);
        library.addBook(book2);
        assertEquals(2,library.returnGenreHash().get(Genre.THRILLER));
        assertTrue(library.returnGenreHash().containsKey(Genre.THRILLER));
        assertEquals(1,library.returnGenreHash().get(Genre.CRIME));
        assertTrue(library.returnGenreHash().containsKey(Genre.CRIME));
        assertEquals(0,library.returnGenreHash().get(Genre.ROMANCE));
        assertTrue(library.returnGenreHash().containsKey(Genre.ROMANCE));
    }

}
