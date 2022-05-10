package Singleton;

public class AClass {

    private final SocketClient socketClient;

    public AClass() {
        this.socketClient = SocketClient.getInstance();
    }

    public SocketClient getSocketClient() {
        return this.socketClient;
    }

}
