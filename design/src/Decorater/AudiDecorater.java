package Decorater;

public class AudiDecorater implements ICar {

    protected ICar audi;
    protected String modelName;
    protected int modelPrice;

    public AudiDecorater(ICar audi, String modelName, int modelPrice) {
        this.audi = audi;
        this.modelName = modelName;
        this.modelPrice = modelPrice;
    }

    @Override
    public int getPrice() {
        return audi.getPrice() + modelPrice;
    }

    @Override
    public void showPrice() {
        System.out.println(modelName+"의 가격: "+getPrice()+"원");
    }
}
