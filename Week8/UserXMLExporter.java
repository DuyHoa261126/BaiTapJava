package Week8;

import java.io.File;
import java.io.FileWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class UserXMLExporter {

	public void exportUserToXML(User user) {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();

			// Tạo phần tử root
			Element rootElement = doc.createElement("users");
			doc.appendChild(rootElement);

			// Tạo phần tử user
			Element userElement = doc.createElement("user");
			rootElement.appendChild(userElement);

			// Tạo các phần tử con
			userElement.appendChild(createElement(doc, "username", user.getUsername()));
			userElement.appendChild(createElement(doc, "fullName", user.getFullName()));
			userElement.appendChild(createElement(doc, "email", user.getEmail()));

			// Ghi vào file XML
			FileWriter writer = new FileWriter(new File("user_data.xml"));
			writer.write(docToString(doc));
			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Element createElement(Document doc, String tagName, String value) {
		Element element = doc.createElement(tagName);
		element.appendChild(doc.createTextNode(value));
		return element;
	}

	private String docToString(Document doc) {
		// Chuyển Document thành String
		// Cần cài thêm các lớp để chuyển đổi Document sang String
		return ""; // Placeholder
	}
}
