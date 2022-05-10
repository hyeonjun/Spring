package Facade;

public class Ftp {

    private final String host;
    private final int port;
    private final String path;

    public Ftp(String host, int port, String path) {
        this.host = host;
        this.port = port;
        this.path = path;
    }

    public void connect() {
        System.out.println("FTP Host: " + host +" Port: "+port +" Connect");
    }

    public void moveDirectory() {
        System.out.println("Path: " + path + "move");
    }

    public void disConnect() {
        System.out.println("FTP disConnected");
    }
}
