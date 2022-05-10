package Adapter;

public class AdapterTest {
    public static void main(String[] args) {

        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);

        Cleaner cleaner = new Cleaner();
        // connect 메서드가 Electronic110V를 받기 때문에 Electronic220V를
        // 상속받은 Cleaner를 사용하기 위해서는 Adapter를 만들어 변환을 시켜줘야 함
        // connect(cleaner); -> 에러
        Electronic110V adapterCleaner = new SocketAdapter(cleaner);
        connect(adapterCleaner);

        AirConditioner airConditioner = new AirConditioner();
        Electronic110V adapterAir = new SocketAdapter(airConditioner);
        connect(adapterAir);

    }

    // 콘센트
    public static void connect(Electronic110V electronic110V) {
        electronic110V.powerOn();
    }
}
