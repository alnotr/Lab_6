package Commands;

import work.Manager;
import work.Respond;
import work.Saver;

public class Save extends AbstractCommand {

    public Save(Manager collection) {
        super(collection);
    }

    @Override
    public Respond execute(Object argument) {
        Saver.start(Manager.entrySet());
        String s = "Коллекция бла сохранена";
        return new Respond(s);
    }
}

