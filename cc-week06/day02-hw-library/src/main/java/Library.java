import java.util.ArrayList;
import java.util.HashMap;

public class Library {
    private ArrayList<Book> libraryStock;
    private int capacity;
    private Genre[] genres;
    private HashMap<Genre, Integer> genreHash;

    public Library(int capacity) {
        this.libraryStock = new ArrayList<>();
        this.capacity = capacity;
        this.genreHash = new HashMap<>();
        for (Genre genre: Genre.values()) {
        genreHash.put(genre, genreCount(genre));
        }
    }

    public int bookCount() {
        return this.libraryStock.size();
    }

    public void addBook(Book book) {
        if (bookCount() < capacity) {
            libraryStock.add(book);
            genreHash.put(book.getGenre(), genreHash.get(book.getGenre()) + 1);
        } else {
        }
    }

    public boolean holdsBook(Book book) {
        return libraryStock.contains(book);
    }


    public void removeBook(Book book) {
        if (holdsBook(book)) {
            libraryStock.remove(book);
            genreHash.put(book.getGenre(), genreHash.get(book.getGenre()) - 1);
        } else {
        }
    }


    public int genreCount(Genre genre) {
        int count = 0;
        for (int i = 0; i < libraryStock.size(); i++) {
            if (libraryStock.get(i).getGenre() == genre) {
                count += 1;
            } else {
            }
        }
        return count;
    }

    public HashMap returnGenreHash() {
        return genreHash;
    }

}
