import com.mycompany.librarymanagement.Book;
import com.mycompany.librarymanagement.Library;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Giao diện đăng nhập
        JPanel panel = new JPanel(new GridLayout(2, 2));

        JLabel userLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();

        panel.add(userLabel);
        panel.add(usernameField);
        panel.add(passLabel);
        panel.add(passwordField);

        // Hiển thị hộp thoại đăng nhập
        int result = JOptionPane.showConfirmDialog(null, panel, "Login", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // Giả sử username và password là "admin"
            if ("admin".equals(username) && "admin".equals(password)) {
                JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");

                // Nếu đăng nhập thành công, bắt đầu quản lý thư viện
                Scanner scanner = new Scanner(System.in);
                Library library = new Library(); // Khởi tạo thư viện

                try {
                    // Nhập số lượng sách
                    System.out.println("Nhập số sách muốn thêm vào thư viện:");
                    int soSach = Integer.parseInt(scanner.nextLine());

                    // Vòng lặp để thêm từng sách vào thư viện
                    for (int i = 0; i < soSach; i++) {
                        System.out.println("Nhập tên sách:");
                        String tenSach = scanner.nextLine();
                        System.out.println("Nhập mã sách:");
                        String maSach = scanner.nextLine();

                        // Kiểm tra xem tên sách và mã sách có bị trống không
                        if (tenSach.isEmpty() || maSach.isEmpty()) {
                            throw new IllegalArgumentException("Tên sách và mã sách không được để trống.");
                        }

                        // Tạo đối tượng sách và thêm vào thư viện
                        Book book = new Book(tenSach, maSach);
                        library.addBook(book);
                    }

                    // Tìm kiếm sách theo mã
                    System.out.println("Nhập mã sách để tìm:");
                    String maTim = scanner.nextLine();
                    Book foundBook = library.findBookById(maTim); // Tìm sách theo mã
                    System.out.println("Sách tìm thấy: " + foundBook.getTenSach());

                } catch (NumberFormatException e) {
                    System.out.println("Lỗi: Vui lòng nhập một số nguyên hợp lệ cho số lượng sách.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Lỗi: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Lỗi không xác định: " + e.getMessage());
                } finally {
                    scanner.close(); // Đảm bảo scanner được đóng
                }

            } else {
                JOptionPane.showMessageDialog(null, "Tên đăng nhập hoặc mật khẩu không đúng.");
            }
        }
    }
}
