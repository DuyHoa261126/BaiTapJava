package Week6;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;
import java.util.*;

public class XMLHandler {
    private File xmlFile;
    private DocumentBuilder builder;

    public XMLHandler(String path) throws Exception {
        xmlFile = new File(path);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
    }

    public Document docXML() throws Exception {
        return builder.parse(xmlFile);
    }

    public void ghiXML(Document doc) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(xmlFile);
        transformer.transform(source, result);
    }

    public void themPhanTu(String parentTag, String newTag, String textContent, String attrName, String attrValue) throws Exception {
        Document doc = docXML();
        NodeList parents = doc.getElementsByTagName(parentTag);
        if (parents.getLength() > 0) {
            Element newElement = doc.createElement(newTag);
            newElement.setTextContent(textContent);
            newElement.setAttribute(attrName, attrValue);
            parents.item(0).appendChild(newElement);
            ghiXML(doc);
        }
    }

    public void xoaNodeTheoTag(String tagName) throws Exception {
        Document doc = docXML();
        NodeList nodes = doc.getElementsByTagName(tagName);
        if (nodes.getLength() > 0) {
            Node node = nodes.item(0);
            Node parent = node.getParentNode();
            parent.removeChild(node);
            ghiXML(doc);
        }
    }

    public void capNhatPhanTu(String tagName, String newContent) throws Exception {
        Document doc = docXML();
        NodeList nodes = doc.getElementsByTagName(tagName);
        if (nodes.getLength() > 0) {
            nodes.item(0).setTextContent(newContent);
            ghiXML(doc);
        }
    }

    public void ghepXML(Node rootNode, List<Node> nodesToAdd) throws Exception {
        Document doc = rootNode.getOwnerDocument();
        for (Node node : nodesToAdd) {
            rootNode.appendChild(node);
        }
        ghiXML(doc);
    }
}
