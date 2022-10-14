package Commands;

import work.*;
import personParameters.*;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Remove_lower_key extends AbstractCommand {

    public Remove_lower_key(Manager collection) {
        super(collection);
    }

    @Override
    public Respond execute(Object argument) {
        int count = 0;
        int arg = (Integer) argument;
        Set<Map.Entry<String, Person>> entrySet = new HashSet<>(Manager.entrySet());
        for(Map.Entry<String, Person> entry : entrySet) {
            String key = entry.getKey();
            if(arg >Integer.valueOf(key)){
                Manager.removeByKey(key);
                count += 1;
            }
        }
        return new Respond("Было удалено следующее количество элементов : " + count);
    }
}
