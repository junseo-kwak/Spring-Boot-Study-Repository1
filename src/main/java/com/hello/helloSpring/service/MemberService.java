package com.hello.helloSpring.service;

import com.hello.helloSpring.domain.Member;
import com.hello.helloSpring.repository.MemberRepository;
import com.hello.helloSpring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository repository;
    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    /*
     회원가입
     */
        
    public Long join(Member member){
//        Optional<Member> result = repository.findByName(member.getName());
//        result.ifPresent(m-> {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });
        validateMemberName(member);
        repository.save(member);
        return member.getId();
        }

    private void validateMemberName(Member member) {
        repository.findByName(member.getName()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }


    /*
       전체회원조회
     */

    public List<Member> findMembers(){
        return repository.findAll();
    }

    /*
        특정 회원 조회
     */

    public Optional<Member> findOne(Member member){
        return repository.findById(member.getId());
    }

}
