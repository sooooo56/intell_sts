package com.example.basic;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Article {
    private Long id;
    private String title;
    private String body;
}