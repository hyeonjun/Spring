package Proxy;

public class BrowserProxy implements IBrowser {

    private final String url;
    private Html html;

    public BrowserProxy(String url) {
        this.url = url;
    }

    @Override
    public Html show() {
        // caching
        if (html == null) {
            this.html = new Html(url);
            System.out.println("BrowserProxy loading html from: "+url);
        }
        System.out.println("BrowserProxy use cache html: "+url);
        return html;
    }
}
