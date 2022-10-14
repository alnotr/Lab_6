package Commands;

import work.Manager;
import work.Respond;

public class Exit extends AbstractCommand{
    public Exit(Manager collection) {
        super(collection);
    }


    @Override
    public Respond execute(Object argument) {
        String s = "Спасибо за использование приложения";
        return new Respond(s);
    }
}
