package ex2;

import java.util.Arrays;

public class Book1 {
    private String isbn;
    private String name;
    private Author[] authors;
    private double price;
    private int qty = 0;

    public Book1(String name, Author[] authors, double price) {
        this.name = name;
        this.authors = authors;
        this.price = price;
    }

    public Book1(String isbn, String name, Author[] authors, double price, int qty) {
        this.isbn = isbn;
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public void setAuthors(Author[] authors) {
        this.authors = authors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book1 [name=" + name + ", authors=" + Arrays.toString(authors) + ", price=" + price + ", qty=" + qty + "]";
    }

    public String getAuthorNames() {
        StringBuilder names = new StringBuilder();
        for (Author author : authors) {
            names.append(author.getName()).append(", ");
        }
        if (names.length() > 0) {
            names.setLength(names.length() - 2); 
        }
        return names.toString();
    }

    public static void main(String[] args) {
        
        Author a1 = new Author("Tan Ah Teck", "ahteck@nowhere.com", 'm');
        System.out.println(a1);

        a1.setEmail("ahteck@somewhere.com");
        System.out.println(a1);
        System.out.println("name is: " + a1.getName());
        System.out.println("email is: " + a1.getEmail());

   
        Book1 b1 = new Book1("12345", "Java for dummies", new Author[]{a1}, 8.8, 88);
        System.out.println(b1);

        b1.setPrice(9.9);
        b1.setQty(99);
        System.out.println(b1);
        System.out.println("isbn is: " + b1.getIsbn());
        System.out.println("name is: " + b1.getName());
        System.out.println("price is: " + b1.getPrice());
        System.out.println("qty is: " + b1.getQty());

     
        System.out.println("authors: " + Arrays.toString(b1.getAuthors()));  
        System.out.println("authors' names: " + b1.getAuthorNames()); 
    }
}
