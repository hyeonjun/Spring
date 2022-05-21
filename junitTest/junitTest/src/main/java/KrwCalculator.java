public class KrwCalculator implements ICalculator {

    private int price = 1;

    @Override
    public int add(int x, int y) {
        return x * price + y * price;
    }

    @Override
    public int sub(int x, int y) {
        return x * price - y * price;
    }
}
