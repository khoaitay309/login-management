package com.mycompany.librarymanagement;

public class Member {
    private String memberId;
    private String name;
    private String email;

    public Member(String memberId, String name, String email) {
        if (memberId == null || memberId.trim().isEmpty()) {
            throw new IllegalArgumentException("Member ID không được để trống");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên không được để trống");
        }
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email không được để trống");
        }

        this.memberId = memberId;
        this.name = name;
        this.email = email;
    }

    // Thêm phương thức getName()
    public String getName() {
        return name;
    }

    public void borrowBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Sách không hợp lệ");
        }
        if (book.isBorrowed()) {
            System.out.println("Sách đã được mượn trước đó.");
        } else {
            book.checkOut();
            System.out.println(name + " đã mượn sách: " + book.getTenSach());
        }
    }

    public void returnBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Sách không hợp lệ");
        }
        if (!book.isBorrowed()) {
            System.out.println("Sách chưa được mượn nên không thể trả.");
        } else {
            book.returnBook();
            System.out.println(name + " đã trả sách: " + book.getTenSach());
        }
    }
}
