package Commands;

import work.*;
import personParameters.*;

import java.util.Map;

public class Update_id extends AbstractCommand {

    public Update_id(Manager collection) {
        super(collection);
    }

    @Override
    public Respond execute(Object argument) {
        boolean flag = true;
        String s = null;
        Person p = (Person) argument;
        String id = p.getkey();
        for(Map.Entry<String, Person> entry: Manager.entrySet()){
            if(entry.getValue().getId() == Long.valueOf(id)){
                p.setId(Long.valueOf(id));
                Manager.changeValueById(p);
                flag = false;
                s = "Элемент был изменен";
                break;
            }
        }
        if(flag){
            s = "Элемента с таким id нет";
        }
        return new Respond(s);
    }
}
