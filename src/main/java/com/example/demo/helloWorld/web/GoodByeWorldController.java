package com.example.demo.helloWorld.web;

import com.example.demo.helloWorld.vo.Contents;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GoodByeWorldController {

    private static final String template = "Good Bye %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/getGoodByeWorld")
    public Contents getGoodByeWorld(@RequestParam(value = "name", defaultValue = "World") String name){
        return new Contents(counter.incrementAndGet(), String.format(template, name));
    }
}
