package work;

import personParameters.*;
import exception.InputScriptException;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Validator {
    private final Map<String, Command> commandMap = new HashMap<>();
    private static Scanner scanner;
    private String name;
    private int height;
    private Double weight;
    private String passportID;
    private Color eyeColor;
    private long x;
    private Long y;
    private Float locationX;
    private int locationY;
    private Long locationZ;
    private java.time.LocalDateTime creationDate;

    public Validator() {
        initMap();
    }

    public static void setScanner(Scanner scanner) {
        Validator.scanner = scanner;
    }


    public Command validateCommand(String str) {
        return commandMap.getOrDefault(str, null);
    }

    public String validatePath() {
        String path;
        try {
            System.out.println("Введите путь к файлу");
            while (true) {
                try {
                    path = scanner.nextLine();
                    File file = new File(path);
                    if(file.exists() && file.canRead()) {
                        return path;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println("Неверный ввод, попробуйте еще");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object validateElementFromConsole(Command command) {
        if (command.getCommandName().equals("insert") || command.getCommandName().equals("replace_if_greater") || command.getCommandName().equals("replace_if_lower")
                || command.getCommandName().equals("update_id")) {
            int key = 0;
            try {
                try {
                if (command.getCommandName().equals("update_id")) {
                    System.out.println("Введите id для замены");
                    while (true) {
                        try {
                            key = Integer.valueOf(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Неверный ввод");
                        }
                    }
                }
                if (command.getCommandName().equals("replace_if_greater") || command.getCommandName().equals("replace_if_lower")) {
                    System.out.println("Введите ключ для сравнения");
                    while (true) {
                        try {
                            key = Integer.valueOf(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Неверный ввод");
                        }
                    }
                }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("Введите имя");
                while (true) {
                    try {
                        name = scanner.nextLine();
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println("Неверный ввод, попробуйте еще");
                    }
                }
                System.out.println("Введите координату х");
                while (true) {
                    try {
                        x = Long.valueOf(scanner.nextLine());
                        while (Math.abs(x) > 407) {
                            System.out.println("Неверный ввод, попробуйте еще");
                            x = Long.valueOf(scanner.nextLine());
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println("Неверный ввод, попробуйте еще");
                    }
                }
                System.out.println("Введите координату y");
                while (true) {
                    try {
                        y = Long.valueOf(scanner.nextLine());
                        while (Math.abs(y) > 228) {
                            System.out.println("Неверный ввод, попробуйте снова");
                            y = Long.valueOf(scanner.nextLine());
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println("Неверный ввод, попробуйте еще");
                    }
                }
                System.out.println("Введите рост");
                while (true) {
                    try {
                        height = Integer.valueOf(scanner.nextLine());
                        while (Math.abs(height) <= 0) {
                            System.out.println("Неверный ввод, попробуйте еще");
                            height = Integer.valueOf(scanner.nextLine());
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println("Неверный ввод, попробуйте еще");
                    }
                }
                System.out.println("Введите вес");
                while (true) {
                    try {
                        weight = Double.valueOf(scanner.nextLine());
                        while (Math.abs(weight) <= 0) {
                            System.out.println("Неверный ввод, попробуйте еще");
                            weight = Double.valueOf(scanner.nextLine());
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println("Неверный ввод, попробуйте еще");
                    }
                }
                System.out.println("Введите паспортные данные");
                while (true) {
                    try {
                        passportID = scanner.nextLine();
                        if (passportID == "") {
                            passportID = null;
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println("Неверный ввод, попробуйте еще");
                    }
                }
                System.out.println("Введите цвет глаз");
                while (true) {
                    try {
                        for (Color c : Color.values()) {
                            System.out.println(c);
                        }
                        String str = scanner.nextLine();
                        if (str == "") {
                            eyeColor = null;
                        } else {
                            eyeColor = Color.valueOf(str);
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println("Неверный ввод, попробуйте еще");
                    }
                }

                System.out.println("Введите координату x локации");
                while (true) {
                    try {
                        locationX = Float.valueOf(scanner.nextLine());
                        ;
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println("Неверный ввод, попробуйте еще");
                    }
                }

                System.out.println("Введите координату y локации");
                while (true) {
                    try {
                        locationY = Integer.valueOf(scanner.nextLine());
                        ;
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println("Неверный ввод, попробуйте еще");
                    }
                }

                System.out.println("Введите координату z локации");
                while (true) {
                    try {
                        locationZ = Long.valueOf(scanner.nextLine());
                        ;
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println("Неверный ввод, попробуйте еще");
                    }
                }
                if (command.getCommandName().equals("insert")) {
                    return new Person(name, new Coordinates(x, y), height, weight,
                            passportID, eyeColor, new Location(locationX, locationY, locationZ));
                } else {
                    return new Person(key, name, new Coordinates(x, y), height, weight,
                            passportID, eyeColor, new Location(locationX, locationY, locationZ));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (command.getCommandName().equals("remove_all_by_eye_color")) {
            System.out.println("Введите цвет глаз");
            while (true) {
                try {
                    for (Color c : Color.values()) {
                        System.out.println(c);
                    }
                    String str = scanner.nextLine();
                    if (str == "") {
                        eyeColor = null;
                    } else {
                        eyeColor = Color.valueOf(str);
                        return eyeColor;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println("Неверный ввод, попробуйте еще");
                }
            }
        }
        if (command.getCommandName().equals("remove_lower_key") || command.getCommandName().equals("remove_key")) {
            System.out.println("Введите ключ");
            int key;
            while (true) {
                try {
                    key = Integer.valueOf(scanner.nextLine());
                    return key;
                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Неверный ввод");
                }
            }
        }
        if(command.getCommandName().equals("count_less_than_passport_id")){
            System.out.println("Введите паспортные данные");
            while (true) {
                try {
                    passportID = scanner.nextLine();
                    if (passportID == "") {
                        passportID = null;
                    }
                    return passportID;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println("Неверный ввод, попробуйте еще");
                }
            }
        }
        if(command.getCommandName().equals("count_greater_than_weight")){
            System.out.println("Введите вес");
            while (true) {
                try {
                    weight = Double.valueOf(scanner.nextLine());
                    while (Math.abs(weight) <= 0) {
                        System.out.println("Неверный ввод, попробуйте еще");
                        weight = Double.valueOf(scanner.nextLine());
                    }
                    return weight;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println("Неверный ввод, попробуйте еще");
                }
            }
        }
        return null;
    }


    public Object validateElementFromScript(String commandName) throws InputScriptException {
        if (commandName.equals("insert") || commandName.equals("replace_if_greater") || commandName.equals("replace_if_lower")
                || commandName.equals("update_id")) {
            int key = 0;
            try {
                try {
                    if (commandName.equals("update_id") || commandName.equals("replace_if_greater") || commandName.equals("replace_if_lower")) {
                        key = Integer.parseInt(scanner.nextLine());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String name = scanner.nextLine();
                if (name.equals("")) {
                    throw new InputScriptException();
                }
                long x = Long.parseLong(scanner.nextLine());
                if (x > 407) {
                    throw new InputScriptException();
                }
                long y = Long.parseLong(scanner.nextLine());
                if (y > 228) {
                    throw new InputScriptException();
                }
                int height = Integer.parseInt(scanner.nextLine());
                if (height <= 0) {
                    throw new InputScriptException();
                }
                double weight = Double.parseDouble(scanner.nextLine());
                if (weight <= 0) {
                    throw new InputScriptException();
                }
                String passportId = scanner.nextLine();
                if (passportId.equals("")) {
                    throw new InputScriptException();
                }
                Color color = Color.valueOf(scanner.nextLine());
                String strX = scanner.nextLine();
                if (strX.equals("")) {
                    throw new InputScriptException();
                } else {
                    locationX = Float.valueOf(strX);
                }
                String strY = scanner.nextLine();
                if (strY.equals("")) {
                    throw new InputScriptException();
                } else {
                    locationY = Integer.valueOf(strY);
                }
                String strZ = scanner.nextLine();
                if (strZ.equals("")) {
                    throw new InputScriptException();
                } else {
                    locationZ = Long.valueOf(strZ);
                }
                if (commandName.equals("insert")) {
                    return new Person(name, new Coordinates(x, y), height, weight,
                            passportId, color, new Location(locationX, locationY, locationZ));
                } else {
                    return new Person(key, name, new Coordinates(x, y), height, weight,
                            passportId, color, new Location(locationX, locationY, locationZ));
                }
            } catch (InputScriptException e) {
                e.printStackTrace();
            }
        }
        if (commandName.equals("remove_all_by_eye_color")) {
            Color color = Color.valueOf(scanner.nextLine());
            return color;
        }
        if (commandName.equals("remove_lower_key") || commandName.equals("remove_key")) {
            int i = Integer.valueOf(scanner.nextLine());
            return i;
        }
        if (commandName.equals("count_less_than_passport_id")) {
            String s = scanner.nextLine();
            return s;
        }
        if (commandName.equals("count_greater_than_weight")) {
            Double weight = Double.valueOf(scanner.nextLine());
            return weight;
        }
        return null;
    }


    public void initMap() {
        commandMap.put("info", new Command("info"));
        commandMap.put("help", new Command("help"));
        commandMap.put("show", new Command("show"));
        commandMap.put("insert", new Command("insert"));
        commandMap.put("remove_all_by_eye_color", new Command("remove_all_by_eye_color"));
        commandMap.put("execute_script", new Command("execute_script"));
        commandMap.put("exit", new Command("exit"));
        commandMap.put("replace_if_greater", new Command("replace_if_greater"));
        commandMap.put("replace_if_lower", new Command("replace_if_lower"));
        commandMap.put("update_id", new Command("update_id"));
        commandMap.put("remove_lower_key", new Command("remove_lower_key"));
        commandMap.put("count_less_than_passport_id", new Command("count_less_than_passport_id"));
        commandMap.put("count_greater_than_weight", new Command("count_greater_than_weight"));
        commandMap.put("remove_key", new Command("remove_key"));
        commandMap.put("clear", new Command("clear"));
    }
}