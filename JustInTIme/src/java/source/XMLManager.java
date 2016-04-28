package source;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
    private static final String PURCHASEFILENAME = "xml/PurchaseOrders.xml";
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

    public static void addProductToCart(String email, Product product) {

        Document document;

        try {

            document = initialize(PRODUCTFILENAME);
            Element root = document.getDocumentElement();
            NodeList nl = root.getElementsByTagName("user");
            String userEmail = null;
            Element user = null;

            for (int i = 0; i < nl.getLength(); ++i) {
                user = (Element) nl.item(i);
                if (user.getAttribute("email").equals(email)) {
                    userEmail = user.getAttribute("email");
                    i = nl.getLength(); // exit loop
                }
            }

            if (userEmail == null & userEmail != "") {
                System.out.println("User not found. Adding user and product to cart...");
                Element newUser = document.createElement("user");
                Element item = document.createElement("product");
                newUser.setAttribute("email", email);
                item.setAttribute("id", String.valueOf(product.getItemNo()));
                ArrayList<String> array = product.getProduct();

                for (String value : array) {
                    Element el = document.createElement("productValue");
                    el.setTextContent(value);
                    item.appendChild(el);
                }

                newUser.appendChild(item);
                root.appendChild(newUser);
                System.out.println(email + " and product added to cart");

            } else {
                System.out.println(email + " found. Adding product...");
                Element item = document.createElement("product");
                item.setAttribute("id", String.valueOf(product.getItemNo()));
                ArrayList<String> array = product.getProduct();

                for (String value : array) {
                    Element el = document.createElement("productValue");
                    el.setTextContent(value);
                    item.appendChild(el);
                }

                user.appendChild(item);
                System.out.println("Product added to " + email + "'s cart");

            }
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

    }

    public static void removeProductFromCart(String email, String itemNum) {
        Document document;
        try {

            document = initialize(PRODUCTFILENAME);
            Element root = document.getDocumentElement();
            NodeList nl = root.getElementsByTagName("user");
            Element user = null;

            //Find user by email
            for (int i = 0; i < nl.getLength(); ++i) {
                user = (Element) nl.item(i);
                if (user.getAttribute("email").equals(email)) {
                    i = nl.getLength(); //Found user, exit loop
                }
            }

            //Iterate through users product list
            NodeList nl2 = user.getElementsByTagName("product");
            for (int i = 0; i < nl2.getLength(); ++i) {
                Element el = (Element) nl2.item(i);

                //If product node attribute matches specified item remove from user node
                if (el.getAttribute("id").equals(itemNum)) {
                    user.removeChild(nl2.item(i));
                }
            }
            System.out.println("Item removed from " + email + "'s cart");

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

    }

    public static ProductContainer getCart(String email) {

        Document document;
        List<Product> cart = new ArrayList<>();
        ProductContainer cartObj = new ProductContainer(email);

        try {
            document = initialize(PRODUCTFILENAME);
            Element root = document.getDocumentElement();
            NodeList nl = root.getElementsByTagName("user");

            for (int i = 0; i < nl.getLength(); ++i) {
                Element user = (Element) nl.item(i);

                if (user.getAttribute("email").equals(email)) {

                    NodeList nl2 = user.getElementsByTagName("product");
                    System.out.println("User found. Retrieving cart..");
                    System.out.println("Number of products: " + nl2.getLength());

                    for (int j = 0; j < nl2.getLength(); ++j) {
                        List<String> list = new ArrayList<>();
                        Element item = (Element) nl2.item(j);
                        NodeList nl3 = item.getElementsByTagName("productValue");
                        for (int k = 0; k < nl3.getLength(); ++k) {
                            list.add(nl3.item(k).getTextContent());
                        }
                        Product product = new Product();
                        product.createProduct(list);
                        cart.add(product);
                        cartObj.addProduct(product);
                    }

                    i = nl.getLength(); // exit loop
                }
            }
            System.out.println("User cart Retrieved");
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

        return cartObj;
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

    public static void addPurchaseOrder(PurchaseOrder po) {

        Document document;

        try {

            document = initialize(PURCHASEFILENAME);
            Element root = document.getDocumentElement();
            System.out.println("PurchaseOrder.xml file found");

            //int count = root.getElementsByTagName("user").getLength();
            // Create purchase order element
            Element purchase = document.createElement("purchase");
            purchase.setAttribute("number", po.getPurchaseNumber());

            // Add purchase order element
            ProductContainer cart = po.getPurchasedItems();

            for (Product item : cart.getProductArray()) {
                Element product = document.createElement("Product");
                product.setAttribute("number", String.valueOf(item.getItemNo()));

                int i = 0;
                for (String value : item.getProduct()) {

                    Element el = document.createElement("Value");
                    el.setTextContent(value);
                    product.appendChild(el);

                }
                purchase.appendChild(product);
                i++;
            }

            root.appendChild(purchase);

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

    }

    public static PurchaseOrder getPurchaseOrder(String poNum) {

        Document document;
        PurchaseOrder purchase = new PurchaseOrder();

        int num = 0;
        try {
            // initialize document and get root element
            document = initialize(PURCHASEFILENAME);
            Element root = document.getDocumentElement();

            System.out.println("PurchaseOrder.xml file found");

            NodeList nl = root.getElementsByTagName("purchase");

            System.out.println(nl.getLength());
            int j = 0;
            while (j < nl.getLength()) {

                Element el = (Element) nl.item(j);
                String poNumber = el.getAttribute("number");
                System.out.println(poNumber);

                if (poNumber.equalsIgnoreCase(poNum)) {
                    System.out.println("Purchase Order found");

                    ProductContainer cart = new ProductContainer();

                    NodeList nl2 = el.getElementsByTagName("Product");
                    System.out.println(nl2.getLength());

                    for (int i = 0; i < nl2.getLength(); ++i) {

                        Element el3 = (Element) nl2.item(i);
                        Product product = new Product();
                        NodeList nl3 = el3.getElementsByTagName("Value");
                        System.out.println(nl3.getLength());

                        List<String> list = new ArrayList<>();
                        for (int k = 0; k < nl3.getLength(); k++) {
                            System.out.println(nl3.item(k).getTextContent());
                            list.add(nl3.item(k).getTextContent());
                        }
                        product.createProduct(list);
                        //product.setDeliveryDate(list.get(k));
                        cart.addProduct(product);

                    }
                    purchase.setPurchasedItems(cart);

                    j = nl.getLength();
                    System.out.println("Purchase Order successfully Retrieved");

                } else {
                    j++;
                }
            }

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

        return purchase;
    }

    private static Document initialize(String filePath) throws SAXException, IOException, ParserConfigurationException {

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        file = XMLManager.class.getClassLoader().getResource(filePath);
        System.out.println("XML File Found");

        return documentBuilder.parse(file.toString());
    }

    /**
     * Writes the contents of the document object to the DOM (Document Object
     * Model) source.
     *
     * @param doc - the document object
     * @throws TransformerException
     */
    private static void close(Document doc) throws TransformerException {

        DOMSource source = new DOMSource(doc);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        StreamResult result = new StreamResult(file.toString());
        transformer.transform(source, result);

    }

}
