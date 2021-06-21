package com.hello.helloSpring;

import com.hello.helloSpring.aop.TimeTraceAop;
import com.hello.helloSpring.repository.JdbcTempleteMemberRepository;
import com.hello.helloSpring.repository.JpaMemberRepository;
import com.hello.helloSpring.repository.MemberRepository;
import com.hello.helloSpring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.sql.Time;

@Configuration
public class SpringConfig {

//    @Autowired
//    private final DataSource dataSource;
//
//    public SpringConfig(DataSource dataSource) {
//          this.dataSource = dataSource;
//    }

//    @Autowired
//    private EntityManager em;
//
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

//    @Bean
//    public TimeTraceAop timeTraceAop(){
//        return new TimeTraceAop();
//    }
//
//    @Bean
//    public MemberRepository memberRepository(){
////        return new MemoryMemberRepository();
////        return new JdbcTempleteMemberRepository(dataSource);
////          return new JpaMemberRepository(em);
//    }



}
