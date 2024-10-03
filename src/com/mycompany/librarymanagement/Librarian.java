package com.mycompany.librarymanagement;

import java.util.ArrayList;
import java.util.List;

public class Librarian {
    private String employeeId;
    private List<Book> bookCollection; // Danh sách sách trong thư viện

    public Librarian(String employeeId) {
        this.employeeId = employeeId;
        this.bookCollection = new ArrayList<>(); // Khởi tạo danh sách sách
    }

    public void addBook(Book book) {
        if (book == null) {
            System.out.println("Error: Cannot add null book.");
            return;
        }
        if (bookCollection.contains(book)) {
            System.out.println("Error: Book already exists in the collection.");
        } else {
            bookCollection.add(book);
            System.out.println("Book added by librarian: " + book.getTenSach());
        }
    }

    public void removeBook(Book book) {
        if (bookCollection.remove(book)) {
            System.out.println("Book removed by librarian: " + book.getTenSach());
        } else {
            System.out.println("Error: Book not found in the collection.");
        }
    }
}
