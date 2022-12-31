package com.example.demo.helloWorld.vo;

public class Contents {
    private final long id;
    private final String content;

    public Contents(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
