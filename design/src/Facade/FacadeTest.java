package Facade;

public class FacadeTest {

    public static void main(String[] args) {
        /*Ftp ftpClient = new Ftp("www.foo.co.kr", 22, "/home/etc");
        ftpClient.connect();
        ftpClient.moveDirectory();

        Writer writer = new Writer("text.tmp");
        writer.fileConnect();
        writer.fileWrite();

        Reader reader = new Reader("text.tmp");
        reader.fileConnect();
        reader.fileRead();

        reader.fileDisConnect();
        writer.fileDisConnect();
        ftpClient.disConnect();*/

        StfpClient stfpClient = new StfpClient("www.foo.co.kr", 22, "/home/etc", "text.tmp");
        stfpClient.connect();
        stfpClient.write();
        stfpClient.read();
        stfpClient.disConnect();



    }

}
