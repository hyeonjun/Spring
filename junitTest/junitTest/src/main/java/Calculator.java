public class Calculator {

    private ICalculator iCalculator;

    public Calculator(ICalculator iCalculator) {
        this.iCalculator = iCalculator;
    }

    public int add(int x, int y) {
        return this.iCalculator.add(x, y);
    }

    public int sub(int x, int y) {
        return this.iCalculator.sub(x, y);
    }


}
