package work;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import personParameters.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class Parser {
    public static void start(Manager collectionManager){
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = documentBuilder.parse(new File("persons.xml"));
            Element root = doc.getDocumentElement();
            NodeList persons = root.getElementsByTagName("Person");
            for (int i = 0; i < persons.getLength(); i++) {
                Node p = persons.item(i);
                NamedNodeMap attributes = p.getAttributes();
                String newName = attributes.getNamedItem("name").getNodeValue();
                int newHeight = Integer.valueOf(attributes.getNamedItem("height").getNodeValue());
                Double newWeight = Double.valueOf(attributes.getNamedItem("weight").getNodeValue());
                String newPassportId = (attributes.getNamedItem("passportID").getNodeValue());
                Color newColor = Color.valueOf(attributes.getNamedItem("color").getNodeValue());

                String str = (attributes.getNamedItem("dateTime").getNodeValue());
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                LocalDateTime dateTime = LocalDateTime.parse(str, formatter);

                NodeList personObjects = p.getChildNodes();
                NamedNodeMap coordinate = personObjects.item(1).getAttributes();
                Long coordinateX = Long.valueOf(coordinate.getNamedItem("x").getNodeValue());
                Long coordinateY = Long.valueOf(coordinate.getNamedItem("y").getNodeValue());

                NamedNodeMap location = personObjects.item(3).getAttributes();
                Float locationX = Float.valueOf(location.getNamedItem("x").getNodeValue());
                Integer locationY = Integer.valueOf(location.getNamedItem("y").getNodeValue());
                Long locationZ = Long.valueOf(location.getNamedItem("z").getNodeValue());

                Person person = new Person(newName, new Coordinates(coordinateX,coordinateY), dateTime, newHeight, newWeight, newPassportId,
                        newColor, new Location(locationX,locationY,locationZ));
                Manager.add(person);
            }
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        } catch (SAXException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        for (Map.Entry<String, Person> entry : Manager.entrySet()) {
            System.out.println("key:" + entry.getKey() + " value:" + entry.getValue());
        }
    }
}

