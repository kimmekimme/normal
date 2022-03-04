package spring.normal;

import spring.normal.member.Grade;
import spring.normal.member.Member;
import spring.normal.member.MemberService;
import spring.normal.member.MemberServiceImpl;
import spring.normal.order.Order;
import spring.normal.order.OrderService;
import spring.normal.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);

    }
}
