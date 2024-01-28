package com.rp.sec05;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec03HotPublish {

    public static void main(String[] args) {

        // share = publish().refCount(1)
        Flux<String> movieStream = Flux.fromStream(() -> getMovie())
                .delayElements(Duration.ofSeconds(1))
                        .publish()
                                .refCount(1);


        movieStream
                .subscribe(Util.subscriber("Sam"));

        Util.sleepSeconds(10);

        movieStream
                .subscribe(Util.subscriber("Mike"));

        Util.sleepSeconds(60);



    }
    // movie theatre
    private static Stream<String> getMovie() {
        System.out.println("Got the movie streaming req");
        return Stream.of(
                "Scene1",
                "Scene2",
                "Scene3",
                "Scene4",
                "Scene5",
                "Scene6",
                "Scene7"
        );
    }

}