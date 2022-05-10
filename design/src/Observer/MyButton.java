package Observer;

public class MyButton {
    private final String name;
    private IButtonClickListener buttonClickListener;

    public MyButton(String name) {
        this.name = name;
    }

    public void click(String message) {
        buttonClickListener.clickEvent(message);
    }

    public void addListener(IButtonClickListener buttonClickListener) {
        this.buttonClickListener = buttonClickListener;
    }
}
