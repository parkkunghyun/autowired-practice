package com.corePractice.cp.order;

import com.corePractice.cp.AutoAppConfig;
import com.corePractice.cp.member.Grade;
import com.corePractice.cp.member.Member;
import com.corePractice.cp.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        memberService = ac.getBean("memberServiceImpl", MemberService.class);
        orderService = ac.getBean("orderServiceImpl", OrderService.class);
    }

    @Test
    void createOrder() {
        Long memberId= 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "n1", 10000);
        System.out.println(order.getDiscountPrice());
        System.out.println(order.getItemName());
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
