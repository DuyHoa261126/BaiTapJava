package Week6;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.w3c.dom.Document;

public class XMLGUI {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Trình chỉnh sửa XML");
		frame.getContentPane().setBackground(new Color(0, 128, 0));
		frame.setSize(500, 481);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JTextField filePath = new JTextField();
		filePath.setBounds(20, 61, 440, 25);
		frame.getContentPane().add(filePath);

		JButton readBtn = new JButton("Đọc");
		readBtn.setBounds(271, 97, 80, 25);
		frame.getContentPane().add(readBtn);

		JButton addBtn = new JButton("Thêm");
		addBtn.setBounds(20, 97, 80, 25);
		frame.getContentPane().add(addBtn);

		JButton updateBtn = new JButton("Cập nhật");
		updateBtn.setBounds(134, 97, 100, 25);
		frame.getContentPane().add(updateBtn);

		JButton deleteBtn = new JButton("Xóa");
		deleteBtn.setBounds(380, 97, 80, 25);
		frame.getContentPane().add(deleteBtn);

		JTextArea result = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(result);
		scrollPane.setBounds(20, 133, 440, 286);
		frame.getContentPane().add(scrollPane);

		JLabel lblNewLabel = new JLabel("Link");
		lblNewLabel.setForeground(new Color(248, 248, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(20, 36, 46, 14);
		frame.getContentPane().add(lblNewLabel);

		readBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					XMLHandler handler = new XMLHandler(filePath.getText());
					Document doc = handler.docXML();
					result.setText("Root: " + doc.getDocumentElement().getNodeName());
				} catch (Exception ex) {
					result.setText("Lỗi: " + ex.getMessage());
				}
			}
		});

		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					XMLHandler handler = new XMLHandler(filePath.getText());
					handler.themPhanTu("root", "newElement", "Nội dung mới", "thuocTinh", "giaTri");
					result.setText("Đã thêm phần tử.");
				} catch (Exception ex) {
					result.setText("Lỗi: " + ex.getMessage());
				}
			}
		});

		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					XMLHandler handler = new XMLHandler(filePath.getText());
					handler.capNhatPhanTu("newElement", "Nội dung đã được cập nhật");
					result.setText("Đã cập nhật phần tử.");
				} catch (Exception ex) {
					result.setText("Lỗi: " + ex.getMessage());
				}
			}
		});

		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					XMLHandler handler = new XMLHandler(filePath.getText());
					handler.xoaNodeTheoTag("newElement");
					result.setText("Đã xóa phần tử.");
				} catch (Exception ex) {
					result.setText("Lỗi: " + ex.getMessage());
				}
			}
		});

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
