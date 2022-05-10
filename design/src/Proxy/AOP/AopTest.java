package Proxy.AOP;

import Proxy.IBrowser;

import java.util.concurrent.atomic.AtomicLong;

public class AopTest {

    public static void main(String[] args) {

        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();

        IBrowser aopBrowser = new AopBrowser("www.naver.com",
                () -> {
                    System.out.println("before");
                    start.set(System.currentTimeMillis());
                },
                () -> {
                    long now = System.currentTimeMillis();
                    end.set(now - start.get());
                });

        aopBrowser.show();
        //  AopBrowser html loading from: www.naver.com
        //  AopBrowser html use cache: www.naver.com
        System.out.println("loading time: "+end.get()); // loading time: 1513

        aopBrowser.show(); // AopBrowser html use cache: www.naver.com
        System.out.println("loading time: "+end.get()); // loading time: 0
    }

}
