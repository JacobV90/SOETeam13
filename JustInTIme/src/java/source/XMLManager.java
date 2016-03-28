package source;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLManager {

    private static final String USERFILENAME = "xml/inActiveUsers.xml";
    private static final String PRODUCTFILENAME = "xml/ProductNumber.xml";
    private static URL file;

    public static void addUser(ArrayList<String> userArray) {

        try {
            Document document = initialize(USERFILENAME);
            Element root = document.getDocumentElement();
            System.out.println("inActiveUser.xml file found");

            int count = root.getElementsByTagName("user").getLength();

            // Create user element
            Element newUser = document.createElement("user");
            newUser.setAttribute("id", Integer.toString(count));

            // Add user data to inActive list
            int i = 0;
            for (UserFieldEntries entry : UserFieldEntries.values()) {
                Element element = document.createElement(entry.toString());
                element.setTextContent(userArray.get(i));
                newUser.appendChild(element);
                i++;
            }

            root.appendChild(newUser);

            count = root.getElementsByTagName("user").getLength();
            System.out.println("Number of inActive users: " + count);

            close(document);

            System.out.println("User pushed to inActive list");
        } catch (SAXException | IOException | ParserConfigurationException | TransformerException ex) {
            Logger.getLogger(XMLManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static ArrayList<String> getUser(String email) {

        ArrayList<String> userArray = new ArrayList<>();

        try {
            // initialize document and get root element
            Document document = initialize(USERFILENAME);
            Element root = document.getDocumentElement();

            System.out.println("inActiveUser.xml file found");

            NodeList nl = root.getElementsByTagName("user");

            int j = 0;
            while (j < nl.getLength()) {

                Element el = (Element) nl.item(j);
                String userEmail = el.getElementsByTagName("Email").item(0).getTextContent();

                if (userEmail.equalsIgnoreCase(email)) {

                    System.out.println("User found....retrieving and deleting");

                    for (UserFieldEntries entry : UserFieldEntries.values()) {

                        String userData = el.getElementsByTagName(entry.toString()).item(0).getTextContent();

                        userArray.add(userData);
                    }
                    j = nl.getLength();
                    System.out.println("User successfully Retrieved");
                    root.removeChild(el);
                    System.out.println("User removed from inActive list");

                } else {
                    j++;
                }
            }

            System.out.println("Number of inActive users: " + nl.getLength());

            close(document);

        } catch (ParserConfigurationException | SAXException | IOException | TransformerException ex) {
            Logger.getLogger(XMLManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userArray;
    }

    public static int getProductNumber() {

        Document document;
        String itemNum = null;
        int num = 0;
        try {
            
            document = initialize(PRODUCTFILENAME);
            Element root = document.getDocumentElement();
            itemNum = root.getElementsByTagName("number").item(0).getTextContent();
            System.out.println(itemNum);
            num = Integer.getInteger(itemNum);
            System.out.printf("%d \n", num);
            root.getFirstChild().setTextContent(Integer.toString(++num));
            --num;
            close(document);

        } catch (SAXException ex) {
            Logger.getLogger(XMLManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XMLManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XMLManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(XMLManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return num;
    }

    private static Document initialize(String filePath) throws SAXException, IOException, ParserConfigurationException {

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        file = XMLManager.class.getClassLoader().getResource(filePath);
        System.out.println("XML File Found");

        return documentBuilder.parse(file.toString());
    }

    private static void close(Document doc) throws TransformerException {

        DOMSource source = new DOMSource(doc);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        StreamResult result = new StreamResult(file.toString());
        transformer.transform(source, result);

    }

}
