package spring.normal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.normal.discount.DiscountPolicy;
import spring.normal.discount.FixDiscountPolicy;
import spring.normal.discount.RateDiscountPolicy;
import spring.normal.member.MemberRepository;
import spring.normal.member.MemberService;
import spring.normal.member.MemberServiceImpl;
import spring.normal.member.MemoryMemberRepository;
import spring.normal.order.OrderService;
import spring.normal.order.OrderServiceImpl;

//IOC(DI) Container
@Configuration //설정 구성
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
