package Observer;

public class ObserverTest {

    public static void main(String[] args) {
        MyButton button = new MyButton("버튼");

        button.addListener(System.out::println);
        button.click("click1");
        button.click("click2");
        button.click("click3");

        IButtonClickListener listener = event -> System.out.println("click" + event);
        button.addListener(listener);
        button.click("1");
        button.click("2");
        button.click("3");



    }
}
