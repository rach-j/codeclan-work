import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {
    Book book;

    @Before
    public void before() {
        book = new Book(Genre.THRILLER);
    }

    @Test
    public void canGetGenre() {
        assertEquals(Genre.THRILLER, book.getGenre());
    }

    @Test
    public void canGetGenreDescription() {
        String expectedString = new String("Thrillers are characterized and defined by the moods they elicit, giving viewers heightened feelings of suspense, excitement, surprise, anticipation and anxiety");
        assertEquals(expectedString, book.genreDescription());
    }
}
