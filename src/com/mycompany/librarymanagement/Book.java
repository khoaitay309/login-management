package com.mycompany.librarymanagement;

public class Book {
    private String tenSach;
    private String maSach;

    public Book(String tenSach, String maSach) {
        // Kiểm tra tính hợp lệ của tên sách và mã sách
        if (tenSach == null || tenSach.isEmpty()) {
            throw new IllegalArgumentException("Tên sách không được để trống.");
        }
        if (maSach == null || maSach.isEmpty()) {
            throw new IllegalArgumentException("Mã sách không được để trống.");
        }
        this.tenSach = tenSach;
        this.maSach = maSach;
    }

    public String getMaSach() {
        return maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public boolean isBorrowed(){
        return true;
    }

    public void checkOut(){

    };
    public void returnBook(){

    };
}
