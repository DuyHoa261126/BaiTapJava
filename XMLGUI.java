package Week5;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.Document;

public class XMLGUI {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Trình chỉnh sửa XML");
		frame.getContentPane().setBackground(new Color(0, 128, 0));
		frame.getContentPane().setForeground(new Color(0, 0, 255));
		frame.setSize(492, 469);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JTextField filePath = new JTextField();
		filePath.setBounds(20, 59, 432, 25);
		frame.getContentPane().add(filePath);

		JButton readBtn = new JButton("Đọc");
		readBtn.setBounds(196, 107, 80, 25);
		frame.getContentPane().add(readBtn);

		JButton addBtn = new JButton("Thêm");
		addBtn.setBounds(20, 107, 80, 25);
		frame.getContentPane().add(addBtn);

		JButton delBtn = new JButton("Xóa");
		delBtn.setBounds(371, 107, 80, 25);
		frame.getContentPane().add(delBtn);

		JTextArea result = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(result);
		scrollPane.setBounds(20, 156, 432, 263);
		frame.getContentPane().add(scrollPane);

		JLabel lblNewLabel = new JLabel("Link");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(248, 248, 255));
		lblNewLabel.setBounds(20, 34, 46, 14);
		frame.getContentPane().add(lblNewLabel);

		readBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					XMLHandler handler = new XMLHandler(filePath.getText());
					Document doc = handler.docXML();
					result.setText(doc.getDocumentElement().getNodeName());
				} catch (Exception ex) {
					result.setText("Lỗi: " + ex.getMessage());
				}
			}
		});

		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					XMLHandler handler = new XMLHandler(filePath.getText());
					handler.themPhanTu("root", "newElement", "Nội dung", "thuocTinh", "giaTri");
					result.setText("Đã thêm phần tử.");
				} catch (Exception ex) {
					result.setText("Lỗi: " + ex.getMessage());
				}
			}
		});

		delBtn.addActionListener(new ActionListener() {
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

		frame.setVisible(true);
	}
}