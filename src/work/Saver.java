package work;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import personParameters.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Saver {
    /**
     * xml constructor
     * @param collection
     */
    public static void start(Set<Map.Entry<String, Person>> collection) {
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = documentBuilder.newDocument();
            Node root = doc.createElement("Persons");
            doc.appendChild(root);
            Iterator<Map.Entry<String, Person>> iterator = collection.iterator();
            while (iterator.hasNext()) {
                 Map.Entry<String, Person> item = iterator.next();
                 Person p = item.getValue();
                 addNewPerson(doc, p,root);
            }
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Method to create all tags and add information
     * @param document
     * @param person
     * @param root
     */
    public static void addNewPerson(Document document, Person person,Node root) {

        Element personElement = document.createElement("Person");
        personElement.setAttribute("name",person.getName());
        personElement.setAttribute("height",String.valueOf(person.getHeight()));
        personElement.setAttribute("weight",String.valueOf(person.getWeight()));
        personElement.setAttribute("passportID",person.getPassportID());
        personElement.setAttribute("color",String.valueOf(person.getColor()));
        personElement.setAttribute("dateTime",String.valueOf(person.getCreationDate()));

        Element location = document.createElement("location");
        location.setAttribute("x",String.valueOf(person.getLocation().getX()));
        location.setAttribute("y",String.valueOf(person.getLocation().getY()));
        location.setAttribute("z",String.valueOf(person.getLocation().getZ()));

        Element coordinates = document.createElement("coordinates");
        coordinates.setAttribute("x", String.valueOf(person.getCoordinates().getX()));
        coordinates.setAttribute("y", String.valueOf(person.getCoordinates().getY()));


        personElement.appendChild(coordinates);
        personElement.appendChild(location);
        root.appendChild(personElement);

        writeDocument(document);
    }

    /**
     * Method to save the end result
     * @param document
     * @throws TransformerFactoryConfigurationError
     */
    private static void writeDocument(Document document) throws TransformerFactoryConfigurationError {
            try {
                Transformer tr = TransformerFactory.newInstance().newTransformer();
                DOMSource source = new DOMSource(document);
                FileOutputStream fos = new FileOutputStream("other.xml");
                StreamResult result = new StreamResult(fos);
                tr.transform(source, result);
            } catch (TransformerException | IOException e) {
                e.printStackTrace(System.out);
            }
        }
    }
