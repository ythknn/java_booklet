public class Main {
    public static void main(String[] args) {
        BookStore store = new BookStore();
        
        if (store.login("admin123")) {
            store.addBook(new Book("Java Basic", 200, "ABC", 29.99));
            store.addBook(new Book("Web Dev", 150, "XYZ", 19.99));
            
            System.out.println("Total books: " + store.getBooks().size());
            
            Book found = store.findBook("Java Basic");
            if (found != null) {
                store.landBook(found.getName());
            }
            
            System.out.println("Available books: " + store.getAvailableBooks().size());
            store.logout();
        }
    }
}