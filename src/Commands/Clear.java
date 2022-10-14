package Commands;
import work.*;
import personParameters.*;
import java.util.List;

public class Clear extends AbstractCommand {
    public Clear(Manager collection) {
        super(collection);
    }

    @Override
    public Respond execute(Object argument){
        String s = null;
        List<Person> collection = Manager.getAllElements();
        if(collection.size() == 0){
            s = "Коллекция пуста";
        }
        if(collection.size() != 0){
            s = "Коллекция была удалена";
            Manager.clear();
        }
        return new Respond(s);
    }
}
