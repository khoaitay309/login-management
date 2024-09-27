package com.mycompany.librarymanagement;

import java.util.ArrayList;

public class Library {
    private String name;
    private String address;
    private ArrayList<Book> books;
    private ArrayList<Member> members;

    public Library(String name, String address) {
        this.name = name;
        this.address = address;
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void registerMember(Member member) {
        members.add(member);
    }

    public String getName() {
        return name;
    }
}