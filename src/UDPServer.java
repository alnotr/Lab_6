import exception.InputScriptException;
import work.*;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.logging.Logger;

public class UDPServer {
    private static Manager collectionManager = new Manager();
    static Logger logger = Logger.getLogger(UDPServer.class.getName());
    private static Invoker invoker = new Invoker(collectionManager);
    public final static int SERVICE_PORT = 50002;
    static ByteBuffer receivingDataBuffer = ByteBuffer.allocate(10240);
    static ByteBuffer sendingDataBuffer = ByteBuffer.allocate(10240);
    private static boolean flag = true;
    static DatagramChannel server;
    static Selector selector;
    private static SocketAddress remoteAdd;

    public UDPServer(Manager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, InputScriptException {
        server = DatagramChannel.open();
        InetSocketAddress iAdd = new InetSocketAddress("localhost", SERVICE_PORT);
        server.bind(iAdd);
        Respond r;
        logger.info("Server started:" + iAdd);
        Parser.start(collectionManager);
        while (flag) {
            Command command = read();
            logger.info("Был получен запрос на выполнение команды: " + command.getCommandName());
            if (command.getCommandName().equals("exit")) {
                flag = false;
                Command save = new Command("save");
                invoker.execute(save);
            }
            r = invoker.execute(command);
            logger.info("Команда была выполнена");
            write(r, remoteAdd);
            logger.info("Клиенту был отправлен ответ");
            if (!flag) {
                logger.info("Сервер закончил свою работу");
            }
        }
        server.close();
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

    private static Command read() throws IOException, ClassNotFoundException {
        receivingDataBuffer.clear();
        server.socket().setSoTimeout(10);
        remoteAdd = server.receive(receivingDataBuffer);
        receivingDataBuffer.flip();
        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(receivingDataBuffer.array()));
        return (Command) objectInputStream.readObject();
    }


    private static void write(Respond respond, SocketAddress remoteAdd) throws IOException {
        sendingDataBuffer.clear();
        sendingDataBuffer.put(serialize(respond));
        sendingDataBuffer.flip();
        server.send(sendingDataBuffer, remoteAdd);
    }
}
