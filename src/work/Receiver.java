/*package work;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Receiver {

    final Manager collectionManager;
    private final Invoker invoker;
    private final Deque<String> executedFiles = new ArrayDeque<>();
    private Scanner scanner;
    private boolean flag;
    private boolean readFromFileStatus;

    *//**
     * Class constructor
     * @param collectionManager
     * @param invoker
     *//*
    public Receiver(Manager collectionManager, Invoker invoker) {
        this.invoker = invoker;
        this.collectionManager = collectionManager;
        scanner = new Scanner(System.in);
        flag = true;
        Validator.setScanner(scanner);
        readFromFileStatus = false;
    }

    *//**
     * Method to read a command from console and to call the invoker
     *//*
    public void start(){
        while (flag) {
            try {
                String[] newLine = new String[2];
                if(!readFromFileStatus){
                    System.out.println("Введите команду");
                    newLine = readLine().split(" ");
                }else{
                    if (scanner.hasNext()){
                        newLine = readLine().split(" ");
                    }else{
                        //executedFiles.removeFirst();
                        //if (executedFiles.isEmpty()) {
                            changeScanner();
                            continue;
                        }
                    }
                //}
                String request = newLine[0];
                String probablyArgument = null;
                if (newLine.length == 2) {
                    probablyArgument = newLine[1];
                }
                if (request.equals("exit")) {
                    flag = false;
                    continue;
                }
                if(request.equals("execute_script")){
                    executeScript(probablyArgument);
                    continue;
                }
                invoker.execute(request, probablyArgument, readFromFileStatus);
            } catch (IOException e) {
                e.getStackTrace();
            }
        }
    }

    *//**
     * Method to read a new line from console or file
     * @return String
     * @throws IOException
     *//*
    private String readLine() throws IOException{
        return scanner.nextLine();
    }

    *//**
     * Method to change scanner's path
     *//*
    public void changeScanner(){
        readFromFileStatus = false;
        executedFiles.remove();
        scanner = new Scanner(System.in);
        Validator.setScanner(scanner);
        System.out.println("Команды из скрипта были выполнены");
    }

    *//**
     * Check file path and change parameters to start read the file if everything is right
     * @param path
     * @throws FileNotFoundException
     *//*
    public void executeScript(String path) throws FileNotFoundException {
        if (path.equals("")) {
            System.out.println("Требуется путь к файлу");
            return;
        }
        File file = new File(path);
        if(!(file.exists() && file.canRead())){
            System.out.println("Проблемы с файлом");
            return;
        }
        if(executedFiles.contains(path)){
            System.out.println("Скрипт уже выполняется");
            return;
        }
        executedFiles.addFirst(path);
        scanner = new Scanner(file);
        readFromFileStatus = true;
        Validator.setScanner(scanner);
    }

}*/


