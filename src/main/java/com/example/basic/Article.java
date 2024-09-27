package com.example.basic;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Article {
    private Long id;
    private String title;
    private String body;
}