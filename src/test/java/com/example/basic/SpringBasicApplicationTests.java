package com.example.basic;

import com.example.basic.domain.auth.dao.MemberDao;
import com.example.basic.domain.auth.entity.Member;
import com.example.basic.domain.auth.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class SpringBasicApplicationTests {

    @Autowired
    private MemberDao memberDao;
    @Autowired
    private MemberRepository memberRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void test() {
        Member member2 = Member.builder()
                .username("kim")
                .password("qwer")
                .role("normal")
                .build();

        memberDao.save(member2);
    }

    @Test
    @DisplayName("회원 저장")
    void t3() {
        Member member2 = Member.builder()
                .username("kim")
                .password("qwer")
                .role("normal")
                .build();

        memberRepository.save(member2);
    }

    @Test
    @DisplayName("회원 전체 조회 - findAll")
    void t4() {
        List<Member> memberList = memberRepository.findAll();

        for (Member member : memberList) {
            System.out.println(member.getUsername());
        }
    }

    @Test
    @DisplayName("회원 단건 조회 - findById")
    void t5() {
        Optional<Member> memberOpt = memberRepository.findById("kim");

        if (memberOpt.isPresent()) {
            Member member = memberOpt.get();

            System.out.println(member.getUsername());
            System.out.println(member.getPassword());
            System.out.println(member.getRole());
        }
    }

    @Test
    @DisplayName("회원 삭제 - delete , deleteById")
    void t6() {
        // 방법 1. id로 삭제
        memberRepository.deleteById("kim");

        Optional<Member> memberOpt = memberRepository.findById("kim");
        Member member = memberOpt.get();

        // 방법 2. entity 삭제
        memberRepository.delete(member);

    }

    @Test
    @DisplayName("회원 수정 - save")
    void test7(){
        Optional<Member> memberOpt = memberRepository.findById("kim");
        Member member = memberOpt.get();

        System.out.println(member.getUsername() + " : " + member.getRole());

        member.setRole("admin"); // 엔터티의 값을 바꾸고
        memberRepository.save(member); // 엔터티 다시 저장

    }

}
