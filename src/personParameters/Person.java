package personParameters;

import work.Manager;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;

public class Person implements Map.Entry<String, Person>, Serializable {
    private Long id;
    int key;
    private String name;
    private Coordinates coordinates;
    private LocalDateTime creationDate;
    private int height;
    private Double weight;
    private String passportID;
    private Color color;
    private Location location;
    private long newId = 0;


    public Person(String name, Coordinates coordinates, int height, Double weight, String passportID, Color color, Location location){
        creationDate = LocalDateTime.now().withNano(0);
        this.id = newId;
        this.name = name;
        this.coordinates = coordinates;
        this.location = location;
        this.height = height;
        this.weight = weight;
        this.passportID = passportID;
        this.color = color;
    }
    public Person(int key, String name, Coordinates coordinates, int height, Double weight, String passportID, Color color, Location location){
        creationDate = LocalDateTime.now().withNano(0);
        this.key = key;
        this.id = newId;
        this.name = name;
        this.coordinates = coordinates;
        this.location = location;
        this.height = height;
        this.weight = weight;
        this.passportID = passportID;
        this.color = color;
    }
    public Person(String name, Coordinates coordinates, LocalDateTime dateTime, int height, Double weight, String passportID, Color color, Location location){
        this.creationDate = dateTime;
        this.id = Long.valueOf(Manager.getK()+1);
        this.name = name;
        this.coordinates = coordinates;
        this.location = location;
        this.height = height;
        this.weight = weight;
        this.passportID = passportID;
        this.color = color;
    }
    public String getkey(){
        return String.valueOf(key);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public int getHeight() {
        return height;
    }

    public Double getWeight() {
        return weight;
    }

    public String getPassportID() {
        return passportID;
    }

    public Color getColor() {
        return color;
    }

    public Location getLocation() {
        return location;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person {" +
                " id = " + id  +
                ", name = '" + name + '\'' +
                ", coordinates = " + coordinates +
                ", dateTime = " + creationDate +
                ", height = " + height +
                ", weight = " + weight +
                ", passportID ='" + passportID + '\'' +
                ", color = " + color +
                ", location = " + location +
                '}';
    }

    public int compareTo(Person person) {
        return id.compareTo(person.getId());
    }

    @Override
    public String getKey() {
        return null;
    }

    @Override
    public Person getValue() {
        return null;
    }

    @Override
    public Person setValue(Person value) {
        return null;
    }

}
