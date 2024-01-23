package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec08MonoFromRunnable {

    public static void main(String[] args) {

        Runnable runnable = () -> System.out.println("");


        Mono.fromRunnable(runnable)
                .subscribe(Util.onNext(),
                        Util.onError(),
                        () -> {
                            System.out.println("Process done. Sending emails for example");
                        });
    }
    private static Runnable timeConsumingProcess() {
        return () -> {
            Util.sleepSeconds(3);
            System.out.println("Operation completed");
        };
    }
}
