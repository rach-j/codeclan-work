import java.util.ArrayList;

public class Borrower {
    private String name;
    private ArrayList<Book> booksBorrowed;

    public Borrower(String name) {
        this.name = name;
        this.booksBorrowed = new ArrayList<>();
    }

    public int bookCount() {
        return booksBorrowed.size();
    }

    public void borrowBook(Library library, Book book) {
        if (library.holdsBook(book)) {
            library.removeBook(book);
            booksBorrowed.add(book);
        } else {

        }
    }
}
