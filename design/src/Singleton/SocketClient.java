package Singleton;

public class SocketClient {

    // 자기 자신을 객체로 가지고 있어야 함
    private static SocketClient socketClient = null;

    // 기본 생성자를 private로 막아야 함
    private SocketClient() {}

    // static 메서드를 통해 인스턴스를 전달함
    // 외부에서 접근 가능하도록 함
    // 객체를 최소 한번만 메모리에 로딩되도록 함
    public static SocketClient getInstance() {
        if (socketClient == null) {
            socketClient = new SocketClient();
        }
        return socketClient;
    }

    public void connect() {
        System.out.println("connect");
    }

}
