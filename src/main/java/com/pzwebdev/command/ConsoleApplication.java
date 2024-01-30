package com.pzwebdev.command;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleApplication implements CommandLineRunner {

    @Override
    public void run(String... args) {
        System.out.println("Hello Spring ...");
    }
}
