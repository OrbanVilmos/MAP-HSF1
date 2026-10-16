import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook(new Book("Clean Code", "Robert Martin", 45.0, 464));
        library.addBook(new Book("1984", "George Orwell", 18.0, 328));
        library.addBook(new Book("Animal Farm", "George Orwell", 12.0, 112));
        library.addBook(new Book("Java Basics", "Max Müller", 35.0, 520));
        library.addBook(new Book("The Hobbit", "J. R. R. Tolkien", 28.0, 310));


    }
}