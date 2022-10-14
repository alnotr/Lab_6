import Commands.*;
import exception.InputScriptException;
import work.Command;
import work.Respond;
import work.Validator;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Scanner;

public class UDPClient {
    static Validator validator = new Validator();
    public final static int SERVICE_PORT = 50002;
    static ByteBuffer receivingDataBuffer = ByteBuffer.allocate(10240);
    static ByteBuffer sendingDataBuffer = ByteBuffer.allocate(10240);
    private static Scanner scanner = new Scanner(System.in);
    private static boolean flag = true;
    private static DatagramSocket clientSocket;
    static boolean readFromFileStatus;
    public static DatagramPacket sendingPacket;
    public static DatagramPacket receivingPacket;
    public static InetAddress IPAddress;

    public static void setScanner(Scanner scanner) {
        UDPClient.scanner = scanner;
    }

    public static void setStatus(boolean b){ readFromFileStatus = b;}

    public static void main(String[] args) throws IOException{
        validator.setScanner(scanner);
        IPAddress = InetAddress.getByName("localhost");
        Command command;
        try{
            clientSocket = new DatagramSocket();
            while(flag) {
                if(!readFromFileStatus) {
                    System.out.println("Введите команду");

                    command = readFromConsole(readFromFileStatus);
                    if (command.getCommandName().equals("exit")) {
                        flag = false;
                    }
                    if (command.getCommandName().equals("execute_script")) {
                        String arg = validator.validatePath();
                        command.setArgument(arg);
                        setScanner(new Execute_script(scanner).execute(command.getArgument()));
                        readFromFileStatus = true;
                        continue;
                    }else{
                        Object o = validator.validateElementFromConsole(command);
                        command.setArgument(o);
                    }
                }else{
                    command = readFromConsole(true);
                    if(!readFromFileStatus){
                        continue;
                    }
                    if (command.getCommandName().equals("insert") || command.getCommandName().equals("remove_all_by_eye_color")) {
                        Object o = validator.validateElementFromScript(command.getCommandName());
                        command.setArgument(o);
                    }
                    if (command.getCommandName().equals("exit")) {
                        flag = false;
                    }
                    if (command.getCommandName().equals("execute_script")) {
                        setScanner(new Execute_script(scanner).execute(command.getArgument()));
                        readFromFileStatus = true;
                        continue;
                    }
                }

                write(command);
                read();
            }
            clientSocket.close();
        }catch (SocketException e){
            e.getMessage();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InputScriptException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static String readLine() {
        return scanner.nextLine();
    }

    private static byte[] serialize(Object obj) throws IOException {
        try (ByteArrayOutputStream b = new ByteArrayOutputStream()) {
            try (ObjectOutputStream o = new ObjectOutputStream(b)) {
                o.writeObject(obj);
            }catch (Exception e){
                e.getMessage();
            }
            return b.toByteArray();
        }
    }
    private static Command readFromConsole(boolean readFromFileStatus) {
        boolean flag1 = true;
        Command newCommand = null;
        if(readFromFileStatus) {
            if (!scanner.hasNext()) {
                List<String> pathList = Execute_script.getPathList();
                Execute_script.deleteLastPath();
                if (pathList.size() > 0) {
                    scanner = new Scanner(pathList.get(pathList.size() - 1));
                    Validator.setScanner(scanner);
                    setScanner(scanner);
                } else {
                    scanner = new Scanner(System.in);
                    setStatus(false);
                    Validator.setScanner(scanner);
                    setScanner(scanner);
                    return null;
                }
            }
        }

        while (flag1) {
            receivingDataBuffer.clear();
            String s = readLine();
            newCommand = validator.validateCommand(s);
            if (newCommand == null) {
                System.out.println("Неверная команда");
            } else {
                flag1 = false;
            }

        }
        return newCommand;
    }

    private static void write(Command command) throws IOException {
        sendingDataBuffer = ByteBuffer.wrap(serialize(command));
        sendingDataBuffer.flip();
        sendingPacket = new DatagramPacket(sendingDataBuffer.array(), sendingDataBuffer.capacity(), IPAddress, SERVICE_PORT);
        clientSocket.send(sendingPacket);
        sendingDataBuffer.clear();
    }
    private static void read() throws IOException, ClassNotFoundException {
        receivingPacket = new DatagramPacket(receivingDataBuffer.array(), receivingDataBuffer.capacity());
        clientSocket.receive(receivingPacket);
        receivingDataBuffer.wrap(receivingPacket.getData());
        receivingDataBuffer.flip();

        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(receivingDataBuffer.array()));
        Respond respond = (Respond) objectInputStream.readObject();
        System.out.println(respond.answer);
    }
}
