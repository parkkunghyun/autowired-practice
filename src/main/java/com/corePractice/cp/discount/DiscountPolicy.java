package com.corePractice.cp.discount;

import com.corePractice.cp.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
