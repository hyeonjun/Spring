package Facade;

public class Reader {

    private final String fileName;

    public Reader(String fileName) {
        this.fileName = fileName;
    }

    public void fileConnect() {
        String msg = String.format("Reader %s Connect", fileName);
        System.out.println(msg);
    }

    public void fileRead() {
        String msg = String.format("Reader %s Read", fileName);
        System.out.println(msg);
    }

    public void fileDisConnect() {
        String msg = String.format("Reader %s disConnect", fileName);
        System.out.println(msg);
    }
}
