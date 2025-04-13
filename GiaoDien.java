package DangKi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GiaoDien extends JFrame {
    private JTextField txtName;
    private JTextField txtEmail;
    private JPasswordField txtPassword;
    private final database db = new database();

    public GiaoDien() {
        setTitle("Đăng ký người dùng");
        setSize(450, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblTitle = new JLabel("Đăng Ký", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Serif", Font.BOLD, 24));
        lblTitle.setBounds(150, 60, 150, 30);
        add(lblTitle);

        JLabel lblName = new JLabel("Tên người dùng:");
        lblName.setBounds(60, 130, 120, 25);
        add(lblName);

        txtName = new JTextField();
        txtName.setBounds(60, 160, 320, 30);
        add(txtName);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(60, 210, 100, 25);
        add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(60, 240, 320, 30);
        add(txtEmail);

        JLabel lblPassword = new JLabel("Mật khẩu:");
        lblPassword.setBounds(60, 290, 100, 25);
        add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(60, 320, 320, 30);
        add(txtPassword);

        JButton btnRegister = new JButton("Xác nhận");
        btnRegister.setBounds(160, 400, 120, 35);
        add(btnRegister);

        btnRegister.addActionListener(e -> handleRegister());
    }

    private void handleRegister() {
        String name = txtName.getText().trim();
        String email = txtEmail.getText().trim();
        String password = new String(txtPassword.getPassword());

        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin.");
            return;
        }

        if (db.KetNoi(name, email, password)) {
            JOptionPane.showMessageDialog(this, "Đăng ký thành công!");
        } else {
            JOptionPane.showMessageDialog(this, "Tên người dùng đã tồn tại.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GiaoDien().setVisible(true));
    }
}
