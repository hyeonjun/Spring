public class Main {

    public static void main(String[] args) {
        System.out.println("hello JUnit");

        MarketApi marketApi = new MarketApi();

        KrwCalculator krwCalculator = new KrwCalculator();

        DollerCalculator dollerCalculator = new DollerCalculator(marketApi);
        dollerCalculator.init();

        Calculator calculator = new Calculator(krwCalculator);
        System.out.println(calculator.add(10 ,10));

        calculator = new Calculator(dollerCalculator);
        System.out.println(calculator.add(10, 30));

    }
}
