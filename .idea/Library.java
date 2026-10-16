import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        if (book != null) {
            this.books.add(book);
        }
    }

    public List<Book> getBooks() {
        return books;
    }
    public List<Book> getBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        if (author == null) {
            return result;
        }
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }
}