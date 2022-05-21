public class DollerCalculator implements ICalculator {

    private int price = 1;
    private MarketApi marketApi;

    public DollerCalculator (MarketApi marketApi) {
        this.marketApi = marketApi;
    }

    public void init() {
        this.price = marketApi.connect();
    }

    @Override
    public int add(int x, int y) {
        return x * price + y * price;
    }

    @Override
    public int sub(int x, int y) {
        return x * price - y * price;
    }
}
