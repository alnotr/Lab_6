package work;

import Commands.*;
import exception.*;

import java.util.HashMap;
import java.util.Map;

public class Invoker {
    private final Manager collectionManager;
    private final Map<String, AbstractCommand> commands = new HashMap<>();

    public Invoker(Manager manager) {
        collectionManager = manager;
        initMap();
    }

    public void initMap() {
        commands.put("info", new Info(collectionManager));
        commands.put("help", new Help(collectionManager));
        commands.put("show", new Show(collectionManager));
        commands.put("insert", new Insert(collectionManager));
        commands.put("remove_all_by_eye_color", new Remove_all_by_eye_color(collectionManager));
        commands.put("exit", new Exit(collectionManager));
        commands.put("save", new Save(collectionManager));
        commands.put("replace_if_greater", new Replace_if_greater(collectionManager));
        commands.put("replace_if_lower", new Replace_if_lower(collectionManager));
        commands.put("remove_lower_key", new Remove_lower_key(collectionManager));
        commands.put("count_less_than_passport_id", new Count_less_than_passport_id(collectionManager));
        commands.put("count_greater_than_weight", new Count_greater_than_weight(collectionManager));
        commands.put("update_id", new Update_id(collectionManager));
        commands.put("remove_key", new Remove_key(collectionManager));
        commands.put("clear", new Clear(collectionManager));
    }

    public Map<String, AbstractCommand> getCommands() {
        return commands;
    }

    public Respond execute(Command newCommand) throws InputScriptException {
        AbstractCommand command = commands.get(newCommand.getCommandName());
        return command.execute(newCommand.getArgument());
    }
}

