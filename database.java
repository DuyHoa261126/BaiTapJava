package database;

import org.mindrot.jbcrypt.BCrypt;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class database {
    private static final String URL = "jdbc:mysql://localhost:3306/doan";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection LayKetNoi() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public boolean Kiemtra(String name) {
        String sql = "SELECT 1 FROM user WHERE name = ?";
        try (Connection conn = LayKetNoi();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean KetNoi(String name, String email, String password) {
        if (Kiemtra(name)) {
            return false;
        }

        String sql = "INSERT INTO user(name, email, hashPassword) VALUES (?, ?, ?)";
        try (Connection conn = LayKetNoi();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, hashedPassword);
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<dangki> Layds(String name) {
        List<dangki> list = new ArrayList<>();
        String sql = "SELECT name, email FROM user WHERE name = ?";
        try (Connection conn = LayKetNoi();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    dangki u = new dangki();
                    u.setName(rs.getString("name"));
                    u.setEmail(rs.getString("email"));
                    list.add(u);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<dangki> nhapXML(String path) {
        List<dangki> list = new ArrayList<>();
        try {
            File f = new File(path);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(f);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("user");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node n = nodeList.item(i);
                if (n.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) n;
                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    String email = element.getElementsByTagName("email").item(0).getTextContent();
                    list.add(new dangki(name, email, ""));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void xuatXML(List<dangki> list, String path) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element root = doc.createElement("users");
            doc.appendChild(root);

            for (dangki user : list) {
                Element userElement = doc.createElement("user");

                Element nameElement = doc.createElement("name");
                nameElement.appendChild(doc.createTextNode(user.getName()));
                userElement.appendChild(nameElement);

                Element emailElement = doc.createElement("email");
                emailElement.appendChild(doc.createTextNode(user.getEmail()));
                userElement.appendChild(emailElement);

                root.appendChild(userElement);
            }

            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(path));
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
