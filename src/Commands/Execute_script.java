package Commands;

import work.Validator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Execute_script {
    private static Scanner scanner;
    static final List<String> pathList = new ArrayList<>();
    public Execute_script(Scanner scanner){
        this.scanner = scanner;
    }

    public static void deleteLastPath() {
        pathList.remove(pathList.size()-1);
    }

    public static List<String> getPathList(){
        return pathList;
    }

    public Scanner execute(Object argument) {
        try {
            if(!pathList.contains(argument)) {
                File file = new File((String) argument);
                scanner = new Scanner(file);
                Validator.setScanner(scanner);
                pathList.add((String) argument);
                System.out.println("Скрипт начали читать");
            }else{
                System.out.println("Скрипт уже читается");
            }
        }catch (Exception e){
            System.out.println(e.getClass());
            System.out.println("Неверный путь к файлу");
        }
        return scanner;
    }
}
