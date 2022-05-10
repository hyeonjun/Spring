package Proxy;

public class Browser implements IBrowser {

    private final String url;

    public Browser(String url) {
        this.url = url;
    }


    @Override
    public Html show() {
        System.out.println("browser loading html form: "+url);
        return new Html(url);
    }
}
