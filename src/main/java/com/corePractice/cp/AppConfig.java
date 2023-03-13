package com.corePractice.cp;

import com.corePractice.cp.discount.DiscountPolicy;
import com.corePractice.cp.discount.RateDiscountPolicy;
import com.corePractice.cp.member.MemberRepository;
import com.corePractice.cp.member.MemberService;
import com.corePractice.cp.member.MemberServiceImpl;
import com.corePractice.cp.member.MemoryMemberRepository;
import com.corePractice.cp.order.OrderService;
import com.corePractice.cp.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return  new RateDiscountPolicy();
    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
}
