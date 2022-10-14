package Commands;

import personParameters.*;
import work.Manager;
import work.Respond;

public class Insert extends AbstractCommand {

    public Insert(Manager collection) {
        super(collection);
    }



    @Override
    public Respond execute(Object argument) {
        Person p = (Person) argument;
        Manager.add(p);
        return new Respond("Объект был добавлен в коллекцию");
    }
}
