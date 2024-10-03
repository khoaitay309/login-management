package com.mycompany.librarymanagement;

import com.mycompany.librarymanagement.Book;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    // Thêm sách vào thư viện
    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Sách không được là null.");
        }
        books.add(book);
    }

    // Tìm sách theo mã
    public Book findBookById(String maSach) {
        for (Book book : books) {
            if (book.getMaSach().equals(maSach)) {
                return book;
            }
        }
        // Nếu không tìm thấy, ném ra ngoại lệ
        throw new IllegalArgumentException("Sách với mã '" + maSach + "' không tồn tại.");
    }
}
