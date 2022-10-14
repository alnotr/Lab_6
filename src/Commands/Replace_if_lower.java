package Commands;

import work.*;
import personParameters.*;

public class Replace_if_lower extends AbstractCommand {

    public Replace_if_lower(Manager collection) {
        super(collection);
    }

    @Override
    public Respond execute(Object argument) {
        String s = null;
        Person newPerson = (Person) argument;
        Person oldperson = Manager.get(newPerson.getkey());
        if(newPerson.compareTo(oldperson) < 0){
            newPerson.setId(Long.valueOf(newPerson.getkey()));
            Manager.changeValueById(newPerson);
            s = "Элемент был заменен";
        }else{
            s = "Элемент не был заменен";
        }
        return new Respond(s);
    }
}
