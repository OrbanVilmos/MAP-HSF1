public class Book {
    private String title;
    private String author;
    private double price;
    private int pageCount;

    public Book(String title, String author, double price, int pageCount) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.pageCount = pageCount;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getPageCount() {
        return pageCount;
    }

    @Override
    public String toString() {
        return title + " (" + author + ", " + price + " EUR, " + pageCount + " Seiten)";
    }
}