package com.example.basic.domain.auth.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pk 자동 증가 옵션
    private long id; // 관리의 용이성을 위해 pk를 숫자로 따로 만듬

    @Column(unique = true)
    private String username; // 로그인 아이디
    private String password;
    private String role;
}
