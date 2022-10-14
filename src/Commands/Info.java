package Commands;

import work.Manager;
import work.Respond;

public class Info extends AbstractCommand {

    public Info(Manager collection) {
        super(collection);
    }

    @Override
    public Respond execute(Object argument) {
        String s = "Тип этой коллекции - TreeMap";
        return new Respond(s);
    }
}
