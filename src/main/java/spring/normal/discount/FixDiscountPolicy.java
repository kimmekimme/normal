package spring.normal.discount;

import spring.normal.member.Grade;
import spring.normal.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000;
//VIP면 1000원 할인, 아니면 할인없음
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        }else
            return 0;
    }
}
