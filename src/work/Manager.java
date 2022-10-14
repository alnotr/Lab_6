package work;

import personParameters.*;

import java.util.*;

public class Manager {
    private static TreeMap<String, Person> collection = new TreeMap<String, Person>();
    static int k = 0;
    private static void sizeChange(Integer i){
        if(i > k){
            setK(i);
        }
    }

    public static int getK() {
        return k;
    }

    public static void setK(int k) {
        Manager.k = k;
    }

    public static void add(Person element) {
        sizeChange(collection.size());
        element.setId((long) k+1);
        collection.put(String.valueOf(k+1), element);
        k += 1;
        setK(collection.size());
    }

    public static List<Person> getAllElements() {
        return new ArrayList<>(collection.values());
    }

    public static void clear(){
        collection.clear();
    }

    public static Set<Map.Entry<String, Person>> entrySet(){
        return collection.entrySet();
    }

    public static Person get(String id){
        return collection.get(id);
    }

    public static void removeByKey(String key){
        collection.remove(key);
    }

    public static void changeValueById(Person person) {
        collection.put(person.getkey(), person);
        k += 1;
        setK(collection.size());;
    }

}

