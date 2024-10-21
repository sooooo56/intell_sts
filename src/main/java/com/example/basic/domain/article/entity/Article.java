package com.example.basic.domain.article.entity;

import com.example.basic.domain.auth.entity.Member;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String body;
//    private long memberId; // 회원 번호

    // 게시글(N) - 회원(1)
    // 한명의 회원이 여러개의 게시글을 다룬다
    // Article을 기준으로 many
    // Member은 one
    @ManyToOne
    @JoinColumn(name = "author_id") //외래키 이름 설정
    // 외래키 이름설정을 안하면 member_id로 지정됨
    private Member author;
}