package com.psg.ramasubramanin.linkedin.model;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class Publication implements Serializable {

    private String title;
    private String content;
    private Integer year;

    public Publication(String title, String content, Integer year) {
        this.title = title;
        this.content = content;
        this.year = year;
    }
}
