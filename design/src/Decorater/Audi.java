package Decorater;

public class Audi implements ICar {

    private final int price;

    public Audi(int price) {
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void showPrice() {
        System.out.println("audi의 가격: "+price+"원");
    }
}
