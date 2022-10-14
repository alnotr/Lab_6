package Commands;

import work.Manager;
import work.Respond;

import java.util.ArrayList;
import java.util.List;

public class Help extends AbstractCommand {
    public Help(Manager collection) {
        super(collection);
    }

    @Override
    public Respond execute(Object argument) {
        List<Object> help = new ArrayList<>();
        help.add("help : вывести справку по доступным командам");
        help.add("info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
        help.add("show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        help.add("insert : добавить новый элемент с заданным ключом");
        help.add("update_id : обновить значение элемента коллекции, id которого равен заданному");
        help.add("remove_key : удалить элемент из коллекции по его ключу");
        help.add("clear : очистить коллекцию");
        help.add("exit : завершить программу (без сохранения в файл)");
        help.add("replace_if_greater : заменить значение по ключу, если новое значение больше старого");
        help.add("replace_if_lower: заменить значение по ключу, если новое значение меньше старого");
        help.add("remove_lower_key : удалить из коллекции все элементы, ключ которых меньше, чем заданный");
        help.add("remove_all_by_eye_color : удалить из коллекции все элементы, значение поля eyeColor которого эквивалентно заданному");
        help.add("count_less_than_passport_id : вывести количество элементов, значение поля passportID которых меньше заданного");
        help.add("count_greater_than_weight : вывести количество элементов, значение поля weight которых больше заданного");
        help.add("execute_script: считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
        String ans = "";
        for (Object string : help) {
            ans += string + "\n";
        }
        return new Respond(ans);
    }
}
