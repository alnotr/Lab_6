package Commands;

import work.*;
import personParameters.*;

public class Remove_key extends AbstractCommand {

    public Remove_key(Manager collection) {
        super(collection);
    }

    @Override
    public Respond execute(Object argument) {
        String s = (String) argument;
        Manager.removeByKey(s);
        return new Respond("Элемент с ключом " + s + "был удален из коллекции");
    }
}
