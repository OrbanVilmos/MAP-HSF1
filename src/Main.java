import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook(new Book("Clean Code", "Robert Martin", 45.0, 464));
        library.addBook(new Book("1984", "George Orwell", 18.0, 328));
        library.addBook(new Book("Animal Farm", "George Orwell", 12.0, 112));
        library.addBook(new Book("Java Basics", "Max Müller", 35.0, 520));
        library.addBook(new Book("The Hobbit", "J. R. R. Tolkien", 28.0, 310));

        System.out.println("=== Task 1: Books by George Orwell ===");
        List<Book> orwellBooks = library.getBooksByAuthor("George Orwell");
        for (Book b : orwellBooks) {
            System.out.println("- " + b.getTitle());
        }

        System.out.println("\n=== Task 2: Average Page Count ===");
        List<Book> sampleForAvg = List.of(
                library.getBooks().get(0),
                library.getBooks().get(1),
                library.getBooks().get(2)
        );
        double avgPages = library.getAveragePageCount(sampleForAvg);
        System.out.printf("Average page count: %.2f\n", avgPages);

        System.out.println("\n=== Task 3: Books Within Price Limit (max. 30 Euro) ===");
        List<Book> affordableBooks = library.getBooksWithinPriceLimit(library.getBooks(), 30.0);
        for (Book b : affordableBooks) {
            System.out.println("- " + b.getTitle() + " -> " + b.getPrice() + " Euro");
        }

        System.out.println("\n=== Task 4: Most Expensive Book from Filtered List ===");
        Book mostExpensive = library.getMostExpensiveBook(affordableBooks);
        if (mostExpensive != null) {
            System.out.println("Most expensive: " + mostExpensive.getTitle() + " (" + mostExpensive.getPrice() + " Euro)");
        }

        System.out.println("\n=== Task 5: Books With Minimum 300 Pages ===");
        List<Book> thickBooks = library.getBooksWithMinPageCount(library.getBooks(), 300);
        for (Book b : thickBooks) {
            System.out.println("- " + b.getTitle() + " (" + b.getPageCount() + " pages)");
        }

        System.out.println("\n=== Task 6: Two Books Within Budget (Budget: 55 Euro) ===");
        List<Book> bestPair = library.getBestTwoBooksWithinBudget(library.getBooks(), 55.0);
        if (bestPair.size() == 2) {
            Book b1 = bestPair.get(0);
            Book b2 = bestPair.get(1);
            double total = b1.getPrice() + b2.getPrice();
            System.out.println("Selected: " + b1.getTitle() + " + " + b2.getTitle());
            System.out.println("Total price: " + total + " Euro");
        } else {
            System.out.println("No suitable book pair found within budget.");
        }
    }
}