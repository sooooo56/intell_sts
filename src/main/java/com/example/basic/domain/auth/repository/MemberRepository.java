package com.example.basic.domain.auth.repository;

import com.example.basic.domain.auth.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

// <엔터티 클래스 이름, @Id(pk)필드의 데이터 타입>
public interface MemberRepository extends JpaRepository<Member, String> {

    // 저장 -> save

    // 단건(한개만) 가져오기 -> findById

    // 전체 가져오기 - > findAll

    // 삭제 - > delete or deleteById

}
