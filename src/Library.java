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

    public double getAveragePageCount(List<Book> bookList) {
        if (bookList == null || bookList.isEmpty()) {
            return 0.0;
        }
        int totalPages = 0;
        for (Book book : bookList) {
            totalPages += book.getPageCount();
        }
        return (double) totalPages / bookList.size();
    }

    public List<Book> getBooksWithinPriceLimit(List<Book> bookList, double maxPrice) {
        List<Book> result = new ArrayList<>();
        if (bookList == null) {
            return result;
        }
        for (Book book : bookList) {
            if (book.getPrice() <= maxPrice) {
                result.add(book);
            }
        }
        return result;
    }

    public Book getMostExpensiveBook(List<Book> bookList) {
        if (bookList == null || bookList.isEmpty()) {
            return null;
        }
        Book mostExpensive = bookList.get(0);
        for (Book book : bookList) {
            if (book.getPrice() > mostExpensive.getPrice()) {
                mostExpensive = book;
            }
        }
        return mostExpensive;
    }

    public List<Book> getBooksWithMinPageCount(List<Book> bookList, int minPages) {
        List<Book> result = new ArrayList<>();
        if (bookList == null) {
            return result;
        }
        for (Book book : bookList) {
            if (book.getPageCount() >= minPages) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> getBestTwoBooksWithinBudget(List<Book> bookList, double budget) {
        List<Book> bestPair = new ArrayList<>();
        if (bookList == null || bookList.size() < 2) {
            return bestPair;
        }

        double maxPriceSum = -1.0;
        int maxPageSum = -1;

        for (int i = 0; i < bookList.size(); i++) {
            for (int j = i + 1; j < bookList.size(); j++) {
                Book b1 = bookList.get(i);
                Book b2 = bookList.get(j);
                double currentPriceSum = b1.getPrice() + b2.getPrice();

                if (currentPriceSum <= budget) {
                    int currentPageSum = b1.getPageCount() + b2.getPageCount();

                    if (currentPriceSum > maxPriceSum) {
                        maxPriceSum = currentPriceSum;
                        maxPageSum = currentPageSum;
                        bestPair.clear();
                        bestPair.add(b1);
                        bestPair.add(b2);
                    } else if (currentPriceSum == maxPriceSum && currentPageSum > maxPageSum) {
                        maxPageSum = currentPageSum;
                        bestPair.clear();
                        bestPair.add(b1);
                        bestPair.add(b2);
                    }
                }
            }
        }
        return bestPair;
    }
}