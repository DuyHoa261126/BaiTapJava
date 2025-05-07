package Week8;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class UserApp extends JFrame {
	private UserService userService = new UserService();

	public UserApp() {
		setTitle("User Management Application");
		setSize(400, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Panel chính
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 0));
		panel.setLayout(new GridLayout(0, 2));

		// Các thành phần giao diện cho đăng ký
		JLabel lblUsername = new JLabel("Username:");
		JTextField txtUsername = new JTextField();
		JLabel lblPassword = new JLabel("Password:");
		JPasswordField txtPassword = new JPasswordField();
		JLabel lblFullName = new JLabel("Full Name:");
		JTextField txtFullName = new JTextField();
		JLabel lblEmail = new JLabel("Email:");
		JTextField txtEmail = new JTextField();
		JButton btnRegister = new JButton("Register");

		// Các thành phần giao diện cho đăng nhập
		JLabel lblLoginUsername = new JLabel("Username:");
		JTextField txtLoginUsername = new JTextField();
		JLabel lblLoginPassword = new JLabel("Password:");
		JPasswordField txtLoginPassword = new JPasswordField();
		JButton btnLogin = new JButton("Login");

		// Thêm các thành phần vào panel
		panel.add(lblUsername);
		panel.add(txtUsername);
		panel.add(lblPassword);
		panel.add(txtPassword);
		panel.add(lblFullName);
		panel.add(txtFullName);
		panel.add(lblEmail);
		panel.add(txtEmail);
		panel.add(btnRegister);

		panel.add(lblLoginUsername);
		panel.add(txtLoginUsername);
		panel.add(lblLoginPassword);
		panel.add(txtLoginPassword);
		panel.add(btnLogin);

		// Đăng ký người dùng
		btnRegister.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = txtUsername.getText();
				String password = new String(txtPassword.getPassword());
				String fullName = txtFullName.getText();
				String email = txtEmail.getText();
				boolean success = userService.registerUser(username, password, fullName, email);
				if (success) {
					JOptionPane.showMessageDialog(UserApp.this, "Registration Successful");
				} else {
					JOptionPane.showMessageDialog(UserApp.this, "Registration Failed");
				}
			}
		});

		// Đăng nhập người dùng
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = txtLoginUsername.getText();
				String password = new String(txtLoginPassword.getPassword());
				boolean success = userService.loginUser(username, password);
				if (success) {
					JOptionPane.showMessageDialog(UserApp.this, "Login Successful. Welcome " + username);
				} else {
					JOptionPane.showMessageDialog(UserApp.this, "Incorrect username or password.");
				}
			}
		});

		// Thêm panel vào cửa sổ JFrame
		getContentPane().add(panel);

		// Hiển thị giao diện
		setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new UserApp());
	}
}
