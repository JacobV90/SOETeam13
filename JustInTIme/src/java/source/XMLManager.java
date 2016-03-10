package source;

import com.QuestionObject.QuestionObject;
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
import org.jsoup.Jsoup;
import org.w3c.dom.Node;

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

    /* private static void parseXmlFile() {

        // get the factory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        
        Document doc;
     
            try {
                // Using factory get an instance of document builder
                DocumentBuilder db = dbf.newDocumentBuilder();

                // parse using builder to get DOM representation of the XML file
                //doc = db.parse(file);
                //Element docEle = doc.getDocumentElement();

                //each object is separated by a item tag
                nl = docEle.getElementsByTagName("users");

            } catch (ParserConfigurationException pce) {
                pce.printStackTrace();
            } catch (SAXException se) {
                se.printStackTrace();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        
    }*/
    
    public static void main(String[] args){
        
        ArrayList<String> userArray = new ArrayList<>();
        userArray.add("hello");
        addUser(userArray);
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

                System.out.println("made it to xml");
                // user elements
                Element newUser = document.createElement("user");
                newUser.setAttribute("email", userArray.get(0));

                Element BirthMonth = document.createElement("FirstName");
                BirthMonth.setTextContent(userArray.get(1));
                newUser.appendChild(BirthMonth);

                Element LastName = document.createElement("LastName");
                LastName.setTextContent(userArray.get(2));
                newUser.appendChild(LastName);

                Element password = document.createElement("Password");
                password.setTextContent(userArray.get(3));
                newUser.appendChild(password);

                Element birthMonth = document.createElement("BirthMonth");
                birthMonth.setTextContent(userArray.get(4));
                newUser.appendChild(birthMonth);

                Element birthDay = document.createElement("BirthDay");
                birthDay.setTextContent(userArray.get(5));
                newUser.appendChild(birthDay);

                Element birthYear = document.createElement("BirthYear");
                birthYear.setTextContent(userArray.get(6));
                newUser.appendChild(birthYear);

                Element gender = document.createElement("gender");
                gender.setTextContent(userArray.get(7));
                newUser.appendChild(gender);

                Element phoneNumber = document.createElement("PhoneNumber");
                phoneNumber.setTextContent(userArray.get(8));
                newUser.appendChild(phoneNumber);

                Element pinCode = document.createElement("PinCode");
                pinCode.setTextContent(userArray.get(9));
                newUser.appendChild(pinCode);

                root.appendChild(newUser);

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
        }
    }

    public static ArrayList<QuestionObject> parseQuestionObjects() {

        ArrayList<QuestionObject> questionArray = new ArrayList<QuestionObject>();

        if (nl != null && nl.getLength() > 0) {

            for (int i = 0; i < nl.getLength(); i++) {

                // get the question element
                Element el = (Element) nl.item(i);

                // get the object
                // add it to list
            }
        }
        return questionArray;
    }

    private String getValue(Element ele, String tagName) {
        String textVal = null;
        NodeList nl = ele.getElementsByTagName(tagName);

        if (nl != null && nl.getLength() > 0) {
            Element el = (Element) nl.item(0);
            textVal = el.getTextContent();
            StringBuilder sb = new StringBuilder();
            sb.append(textVal);

            try {
                return extractText(sb);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;

    }

    /**
     * Retrieves the questions answers and places them into an array. The
     * correct answer's index is placed in the arrays last index.
     *
     * @param elem
     * @param tagName
     * @return
     */
    private String[] getAnswers(Element elem, String tagName) {

        NodeList nl = elem.getElementsByTagName(tagName);
        NodeList nl2 = elem.getElementsByTagName("setvar");

        String[] array = new String[nl.getLength() + 1];

        if (nl != null && nl.getLength() > 0) {
            for (int i = 0; i < nl.getLength(); i++) {
                Element el = (Element) nl.item(i);
                Element el2 = (Element) nl2.item(i);

                StringBuilder sb = new StringBuilder();
                sb.append(el.getTextContent());

                try {
                    String line = extractText(sb);
                    if (!line.equals("\"")) {
                        array[i] = line;
                        if (el2.getTextContent().equals("1")) {
                            array[nl.getLength()] = String.valueOf(i);

                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }
        return array;

    }

    /**
     * Returns the images id in the xml file
     *
     * @param el
     * @param tagName
     * @return
     */
    private String getImage(Element el, String tagName) {

        NodeList nl2 = el.getElementsByTagName(tagName);

        if (nl2 != null && nl2.getLength() > 0) {
            Element elem = (Element) nl2.item(0);

            if (elem.hasAttribute("uri")) {
                return elem.getAttribute("uri");

            }
        }
        return null;
    }

    private String extractText(StringBuilder sb) throws IOException {

        String textOnly = Jsoup.parse(sb.toString()).text();
        return textOnly;
    }

}
