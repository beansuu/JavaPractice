package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lex05MonoFromSupplier {

    public static void main(String[] args) {

        // only use if you have data already
       //  Mono<String> mono = Mono.just(getName());

        Mono<String> mono = Mono.fromSupplier(() -> getName());
        mono.subscribe(
                Util.onNext()
        );

    }

    private static String getName() {
        System.out.println("Generating name..");
        return Util.faker().name().firstName();
    }
}
