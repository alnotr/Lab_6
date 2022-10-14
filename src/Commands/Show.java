package Commands;

import work.Manager;
import work.Respond;
import personParameters.*;

import java.util.List;
import java.util.Map;

public class Show extends AbstractCommand {
    public Show(Manager collection) {
        super(collection);
    }


    @Override
    public Respond execute(Object argument) {
        List<Person> collection = Manager.getAllElements();
        String str = "";
        if(collection.size() == 0){
            str = "Коллекция пуста";
        }
        for(Map.Entry<String,Person> entry: Manager.entrySet()){
            str += "key:" + entry.getKey() + " value:" + entry.getValue() +"\n";
        }
        return new Respond(str);
    }

}
