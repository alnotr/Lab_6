package Commands;

import work.*;

public abstract class AbstractCommand {
    final Manager manager;

    public AbstractCommand(Manager collection) {
        manager = collection;
    }

    public abstract Respond execute(Object argument);

}
