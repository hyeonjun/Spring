package Proxy;

public class ProxyTest {

    public static void main(String[] args) {

//        Browser browser = new Browser("www.naver.com");
//        browser.show(); // BrowserProxy loading html from: www.naver.com
//        browser.show(); // BrowserProxy loading html from: www.naver.com
//        browser.show(); // BrowserProxy loading html from: www.naver.com
//        browser.show(); // BrowserProxy loading html from: www.naver.com
//        browser.show(); // BrowserProxy loading html from: www.naver.com

        IBrowser browser = new BrowserProxy("www.naver.com");
        browser.show(); // BrowserProxy loading html from: www.naver.com
        browser.show(); // BrowserProxy use cache html: www.naver.com
        browser.show(); // BrowserProxy use cache html: www.naver.com
        browser.show(); // BrowserProxy use cache html: www.naver.com
        browser.show(); // BrowserProxy use cache html: www.naver.com

    }
}
