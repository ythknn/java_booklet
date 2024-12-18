public class Book {
    private String name;
    private int pages;
    private String publisher;
    private double price;
    private boolean landed;
    private boolean sold;

    public Book(String name, int pages, String publisher, double price) {
        this.name = name;
        this.pages = pages;
        this.publisher = publisher;
        this.price = price;
        this.landed = false;
        this.sold = false;
    }

    public String getName() { return name; }
    public int getPages() { return pages; }
    public String getPublisher() { return publisher; }
    public double getPrice() { return price; }
    public boolean isLanded() { return landed; }
    public boolean isSold() { return sold; }
    public void setLanded(boolean landed) { this.landed = landed; }
    public void setSold(boolean sold) { this.sold = sold; }
}