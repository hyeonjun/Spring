package Facade;

public class Writer {

    private final String fileName;

    public Writer(String fileName) {
        this.fileName = fileName;
    }

    public void fileConnect() {
        String msg = String.format("Writer %s Connect", fileName);
        System.out.println(msg);
    }

    public void fileWrite() {
        String msg = String.format("Writer %s Write", fileName);
        System.out.println(msg);
    }

    public void  fileDisConnect() {
        String msg = String.format("Writer %s disConnect", fileName);
        System.out.println(msg);
    }

}
