import java.util.ArrayList;

public class BookStore {
    private ArrayList<Book> books;
    private boolean loggedIn;

    public BookStore() {
        books = new ArrayList<>();
        loggedIn = false;
    }

    public boolean login(String password) {
        loggedIn = password.equals("admin123");
        return loggedIn;
    }

    public void logout() {
        loggedIn = false;
    }

    public void addBook(Book book) {
        if (!loggedIn) return;
        books.add(book);
    }

    public ArrayList<Book> getBooks() {
        if (!loggedIn) return new ArrayList<>();
        return books;
    }

    public ArrayList<Book> findByPublisher(String publisher) {
        if (!loggedIn) return new ArrayList<>();
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getPublisher().equals(publisher)) {
                result.add(book);
            }
        }
        return result;
    }

    public Book findBook(String name) {
        if (!loggedIn) return null;
        for (Book book : books) {
            if (book.getName().equals(name)) {
                return book;
            }
        }
        return null;
    }

    public double getAveragePages() {
        if (!loggedIn || books.isEmpty()) return 0;
        int total = 0;
        for (Book book : books) {
            total += book.getPages();
        }
        return total / books.size();
    }

    public double getAveragePrice() {
        if (!loggedIn || books.isEmpty()) return 0;
        double total = 0;
        for (Book book : books) {
            total += book.getPrice();
        }
        return total / books.size();
    }

    public Book getMostExpensive() {
        if (!loggedIn || books.isEmpty()) return null;
        Book highest = books.get(0);
        for (Book book : books) {
            if (book.getPrice() > highest.getPrice()) {
                highest = book;
            }
        }
        return highest;
    }

    public Book getCheapest() {
        if (!loggedIn || books.isEmpty()) return null;
        Book lowest = books.get(0);
        for (Book book : books) {
            if (book.getPrice() < lowest.getPrice()) {
                lowest = book;
            }
        }
        return lowest;
    }

    public ArrayList<Book> getLandedBooks() {
        if (!loggedIn) return new ArrayList<>();
        ArrayList<Book> landed = new ArrayList<>();
        for (Book book : books) {
            if (book.isLanded()) {
                landed.add(book);
            }
        }
        return landed;
    }

    public boolean landBook(String name) {
        if (!loggedIn) return false;
        Book book = findBook(name);
        if (book != null) {
            book.setLanded(true);
            return true;
        }
        return false;
    }

    public ArrayList<Book> getAvailableBooks() {
        if (!loggedIn) return new ArrayList<>();
        ArrayList<Book> available = new ArrayList<>();
        for (Book book : books) {
            if (!book.isLanded() && !book.isSold()) {
                available.add(book);
            }
        }
        return available;
    }
}