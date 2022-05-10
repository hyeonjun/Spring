package Singleton;

public class BClass {

    private final SocketClient socketClient;

    public BClass() {
        this.socketClient = SocketClient.getInstance();
    }

    public SocketClient getSocketClient() {
        return this.socketClient;
    }

}
