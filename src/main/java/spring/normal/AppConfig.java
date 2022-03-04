package spring.normal;

import spring.normal.discount.DiscountPolicy;
import spring.normal.discount.FixDiscountPolicy;
import spring.normal.discount.RateDiscountPolicy;
import spring.normal.member.MemberRepository;
import spring.normal.member.MemberService;
import spring.normal.member.MemberServiceImpl;
import spring.normal.member.MemoryMemberRepository;
import spring.normal.order.OrderService;
import spring.normal.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
