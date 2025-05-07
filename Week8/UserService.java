package Week8;

import org.mindrot.jbcrypt.BCrypt;

public class UserService {

    // Đăng ký người dùng mới, lưu mật khẩu đã băm
    public boolean registerUser(String username, String password, String fullName, String email) {
        String passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());
        // Lưu thông tin người dùng vào cơ sở dữ liệu hoặc bộ nhớ
        User user = new User(username, passwordHash, fullName, email);
        // Lưu vào cơ sở dữ liệu hoặc danh sách người dùng
        return true; // Giả sử thành công
    }

    // Đăng nhập người dùng, so sánh mật khẩu đã băm
    public boolean loginUser(String username, String password) {
        // Lấy mật khẩu băm từ cơ sở dữ liệu
        String passwordHash = getUserPasswordHashFromDatabase(username);
        if (passwordHash != null) {
            return BCrypt.checkpw(password, passwordHash);
        }
        return false;
    }

    private String getUserPasswordHashFromDatabase(String username) {
        // Lấy mật khẩu đã băm từ cơ sở dữ liệu hoặc bộ nhớ
        return "$2a$10$"; // Ví dụ mật khẩu băm
    }
}
