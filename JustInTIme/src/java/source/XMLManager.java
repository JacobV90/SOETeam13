package source;

import java.io.File;
import java.io.IOException;
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

//import com.example.joshkeeganjake.stmpddroidapp.QuestionObject;
/**
 * The QuestionParser class takes in a string for the xml file name for the
 * constructor. The parseQuestionObjects method builds each question object and
 * adds it to the array list.
 *
 * @author Jacob Veal
 *
 */
public class XMLManager {

    private static final String FILENAME = "/Users/jacobveal/NetBeansProjects/JustInTIme/src/java/xml/inActiveUsers.xml";
    private static NodeList nl;

    public static ArrayList<String> getUser(String email) {
        File file = new File(FILENAME);

        if (!file.exists()) {
            System.out.println("File not found");
            return null;
        } else {
            ArrayList<String> userArray = new ArrayList<>();
            
            try {
                DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
                Document document = documentBuilder.parse(file.toString());
                Element root = document.getDocumentElement();

                System.out.println("inActiveUser.xml file found");
                nl = root.getElementsByTagName("user");

                System.out.println("Number of inActive users: " + nl.getLength());

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
                DOMSource source = new DOMSource(document);
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                StreamResult result = new StreamResult(FILENAME);
                transformer.transform(source, result);

            } catch (SAXException ex) {
                Logger.getLogger(XMLManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(XMLManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(XMLManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (TransformerException ex) {
                Logger.getLogger(XMLManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            return userArray;
        }

    }

    public static void addUser(ArrayList<String> userArray) {

        File file = new File(FILENAME);

        if (!file.exists()) {
            System.out.println("File not found");
        } else {
            try {
                DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
                Document document = documentBuilder.parse(file.toString());
                Element root = document.getDocumentElement();
                System.out.println("inActiveUser.xml file found");

                int count = root.getElementsByTagName("user").getLength();
                System.out.println("Number of inActive users: " + count);

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

                DOMSource source = new DOMSource(document);

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                StreamResult result = new StreamResult(FILENAME);
                transformer.transform(source, result);

                System.out.println("User pushed to inActive list");
            } catch (SAXException ex) {
                Logger.getLogger(XMLManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(XMLManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(XMLManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (TransformerException ex) {
                Logger.getLogger(XMLManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    

    

    /**
     * Retrieves the questions answers and places them into an array. The
     * correct answer's index is placed in the arrays last index.
     *
     * @param elem
     * @param tagName
     * @return
     */

    /**
     * Returns the images id in the xml file
     *
     * @param el
     * @param tagName
     * @return
     */

}
