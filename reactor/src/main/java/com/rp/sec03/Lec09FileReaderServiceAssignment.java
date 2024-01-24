package com.rp.sec03;

import com.rp.courseutil.Util;
import com.rp.sec03.assignment.FileReaderService;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Lec09FileReaderServiceAssignment {

    public static void main(String[] args) {

        FileReaderService readerService = new FileReaderService();

        Path path = Paths.get("src/main/java/com/rp/sec03/scratch.txt");
        readerService.read(path)
                .subscribe(Util.subscriber());


    }
}
