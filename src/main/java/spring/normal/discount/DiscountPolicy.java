package spring.normal.discount;

import spring.normal.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);
}
